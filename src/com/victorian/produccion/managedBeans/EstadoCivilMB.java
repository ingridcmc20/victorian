package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.FacesUtils;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.EstadoCivil;
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.services.EstadoCivilService;
import com.victorian.produccion.services.MenuServices;

@ManagedBean(name="estadoCivilMB")
@ViewScoped
public class EstadoCivilMB extends GenericBeans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EstadoCivil estadoCivil;
	private List<EstadoCivil> listaEstadoCivil;
	private Boolean editar;
	private EstadoCivilService estadoCivilService;
	private MenuServices menuServices;
	private Log log;
	private LogMB logmb;
	RequestContext context; 
	private EstadoCivil estadoCivilSelec;
	@ManagedProperty(value= "#{loginMB}")
	private LoginMB login;
	public EstadoCivilMB(){
	}
	
	@PostConstruct
	public void inicia()
	{
		this.estadoCivilSelec = new EstadoCivil();
		this.editar = Boolean.FALSE;
		menuServices = new MenuServices();
		this.estadoCivilService = new EstadoCivilService();
		
		try {
			this.listaEstadoCivil = this.estadoCivilService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log = (Log)getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();
		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:estadoCivil");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		
		
	}
	
	
	public void guardarEstadoCivil() {
		Boolean valido=Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();  
   	    context.addCallbackParam("esValido", valido);
		
		try {
			this.estadoCivilSelec.setDescripcion(this.estadoCivilSelec.getDescripcion().trim().toUpperCase());
			
			if(this.editar) {
				this.estadoCivilService.actualizarEstadoCivil(estadoCivilSelec);
				FacesUtils.showFacesMessage("Estado Civil ha sido actualizado", 3);
				log.setAccion("UPDATE");
		        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" actualizó el tipo de documento: "+this.estadoCivilSelec.getDescripcion());
		        logmb.insertarLog(log);
		        
			}else{
				//this.resultado.setEstado(Boolean.TRUE);
				this.estadoCivilService.crearEstadoCivil(estadoCivilSelec);
				FacesUtils.showFacesMessage("Estado Civil ha sido creado", 3);
				log.setAccion("INSERT");
		        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" registró  : " + this.estadoCivilSelec.getDescripcion());
		        logmb.insertarLog(log);
			}
			
			this.editar = Boolean.FALSE;
			this.estadoCivil = new EstadoCivil();
			this.listaEstadoCivil = this.estadoCivilService.findAll();
			this.estadoCivilSelec = new EstadoCivil();
			context.update("sms");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoEstadoCivil(){
		this.estadoCivilSelec  = new EstadoCivil();
		this.editar = Boolean.FALSE;
//		this.documentoSelec.setEstado(Boolean.TRUE);
	}
	

	public void editarEstadoCivil(EstadoCivil estadoCivil){
		this.estadoCivilSelec = estadoCivil;
		this.editar = Boolean.TRUE;
	}
	
	public void eliminarEstadoCivil(EstadoCivil estadoCivil){
		this.estadoCivilSelec = estadoCivil;
		
	}
	
	public void confirmaEliminar()
	{
		try {
			this.estadoCivilService.eliminarEstadoCivil(this.estadoCivilSelec.getId_estado_civil());
			FacesUtils.showFacesMessage("Estado Civil ha sido eliminado", 3);
			this.listaEstadoCivil = this.estadoCivilService.findAll();
			log.setAccion("DELETE");
	        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" ha eliminado el tipo de documento: " + this.estadoCivilSelec.getDescripcion());
	        logmb.insertarLog(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	

//	public void cambiarEstado(TipoDocumento tipoDocumento){
//		   String estado = "";
//		   if(tipoDocumento.getEstado()){
//			   tipoDocumento.setEstado(Boolean.FALSE);
//			   estado ="INACTIVO";
//		   }else{
//			   tipoDocumento.setEstado(Boolean.TRUE);
//			   estado ="ACTIVO";
//		   }
//		   
//		   try {
//			   this.tipoDocumentoService.actualizarTipoDocumento(tipoDocumento);;
//			   FacesUtils.showFacesMessage("Tipo Documento modificado correctamente",Constante.INFORMACION);
//			   this.listaTipoDocumento = this.tipoDocumentoService.findAll();
//			   log.setAccion("UPDATE");
//	           log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" actualizó el estado a "+estado+" al tipo de documento: " + tipoDocumento.getEstado());
//	           logmb.insertarLog(log);
//		   } catch (Exception e) {
//			   System.out.println("Error:"+e.getMessage());
//			   e.printStackTrace();
//		   }   
//	}
	
	
	
	
	/**##########################setter and  getter#####################################*/


	
	
	
	public LoginMB getLogin() {
		return login;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}



	public EstadoCivil getEstadoCivilSelec() {
		return estadoCivilSelec;
	}

	public void setEstadoCivilSelec(EstadoCivil estadoCivilSelec) {
		this.estadoCivilSelec = estadoCivilSelec;
	}

	public List<EstadoCivil> getListaEstadoCivil() {
		return listaEstadoCivil;
	}

	public void setListaEstadoCivil(List<EstadoCivil> listaEstadoCivil) {
		this.listaEstadoCivil = listaEstadoCivil;
	}
	
	
	
}
