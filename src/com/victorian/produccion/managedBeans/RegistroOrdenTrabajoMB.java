package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.FacesUtils;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Etapa;
import com.victorian.produccion.domain.FichaTecnica;
import com.victorian.produccion.domain.Maquinaria;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.domain.OrdenTrabajo;
import com.victorian.produccion.domain.OrdenTrabajoDetalle;
import com.victorian.produccion.domain.OrdenTrabajoMaquinaria;
import com.victorian.produccion.domain.OrdenTrabajoOperario;
import com.victorian.produccion.domain.Pedido;
import com.victorian.produccion.domain.PlanProduccion;
import com.victorian.produccion.domain.Prioridad;
import com.victorian.produccion.services.EtapaServices;
import com.victorian.produccion.services.FichaTecnicaServices;
import com.victorian.produccion.services.MaquinariaServices;
import com.victorian.produccion.services.OperarioServices;
import com.victorian.produccion.services.OrdenTrabajoDetalleServices;
import com.victorian.produccion.services.OrdenTrabajoMaquinariaServices;
import com.victorian.produccion.services.OrdenTrabajoOperarioServices;
import com.victorian.produccion.services.OrdenTrabajoServices;
import com.victorian.produccion.services.PedidoServices;
import com.victorian.produccion.services.PlanProduccionServices;
import com.victorian.produccion.services.PrioridadServices;

@ManagedBean(name = "registroOrdenTrabajoMB")
@ViewScoped
public class RegistroOrdenTrabajoMB extends GenericBeans implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OperarioServices operarioServices;
	private MaquinariaServices maquinariaServices;
	private OrdenTrabajoServices ordenTrabajoServices;
	private PrioridadServices prioridadServices;
	private PedidoServices pedidoServices;
	private FichaTecnicaServices fichaTecnicaServices;
	private OrdenTrabajoDetalleServices ordenTrabajoDetalleServices;
	private EtapaServices etapaServices;
	private PlanProduccionServices planProduccionServices;
	private OrdenTrabajoOperarioServices ordenTrabajoOperarioServices;
	private OrdenTrabajoMaquinariaServices ordenTrabajoMaquinariaServices;
	
	private List<OrdenTrabajo> lstOrdenTrabajo;
	private OrdenTrabajo ordenTrabajoSelected;
	private Pedido pedidoSelected;
	
	private List<Prioridad> listPrioridad;
	
	// Listas de recursos
	private List<Operario> lstPDiseno;
	private List<Operario> lstPCorte;
	private List<Operario> lstPConfeccion;
	private List<Operario> lstPEmpaquetado;
	
	private List<Maquinaria> lstMDiseno;
	private List<Maquinaria> lstMCorte;
	private List<Maquinaria> lstMConfeccion;
	private List<Maquinaria> lstMEmpaquetado;
	
	// Seleccionados
	private List<String> lstPDisenoSelected;
	private List<String> lstPCorteSelected;
	private List<String> lstPConfeccionSelected;
	private List<String> lstPEmpaquetadoSelected;
	
	private List<String> lstMCorteSelected;
	private List<String> lstMConfeccionSelected;
	
	@PostConstruct
	public void inicia(){
        try {
    		this.operarioServices = new OperarioServices();
    		this.maquinariaServices = new MaquinariaServices();
    		this.ordenTrabajoServices = new OrdenTrabajoServices();
    		this.prioridadServices = new PrioridadServices();
    		this.pedidoServices = new PedidoServices();
    		this.fichaTecnicaServices = new FichaTecnicaServices();
    		this.ordenTrabajoDetalleServices = new OrdenTrabajoDetalleServices();
    		this.etapaServices = new EtapaServices();
    		this.planProduccionServices = new PlanProduccionServices();
    		this.ordenTrabajoOperarioServices = new OrdenTrabajoOperarioServices();
    		this.ordenTrabajoMaquinariaServices = new OrdenTrabajoMaquinariaServices();
    		
    		// Iniciar objetos
    		this.ordenTrabajoSelected = new OrdenTrabajo();
    		
    		// Iniciar listas
    		this.lstOrdenTrabajo = this.ordenTrabajoServices.findAll();
    		this.listPrioridad = this.prioridadServices.findAll();
    		
    		// Recursos
    		this.lstPDiseno = this.operarioServices.findByEstadoDisponible("DISEÑADOR");
    		this.lstPCorte = this.operarioServices.findByEstadoDisponible("CORTADOR");
    		this.lstPConfeccion = this.operarioServices.findByEstadoDisponible("CONFECCIONISTA");
    		this.lstPEmpaquetado = this.operarioServices.findByEstadoDisponible("EMPAQUETADOR");
	        
    		this.lstPDisenoSelected = new ArrayList<String>();
    		this.lstPCorteSelected = new ArrayList<String>();
    		this.lstPConfeccionSelected = new ArrayList<String>();
    		this.lstPEmpaquetadoSelected = new ArrayList<String>();
	        
    		this.lstMDiseno = this.maquinariaServices.findByEstadoDisponible("DISEÑO");
    		this.lstMCorte = this.maquinariaServices.findByEstadoDisponible("CORTE");
    		this.lstMConfeccion = this.maquinariaServices.findByEstadoDisponible("CONFECCION");
    		this.lstMEmpaquetado = this.maquinariaServices.findByEstadoDisponible("EMPAQUETADO");
	        
    		this.lstMCorteSelected = new ArrayList<String>();
    		this.lstMConfeccionSelected = new ArrayList<String>();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevo(){
		this.ordenTrabajoSelected = new OrdenTrabajo();
	}

	public void editar(OrdenTrabajo ot){	
		System.out.println("editar");
		try {
			double subtotalproducto=0;
			double subtotalpedido=0;
			double gastosadicionales=0;
			double utilidades=0;
			double subtotal=0;
			double igv=0;
			double total=0;
			List<FichaTecnica> listFichasTecnicas;
			this.ordenTrabajoSelected = ot;
			this.pedidoSelected = this.pedidoServices.findByIdAndByEstado(this.ordenTrabajoSelected.getId_pedido(), Constante.APROBADO);
			if(pedidoSelected!=null){
				ordenTrabajoSelected.setNombre_cliente(pedidoSelected.getNombre_cliente());
				ordenTrabajoSelected.setDes_tipo_prenda(pedidoSelected.getDes_tipo_prenda());
				ordenTrabajoSelected.setFecha_entrega_pedido(pedidoSelected.getFechaentrega());
								
				listFichasTecnicas = fichaTecnicaServices.findByProducto(pedidoSelected.getTipo_prenda());
				
				for(FichaTecnica ft: listFichasTecnicas){
					subtotalproducto+=ft.getPrecio_total();
				}
				
				subtotalpedido = subtotalproducto * this.pedidoSelected.getCantidad_prenda().intValue();
				gastosadicionales = subtotalpedido*0.1;
				utilidades = subtotalpedido*0.05;
				subtotal = subtotalpedido + gastosadicionales + utilidades;
				igv = subtotal * 0.18;
				total = subtotal + igv;
				
				this.pedidoSelected.setSubTotalProducto(new Double(subtotalproducto));
				this.pedidoSelected.setSubTotalPedido(new Double(subtotalpedido));
				this.pedidoSelected.setGastosGenerales(new Double(gastosadicionales));
				this.pedidoSelected.setUtilidades(new Double(utilidades));
				this.pedidoSelected.setSubTotal(new Double(subtotal));
				this.pedidoSelected.setIgv(new Double(igv));
				this.pedidoSelected.setTotal(new Double(total));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminar(OrdenTrabajo ot){
		this.ordenTrabajoSelected = ot;
	}
	
	public void confirmaEliminar(){
		try {
			this.ordenTrabajoSelected.setId_estado(10);
			this.ordenTrabajoServices.updateEstado(this.ordenTrabajoSelected);
			FacesUtils.showFacesMessage("Orden de trabajo ha sido eliminada", 3);
			this.lstOrdenTrabajo = this.ordenTrabajoServices.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void obtenerDatosPedido(){
		try {
			System.out.println("obtenerDatosPedido");
			double subtotalproducto=0;
			double subtotalpedido=0;
			double gastosadicionales=0;
			double utilidades=0;
			double subtotal=0;
			double igv=0;
			double total=0;
			List<FichaTecnica> listFichasTecnicas;
			System.out.println("obtenerDatosPedido>>>> ordenTrabajoSelected.id_pedido" + this.ordenTrabajoSelected.getId_pedido());
			pedidoSelected = this.pedidoServices.findByIdAndByEstado(this.ordenTrabajoSelected.getId_pedido(), Constante.APROBADO);
			if(pedidoSelected!=null){
				ordenTrabajoSelected.setNombre_cliente(pedidoSelected.getNombre_cliente());
				ordenTrabajoSelected.setDes_tipo_prenda(pedidoSelected.getDes_tipo_prenda());
				ordenTrabajoSelected.setFecha_entrega_pedido(pedidoSelected.getFechaentrega());
								
				listFichasTecnicas = fichaTecnicaServices.findByProducto(pedidoSelected.getTipo_prenda());
				
				for(FichaTecnica ft: listFichasTecnicas){
					subtotalproducto+=ft.getPrecio_total();
				}
				
				subtotalpedido = subtotalproducto * this.pedidoSelected.getCantidad_prenda().intValue();
				gastosadicionales = subtotalpedido*0.1;
				utilidades = subtotalpedido*0.05;
				subtotal = subtotalpedido + gastosadicionales + utilidades;
				igv = subtotal * 0.18;
				total = subtotal + igv;
				
				this.pedidoSelected.setSubTotalProducto(new Double(subtotalproducto));
				this.pedidoSelected.setSubTotalPedido(new Double(subtotalpedido));
				this.pedidoSelected.setGastosGenerales(new Double(gastosadicionales));
				this.pedidoSelected.setUtilidades(new Double(utilidades));
				this.pedidoSelected.setSubTotal(new Double(subtotal));
				this.pedidoSelected.setIgv(new Double(igv));
				this.pedidoSelected.setTotal(new Double(total));
			}
			else{
				FacesUtils.showFacesMessage("No se encontro el pedido ingresado o el pedido aun no ha sido aprobado.", 1);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarOrdenTrabajo(){
		// Crear el detalle en base a la cantidad de etapas
		try {
			Date fechaActual = new Date();
			
			List<Etapa> lstEtapas = etapaServices.findAll();
//			PlanPedido planPedido = planPedidoServices.findByPedidoSinFicha(ordenTrabajoSelected.getId_pedido());
//			PlanProduccion planProduccion = planProduccionServices.findById(planPedido.getIdplan());
//			ordenTrabajoSelected.setFecha_entrega_orden(planProduccion.getFechafinplan());
			ordenTrabajoSelected.setFecha_registro(new java.sql.Date(fechaActual.getTime()));
			ordenTrabajoSelected.setId_estado(Constante.OT_PENDIENTE);	
			ordenTrabajoSelected.setId_etapa(Constante.OT_ETAPA_DISENIO);
			
			if(ordenTrabajoSelected.getId_orden_trabajo() != null){
				ordenTrabajoServices.update(ordenTrabajoSelected);
			}
			else{
				ordenTrabajoServices.insert(ordenTrabajoSelected);
				
				pedidoSelected.setEstadopedido(Constante.PROGRAMADO);
				pedidoServices.actualizarPedido(pedidoSelected);
				
				for(Etapa etapa: lstEtapas){
					OrdenTrabajoDetalle otd = new OrdenTrabajoDetalle();
					otd.setId_orden_trabajo(ordenTrabajoSelected.getId_orden_trabajo());
					otd.setId_etapa(etapa.getId_etapa());
//					otd.setId_plan_produccion(planPedido.getIdplan());
					otd.setId_prioridad(ordenTrabajoSelected.getId_prioridad());
					
					switch(etapa.getId_etapa()){
						case 1:
							Calendar calFinDisenio = Calendar.getInstance();
//							calFinDisenio.setTime(planProduccion.getFechainicioplan());
							calFinDisenio.add(Calendar.DATE, 5);
							
//							otd.setFecha_inicio(planProduccion.getFechainicioplan());
							otd.setFecha_fin(new java.sql.Date(calFinDisenio.getTime().getTime()));
							break;
						case 2:
							Calendar calIniCorte = Calendar.getInstance();
//							calIniCorte.setTime(planProduccion.getFechainicioplan());
							calIniCorte.add(Calendar.DATE, 6);
							
							Calendar calFinCorte = Calendar.getInstance();
//							calFinCorte.setTime(planProduccion.getFechainicioplan());
							calFinCorte.add(Calendar.DATE, 12);
							
							otd.setFecha_inicio(new java.sql.Date(calIniCorte.getTime().getTime()));
							otd.setFecha_fin(new java.sql.Date(calFinCorte.getTime().getTime()));
							break;
						case 3:
							Calendar calIniConfeccion = Calendar.getInstance();
//							calIniConfeccion.setTime(planProduccion.getFechainicioplan());
							calIniConfeccion.add(Calendar.DATE, 13);
							
							Calendar calFinConfeccion = Calendar.getInstance();
//							calFinConfeccion.setTime(planProduccion.getFechainicioplan());
							calFinConfeccion.add(Calendar.DATE, 19);
							
							otd.setFecha_inicio(new java.sql.Date(calIniConfeccion.getTime().getTime()));
							otd.setFecha_fin(new java.sql.Date(calFinConfeccion.getTime().getTime()));
							
							break;
						default:
							Calendar calIniEmpaquetado = Calendar.getInstance();
//							calIniEmpaquetado.setTime(planProduccion.getFechainicioplan());
							calIniEmpaquetado.add(Calendar.DATE, 20);
							
							otd.setFecha_inicio(new java.sql.Date(calIniEmpaquetado.getTime().getTime()));
//							otd.setFecha_fin(planProduccion.getFechafinplan());
					}
					ordenTrabajoDetalleServices.insert(otd);
				}
			}

			this.lstOrdenTrabajo = this.ordenTrabajoServices.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obtenerPersonal(OrdenTrabajo ot){
		try {
			this.ordenTrabajoSelected = ot;
    		this.lstPDiseno = this.operarioServices.findByEstadoDisponible("DISEÑADOR");
    		this.lstPCorte = this.operarioServices.findByEstadoDisponible("CORTADOR");
    		this.lstPConfeccion = this.operarioServices.findByEstadoDisponible("CONFECCIONISTA");
    		this.lstPEmpaquetado = this.operarioServices.findByEstadoDisponible("EMPAQUETADOR");
    		
			this.lstPDisenoSelected = this.operarioServices.findByTipoAndByIdOrden("DISEÑO", ot.getId_orden_trabajo());
			this.lstPCorteSelected = this.operarioServices.findByTipoAndByIdOrden("CORTE", ot.getId_orden_trabajo());
			this.lstPConfeccionSelected = this.operarioServices.findByTipoAndByIdOrden("CONFECCION", ot.getId_orden_trabajo());
			this.lstPEmpaquetadoSelected = this.operarioServices.findByTipoAndByIdOrden("EMPAQUETADO", ot.getId_orden_trabajo());
			
			System.out.println("lstPDisenoSelected: " + lstPDisenoSelected.size());
			System.out.println("lstPCorteSelected: " + lstPCorteSelected.size());
			System.out.println("lstPConfeccionSelected: " + lstPConfeccionSelected.size());
			System.out.println("lstPEmpaquetadoSelected: " + lstPEmpaquetadoSelected.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obtenerMaquinarias(OrdenTrabajo ot){
		try {
			this.ordenTrabajoSelected = ot;
//    		this.lstMDiseno = this.maquinariaServices.findByEstadoDisponible("DISEÑO");
    		this.lstMCorte = this.maquinariaServices.findByEstadoDisponible("CORTE");
    		this.lstMConfeccion = this.maquinariaServices.findByEstadoDisponible("CONFECCION");
//    		this.lstMEmpaquetado = this.maquinariaServices.findByEstadoDisponible("EMPAQUETADO");
    		
//			this.lstMDisenoSelected = this.maquinariaServices.findByEstadoAndByIdOrden("DISEÑO");
			this.lstMCorteSelected = this.maquinariaServices.findByEstadoAndByIdOrden("CORTE", ot.getId_orden_trabajo());
			this.lstMConfeccionSelected = this.maquinariaServices.findByEstadoAndByIdOrden("CONFECCION", ot.getId_orden_trabajo());
//			this.lstMEmpaquetado = this.maquinariaServices.findByEstadoAndByIdOrden("EMPAQUETADO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void asignarPersonal(){
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			System.out.println("lstPDisenoSelected: " + lstPDisenoSelected.size());
			System.out.println("lstPCorteSelected: " + lstPCorteSelected.size());
			System.out.println("lstPConfeccionSelected: " + lstPConfeccionSelected.size());
			System.out.println("lstPEmpaquetadoSelected: " + lstPEmpaquetadoSelected.size());
			
			ordenTrabajoOperarioServices.delete(this.ordenTrabajoSelected.getId_orden_trabajo());
			
			for(String o:lstPDisenoSelected){
				OrdenTrabajoOperario oto = new OrdenTrabajoOperario();
				oto.setId_orden_trabajo(this.ordenTrabajoSelected.getId_orden_trabajo());
				oto.setId_prioridad(this.ordenTrabajoSelected.getId_prioridad());
				oto.setIdoperario(new Integer(o));
				oto.setId_etapa(Constante.OT_ETAPA_DISENIO);
				
				ordenTrabajoOperarioServices.insert(oto);
			}
			
			for(String o:lstPCorteSelected){
				OrdenTrabajoOperario oto = new OrdenTrabajoOperario();
				oto.setId_orden_trabajo(this.ordenTrabajoSelected.getId_orden_trabajo());
				oto.setId_prioridad(this.ordenTrabajoSelected.getId_prioridad());
				oto.setIdoperario(new Integer(o));
				oto.setId_etapa(Constante.OT_ETAPA_CORTE);
				
				ordenTrabajoOperarioServices.insert(oto);
			}
			
			for(String o:lstPConfeccionSelected){
				OrdenTrabajoOperario oto = new OrdenTrabajoOperario();
				oto.setId_orden_trabajo(this.ordenTrabajoSelected.getId_orden_trabajo());
				oto.setId_prioridad(this.ordenTrabajoSelected.getId_prioridad());
				oto.setIdoperario(new Integer(o));
				oto.setId_etapa(Constante.OT_ETAPA_CONFECCION);
				
				ordenTrabajoOperarioServices.insert(oto);
			}
			
			for(String o:lstPEmpaquetadoSelected){
				OrdenTrabajoOperario oto = new OrdenTrabajoOperario();
				oto.setId_orden_trabajo(this.ordenTrabajoSelected.getId_orden_trabajo());
				oto.setId_prioridad(this.ordenTrabajoSelected.getId_prioridad());
				oto.setIdoperario(new Integer(o));
				oto.setId_etapa(Constante.OT_ETAPA_EMPAQUETADO);
				
				ordenTrabajoOperarioServices.insert(oto);
			}

			this.lstOrdenTrabajo = this.ordenTrabajoServices.findAll();
			context.update("dataTable");
			context.execute("PF('dlgPersonal').hide();");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void asignarMaquinaria(){
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			System.out.println("lstMCorteSelected: " + lstMCorteSelected.size());
			System.out.println("lstMConfeccionSelected: " + lstMConfeccionSelected.size());
			
			ordenTrabajoMaquinariaServices.delete(this.ordenTrabajoSelected.getId_orden_trabajo());

			
			for(String o:lstMCorteSelected){
				OrdenTrabajoMaquinaria oto = new OrdenTrabajoMaquinaria();
				oto.setId_orden_trabajo(this.ordenTrabajoSelected.getId_orden_trabajo());
				oto.setId_prioridad(this.ordenTrabajoSelected.getId_prioridad());
				oto.setIdmaquinaria(new Integer(o));
				
				ordenTrabajoMaquinariaServices.insert(oto);
			}
			
			for(String o:lstMConfeccionSelected){
				OrdenTrabajoMaquinaria oto = new OrdenTrabajoMaquinaria();
				oto.setId_orden_trabajo(this.ordenTrabajoSelected.getId_orden_trabajo());
				oto.setId_prioridad(this.ordenTrabajoSelected.getId_prioridad());
				oto.setIdmaquinaria(new Integer(o));
				
				ordenTrabajoMaquinariaServices.insert(oto);
			}
			
			this.lstOrdenTrabajo = this.ordenTrabajoServices.findAll();
			
			context.update("dataTable");
			context.execute("PF('dlgMaquinaria').hide();");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// GETTERS AND SETTERS
	
	public List<Operario> getLstPDiseno() {
		return lstPDiseno;
	}
	public Pedido getPedidoSelected() {
		return pedidoSelected;
	}

	public void setPedidoSelected(Pedido pedidoSelected) {
		this.pedidoSelected = pedidoSelected;
	}

	public void setLstPDiseno(List<Operario> lstPDiseno) {
		this.lstPDiseno = lstPDiseno;
	}
	public List<Operario> getLstPCorte() {
		return lstPCorte;
	}
	public void setLstPCorte(List<Operario> lstPCorte) {
		this.lstPCorte = lstPCorte;
	}
	public List<Operario> getLstPConfeccion() {
		return lstPConfeccion;
	}
	public void setLstPConfeccion(List<Operario> lstPConfeccion) {
		this.lstPConfeccion = lstPConfeccion;
	}
	public List<Operario> getLstPEmpaquetado() {
		return lstPEmpaquetado;
	}
	public void setLstPEmpaquetado(List<Operario> lstPEmpaquetado) {
		this.lstPEmpaquetado = lstPEmpaquetado;
	}
	public List<Maquinaria> getLstMDiseno() {
		return lstMDiseno;
	}
	public void setLstMDiseno(List<Maquinaria> lstMDiseno) {
		this.lstMDiseno = lstMDiseno;
	}
	public List<Maquinaria> getLstMCorte() {
		return lstMCorte;
	}
	public void setLstMCorte(List<Maquinaria> lstMCorte) {
		this.lstMCorte = lstMCorte;
	}
	public List<Maquinaria> getLstMConfeccion() {
		return lstMConfeccion;
	}
	public void setLstMConfeccion(List<Maquinaria> lstMConfeccion) {
		this.lstMConfeccion = lstMConfeccion;
	}
	public List<Maquinaria> getLstMEmpaquetado() {
		return lstMEmpaquetado;
	}
	public void setLstMEmpaquetado(List<Maquinaria> lstMEmpaquetado) {
		this.lstMEmpaquetado = lstMEmpaquetado;
	}
	public List<String> getLstPDisenoSelected() {
		return lstPDisenoSelected;
	}
	public void setLstPDisenoSelected(List<String> lstPDisenoSelected) {
		this.lstPDisenoSelected = lstPDisenoSelected;
	}
	public List<String> getLstPCorteSelected() {
		return lstPCorteSelected;
	}
	public void setLstPCorteSelected(List<String> lstPCorteSelected) {
		this.lstPCorteSelected = lstPCorteSelected;
	}
	public List<String> getLstPConfeccionSelected() {
		return lstPConfeccionSelected;
	}
	public void setLstPConfeccionSelected(List<String> lstPConfeccionSelected) {
		this.lstPConfeccionSelected = lstPConfeccionSelected;
	}
	public List<String> getLstPEmpaquetadoSelected() {
		return lstPEmpaquetadoSelected;
	}
	public void setLstPEmpaquetadoSelected(List<String> lstPEmpaquetadoSelected) {
		this.lstPEmpaquetadoSelected = lstPEmpaquetadoSelected;
	}
	public List<String> getLstMCorteSelected() {
		return lstMCorteSelected;
	}
	public void setLstMCorteSelected(List<String> lstMCorteSelected) {
		this.lstMCorteSelected = lstMCorteSelected;
	}
	public List<String> getLstMConfeccionSelected() {
		return lstMConfeccionSelected;
	}
	public void setLstMConfeccionSelected(List<String> lstMConfeccionSelected) {
		this.lstMConfeccionSelected = lstMConfeccionSelected;
	}
	public List<OrdenTrabajo> getLstOrdenTrabajo() {
		return lstOrdenTrabajo;
	}
	public void setLstOrdenTrabajo(List<OrdenTrabajo> lstOrdenTrabajo) {
		this.lstOrdenTrabajo = lstOrdenTrabajo;
	}
	public OrdenTrabajo getOrdenTrabajoSelected() {
		return ordenTrabajoSelected;
	}
	public void setOrdenTrabajoSelected(OrdenTrabajo ordenTrabajoSelected) {
		this.ordenTrabajoSelected = ordenTrabajoSelected;
	}

	public List<Prioridad> getListPrioridad() {
		return listPrioridad;
	}

	public void setListPrioridad(List<Prioridad> listPrioridad) {
		this.listPrioridad = listPrioridad;
	}	
	
}
