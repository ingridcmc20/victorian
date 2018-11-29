package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.domain.OrdenTrabajo;
import com.victorian.produccion.domain.OrdenTrabajoDetalle;
import com.victorian.produccion.domain.OrdenTrabajoOperario;
import com.victorian.produccion.services.NivelServices;
import com.victorian.produccion.services.OperarioServices;
import com.victorian.produccion.services.OrdenTrabajoDetalleServices;
import com.victorian.produccion.services.OrdenTrabajoOperarioServices;
import com.victorian.produccion.services.OrdenTrabajoServices;

@ManagedBean(name = "asignarBonoOperarioMB")
@ViewScoped
public class AsignarBonoOperarioMB extends GenericBeans implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Operario> listaOperarios;
	private OperarioServices operarioServices;
	private OrdenTrabajoServices ordenTrabajoServices;
	private OrdenTrabajoDetalleServices ordenTrabajoDetalleServices;
	private OrdenTrabajoOperarioServices ordenTrabajoOperarioServices;
	private NivelServices nivelServices;
	
	@PostConstruct
	public void inicia() {
		try {
			operarioServices = new OperarioServices();
			ordenTrabajoServices = new OrdenTrabajoServices();
			ordenTrabajoDetalleServices = new OrdenTrabajoDetalleServices();
			ordenTrabajoOperarioServices = new OrdenTrabajoOperarioServices();
			nivelServices = new NivelServices();
			
			listaOperarios = obtenerListaOperarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Operario> obtenerListaOperarios() throws Exception {
		return operarioServices.findCortadorYConfeccion();
	}
	
	public List<Operario> getListaOperarios() {
		return listaOperarios;
	}

	public void setListaOperarios(List<Operario> listaOperarios) {
		this.listaOperarios = listaOperarios;
	}
	
	public void aprobar(Operario operario){
		Date fechaActual = new Date();
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			// Obtener datos			
			OrdenTrabajoOperario ordenTrabajoOperario = ordenTrabajoOperarioServices.findByOperarioYOrdenTrabajo(operario.getId_ordentrabajo(), operario.getId_operario());
			OrdenTrabajo ordenTrabajo = ordenTrabajoServices.findById(ordenTrabajoOperario.getId_ordentrabajo());
			OrdenTrabajoDetalle otd = ordenTrabajoDetalleServices.findByIdOrdenByEstapa(ordenTrabajoOperario.getId_ordentrabajo(), operario.getId_etapa());
			
			if(operario.getFecha_real_fin().getTime() <= operario.getFecha_fin().getTime()){
				// La orden de trabajo se encuentra en curso
				ordenTrabajo.setId_estado(Constante.OT_EN_CURSO);
				// Culminar la etapa
				otd.setId_estado(Constante.OT_TERMINADO);
				
				// Sumar puntos al operario	
				if(ordenTrabajoOperario.getPuntaje_obtenido() == null){
					ordenTrabajoOperario.setPuntaje_obtenido(0);
				}
				
				ordenTrabajoOperario.setPuntaje_obtenido(ordenTrabajoOperario.getPuntaje_obtenido()+1);
				
				// Subir de nivel si lo ameria al operario
				if(operario.getPuntaje_acumulado() == null){
					operario.setPuntaje_acumulado(0);
				}
				int puntaje = operario.getPuntaje_acumulado() + ordenTrabajoOperario.getPuntaje_obtenido();
				
				Integer id_nivel = nivelServices.findIdNivelByPuntaje(puntaje);
				
				operario.setId_nivel(operario.getId_nivel()!=null?operario.getId_nivel():0);
				
				System.out.println("id_nivel: " + id_nivel.intValue());
				System.out.println("id_nivel operario: " + operario.getId_nivel().intValue());
				
				if(operario.getId_nivel().intValue() < id_nivel.intValue()){
					operario.setPuntaje_acumulado(puntaje);
					ordenTrabajoOperario.setPuntaje_obtenido(0);
					ordenTrabajoOperario.setId_nivel(id_nivel);
					ordenTrabajoOperario.setFecha_nivel(new java.sql.Timestamp(fechaActual.getTime()));
					ordenTrabajoOperario.setId_operario(operario.getId_operario());
				}
				
				// Actualizaciones finales
				System.out.println("id operario: " + operario.getId_operario());
				System.out.println("Puntaje_acumulado: " + operario.getPuntaje_acumulado());
				operarioServices.updateOperario(operario);
				// Parametros
				ordenTrabajoOperarioServices.updateOrdenTrabajoOperario(ordenTrabajoOperario);
				ordenTrabajoServices.updateEstado(ordenTrabajo);
				ordenTrabajoDetalleServices.updateFechaReal(otd);
				
				context.update("dlgPuntual");
				context.execute("PF('dlgPuntual').show();");
				System.out.println("Lo logro");
			}
			else{
				// La orden de trabajo se encuentra en curso
				ordenTrabajo.setId_estado(Constante.OT_EN_CURSO);
				// Culminar la etapa
				otd.setId_estado(Constante.OT_TERMINADO);
				
				// Actualizaciones finales
				ordenTrabajoServices.updateEstado(ordenTrabajo);
				ordenTrabajoDetalleServices.updateFechaReal(otd);
				
				context.update("dlgTarde");
				context.execute("PF('dlgTarde').show();");
			}
			listaOperarios = obtenerListaOperarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void rechazar(Operario operario){
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			OrdenTrabajo ordenTrabajo = ordenTrabajoServices.findById(operario.getId_ordentrabajo());
			OrdenTrabajoDetalle otd = ordenTrabajoDetalleServices.findByIdOrdenByEstapa(operario.getId_ordentrabajo(), operario.getId_etapa());
			
			System.out.println(operario.getId_operario());
			// La orden de trabajo se encuentra en curso
			ordenTrabajo.setId_estado(Constante.OT_EN_CURSO);
			// Culminar la etapa
			otd.setId_estado(Constante.OT_PENDIENTE);
			
			// Actualizaciones finales
			ordenTrabajoServices.updateEstado(ordenTrabajo);
			ordenTrabajoDetalleServices.updateFechaReal(otd);
			
			context.update("dlgRechazo");
			context.execute("PF('dlgRechazo').show();");
			System.out.println("Se rechaza");
			
			listaOperarios = obtenerListaOperarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
