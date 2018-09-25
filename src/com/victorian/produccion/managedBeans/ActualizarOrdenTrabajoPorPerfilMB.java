package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Merma;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.domain.OrdenTrabajo;
import com.victorian.produccion.domain.OrdenTrabajoDetalle;
import com.victorian.produccion.domain.OrdenTrabajoOperario;
import com.victorian.produccion.domain.Usuario;
import com.victorian.produccion.services.MermaServices;
import com.victorian.produccion.services.NivelServices;
import com.victorian.produccion.services.OperarioServices;
import com.victorian.produccion.services.OrdenTrabajoDetalleServices;
import com.victorian.produccion.services.OrdenTrabajoOperarioServices;
import com.victorian.produccion.services.OrdenTrabajoServices;

@ManagedBean(name = "actualizarOrdenTrabajoPorPerfilMB")
@ViewScoped
public class ActualizarOrdenTrabajoPorPerfilMB extends GenericBeans implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OrdenTrabajo> listaOrdenTrabajo;
	private List<Merma> listaMerma;
	private OrdenTrabajoServices ordenTrabajoServices;
	private OrdenTrabajoDetalleServices ordenTrabajoDetalleServices;
	private OrdenTrabajoOperarioServices ordenTrabajoOperarioServices;
	private MermaServices mermaServices;
	private OperarioServices operarioServices;
	private NivelServices nivelServices;
	@ManagedProperty(value = "#{loginMB}")
	private LoginMB login;

	@ManagedProperty(value = "#{loginMB.usuario}")
	private Usuario usuarioLogin;

	OrdenTrabajo ordenTrabajoSelected;
	Merma mermaSelected;

	private boolean gamification = false;

	@PostConstruct
	public void inicia() {
		try {
			ordenTrabajoServices = new OrdenTrabajoServices();
			ordenTrabajoDetalleServices = new OrdenTrabajoDetalleServices();
			mermaServices = new MermaServices();
			operarioServices = new OperarioServices();
			nivelServices = new NivelServices();
			ordenTrabajoOperarioServices = new OrdenTrabajoOperarioServices();
			ordenTrabajoSelected = new OrdenTrabajo();
			mermaSelected = new Merma();

			obtenerListaOrdenTrabajo();

			if (this.login.getPerfilUsuario().getCod_perfil().equals(Constante.PERFIL_USUARIO_CORTADOR)
					|| this.login.getPerfilUsuario().getCod_perfil().equals(Constante.PERFIL_USUARIO_CONFECCIONISTA)) {
				gamification = true;
			} else {
				gamification = false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerListaOrdenTrabajo() throws Exception {
		int etapa = -1;
		System.out.println(this.login.getPerfilUsuario().getCod_perfil());
		if (this.login.getPerfilUsuario().getCod_perfil()
				.intValue() == (Constante.PERFIL_USUARIO_DISENIADOR.intValue())) {
			etapa = Constante.OT_ETAPA_DISENIO;
		} else if (this.login.getPerfilUsuario().getCod_perfil()
				.intValue() == (Constante.PERFIL_USUARIO_CORTADOR.intValue())) {
			etapa = Constante.OT_ETAPA_CORTE;
		} else if (this.login.getPerfilUsuario().getCod_perfil()
				.intValue() == (Constante.PERFIL_USUARIO_CONFECCIONISTA.intValue())) {
			etapa = Constante.OT_ETAPA_CONFECCION;
		} else if (this.login.getPerfilUsuario().getCod_perfil()
				.intValue() == (Constante.PERFIL_USUARIO_EMPAQUETADOR.intValue())) {
			etapa = Constante.OT_ETAPA_EMPAQUETADO;
		}

		if (etapa != -1) {
			System.out.println(etapa);
			System.out.println(this.login.getIdUsuario());
			listaOrdenTrabajo = ordenTrabajoServices.findByEtapaYUsuario(etapa, this.login.getIdUsuario());
		} else {
			listaOrdenTrabajo = ordenTrabajoServices.findAll();
		}
	}

	public void terminar(OrdenTrabajo ot) {
		try {
			ordenTrabajoSelected = ot;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerMermas(OrdenTrabajo ot) {
		try {
			ordenTrabajoSelected = ot;
			listaMerma = mermaServices.findByOrdenTrabajo(ordenTrabajoSelected.getId_ordentrabajo());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registrarMerma() {
		RequestContext context = RequestContext.getCurrentInstance();
		mermaSelected.setId_estado(8);
		mermaSelected.setId_ordentrabajo(ordenTrabajoSelected.getId_ordentrabajo());
		mermaServices.insert(mermaSelected);
		mermaSelected = new Merma();
		listaMerma = mermaServices.findByOrdenTrabajo(ordenTrabajoSelected.getId_ordentrabajo());
		// context.update("merma");
		// context.update("dtbMermas");
		// context.update("msgMermas");
	}

	public void cerrarMerma() {
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgMerma').hide();");
			obtenerListaOrdenTrabajo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizarRegistro(){
		RequestContext context = RequestContext.getCurrentInstance();  
		boolean logro = false;		
		Date fechaActual = new Date();
		System.out.println("actualizarRegistro");
//		int etapa = -1;
		int estado = -1;
		
		
		OrdenTrabajoDetalle otd = ordenTrabajoDetalleServices.findByIdOrdenByEstapa(ordenTrabajoSelected.getId_ordentrabajo(), ordenTrabajoSelected.getId_etapa());
		otd.setFecha_real_fin(new java.sql.Date((fechaActual).getTime()));
		otd.setId_estado(Constante.OT_TERMINADO);
		
		if (this.login.getPerfilUsuario().getCod_perfil().intValue() == (Constante.PERFIL_USUARIO_DISENIADOR.intValue())) {
//			etapa = Constante.OT_ETAPA_CORTE;
			estado = Constante.OT_EN_CURSO;
		}
		else if (this.login.getPerfilUsuario().getCod_perfil().intValue() == (Constante.PERFIL_USUARIO_CORTADOR.intValue())) {
//			etapa = Constante.OT_ETAPA_CONFECCION;
			estado = Constante.OT_EN_CURSO;
		}
		else if (this.login.getPerfilUsuario().getCod_perfil().intValue() == (Constante.PERFIL_USUARIO_CONFECCIONISTA.intValue())) {
//			etapa = Constante.OT_ETAPA_EMPAQUETADO;
			estado = Constante.OT_EN_CURSO;
		}
		else if (this.login.getPerfilUsuario().getCod_perfil().intValue() == (Constante.PERFIL_USUARIO_EMPAQUETADOR.intValue())) {
//			etapa = Constante.OT_ETAPA_EMPAQUETADO;
			estado = Constante.OT_TERMINADO;
		}
		
		ordenTrabajoSelected.setId_estado(estado);
//		ordenTrabajoSelected.setId_etapa(etapa);
		
		try {
			Operario operario = operarioServices.findById(this.login.getIdUsuario());
			OrdenTrabajoOperario ordenTrabajoOperario = ordenTrabajoOperarioServices.findByOperarioYOrdenTrabajo(ordenTrabajoSelected.getId_ordentrabajo(), operario.getId_operario());
			
			if(gamification){
				// Se valida si el operario termino su tarea a tiempo
				if(otd.getFecha_fin().getTime()>=otd.getFecha_real_fin().getTime()){
					logro = true;
					System.out.println("Lo logro");
					ordenTrabajoOperario.setPuntaje_obtenido((ordenTrabajoOperario.getPuntaje_obtenido()!=null?ordenTrabajoOperario.getPuntaje_obtenido():0)+1);	
				}
				else{
					logro = false;
					System.out.println("No lo logro");
					ordenTrabajoOperario.setPuntaje_obtenido((ordenTrabajoOperario.getPuntaje_obtenido()!=null?ordenTrabajoOperario.getPuntaje_obtenido():0));
				}				
			}
			else{
				ordenTrabajoOperario.setPuntaje_obtenido((ordenTrabajoOperario.getPuntaje_obtenido()!=null?ordenTrabajoOperario.getPuntaje_obtenido():0));
			}
			
			int puntaje = (operario.getPuntaje_acumulado()!=null?operario.getPuntaje_acumulado():0) + ordenTrabajoOperario.getPuntaje_obtenido();
			
			Integer id_nivel = nivelServices.findIdNivelByPuntaje(puntaje);
			
			operario.setId_nivel(operario.getId_nivel()!=null?operario.getId_nivel():0);
			
			if(operario.getId_nivel().intValue() < id_nivel.intValue()){
				operario.setPuntaje_acumulado(puntaje);
				ordenTrabajoOperario.setPuntaje_obtenido(0);
				ordenTrabajoOperario.setId_nivel(id_nivel);
				ordenTrabajoOperario.setFecha_nivel(new java.sql.Timestamp((fechaActual).getTime()));
			}
			
			operarioServices.updateOperario(operario);
			ordenTrabajoOperarioServices.updateOrdenTrabajoOperario(ordenTrabajoOperario);
			ordenTrabajoServices.updateEstado(ordenTrabajoSelected);
			ordenTrabajoDetalleServices.updateFechaReal(otd);
			
			context.execute("PF('dlgNuevo').hide();");
			
			if(gamification){
				if(logro){
					context.update("dlgPuntual");
					context.execute("PF('dlgPuntual').show();");
//					context.update("dlgTarde");
//					context.execute("PF('dlgTarde').show();");
				}
				else{
					context.update("dlgTarde");
					context.execute("PF('dlgTarde').show();");
				}				
			}
			else{
				context.update("dlgListo");
				context.execute("PF('dlgListo').show();");				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Merma> getListaMerma() {
		return listaMerma;
	}

	public void setListaMerma(List<Merma> listaMerma) {
		this.listaMerma = listaMerma;
	}

	public Merma getMermaSelected() {
		return mermaSelected;
	}

	public void setMermaSelected(Merma mermaSelected) {
		this.mermaSelected = mermaSelected;
	}

	public List<OrdenTrabajo> getListaOrdenTrabajo() {
		return listaOrdenTrabajo;
	}

	public void setListaOrdenTrabajo(List<OrdenTrabajo> listaOrdenTrabajo) {
		this.listaOrdenTrabajo = listaOrdenTrabajo;
	}

	public LoginMB getLogin() {
		return login;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}

	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public OrdenTrabajo getOrdenTrabajoSelected() {
		return ordenTrabajoSelected;
	}

	public void setOrdenTrabajoSelected(OrdenTrabajo ordenTrabajoSelected) {
		this.ordenTrabajoSelected = ordenTrabajoSelected;
	}

	public boolean isGamification() {
		return gamification;
	}

	public void setGamification(boolean gamification) {
		this.gamification = gamification;
	}

}
