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
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.domain.TipoDocumento;
import com.victorian.produccion.services.MenuServices;
import com.victorian.produccion.services.TipoDocumentoService;

@ManagedBean(name="tipoDocumentoMB")
@ViewScoped
public class TipoDocumentoMB extends GenericBeans implements Serializable{

	private TipoDocumento tipoDocumento;
	private List<TipoDocumento> listaTipoDocumento;
	private Boolean editar;
	private TipoDocumentoService tipoDocumentoService;
	private MenuServices menuServices;
	private Log log;
	private LogMB logmb;
	RequestContext context; 
	private TipoDocumento documentoSelec;
	@ManagedProperty(value= "#{loginMB}")
	private LoginMB login;
	public TipoDocumentoMB(){
	}
	
	@PostConstruct
	public void inicia()
	{
		this.documentoSelec = new TipoDocumento();
		this.editar = Boolean.FALSE;
		menuServices = new MenuServices();
		this.tipoDocumentoService = new TipoDocumentoService();
		
		try {
			this.listaTipoDocumento = this.tipoDocumentoService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log = (Log)getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();
		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:tipoDocumento");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		
		
	}
	
	
	public void guardarTipoDocumento() {
		Boolean valido=Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();  
   	    context.addCallbackParam("esValido", valido);
		
		try {
			this.documentoSelec.setDescripcion(this.documentoSelec.getDescripcion().trim().toUpperCase());
			
			if(this.editar) {
				this.tipoDocumentoService.actualizarTipoDocumento(documentoSelec);
				FacesUtils.showFacesMessage("Tipo Documento ha sido actualizado", 3);
				log.setAccion("UPDATE");
		        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" actualizó el tipo de documento: "+this.documentoSelec.getDescripcion());
		        logmb.insertarLog(log);
		        
			}else{
				//this.resultado.setEstado(Boolean.TRUE);
				this.tipoDocumentoService.crearTipoDocumento(documentoSelec);
				FacesUtils.showFacesMessage("Tipo Documento ha sido creado", 3);
				log.setAccion("INSERT");
		        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" registró  : " + this.documentoSelec.getDescripcion());
		        logmb.insertarLog(log);
			}
			
			this.editar = Boolean.FALSE;
			this.tipoDocumento = new TipoDocumento();
			this.listaTipoDocumento = this.tipoDocumentoService.findAll();
			this.documentoSelec = new TipoDocumento();
			context.update("sms");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoTipoDocumento(){
		this.documentoSelec  = new TipoDocumento();
		this.editar = Boolean.FALSE;
		this.documentoSelec.setActivo(Boolean.TRUE);
	}
	

	public void editarTipoDocumento(TipoDocumento tipDoc){
		this.documentoSelec = tipDoc;
		this.editar = Boolean.TRUE;
	}
	
	public void eliminarTipoDocumento(TipoDocumento tipDoc){
		this.documentoSelec = tipDoc;
		
	}
	
	public void confirmaEliminar()
	{
		try {
			this.tipoDocumentoService.eliminarTipoDocumento(this.documentoSelec.getId_tipodocumento());
			FacesUtils.showFacesMessage("Tipo Documento ha sido eliminado", 3);
			this.listaTipoDocumento = this.tipoDocumentoService.findAll();
			log.setAccion("DELETE");
	        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" ha eliminado el tipo de documento: " + this.documentoSelec.getDescripcion());
	        logmb.insertarLog(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	

	public void cambiarEstado(TipoDocumento tipoDocumento){
		   String estado = "";
		   if(tipoDocumento.getActivo()){
			   tipoDocumento.setActivo(Boolean.FALSE);
			   estado ="INACTIVO";
		   }else{
			   tipoDocumento.setActivo(Boolean.TRUE);
			   estado ="ACTIVO";
		   }
		   
		   try {
			   this.tipoDocumentoService.actualizarTipoDocumento(tipoDocumento);;
			   FacesUtils.showFacesMessage("Tipo Documento modificado correctamente",Constante.INFORMACION);
			   this.listaTipoDocumento = this.tipoDocumentoService.findAll();
			   log.setAccion("UPDATE");
	           log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" actualizó el estado a "+estado+" al tipo de documento: " + tipoDocumento.getActivo());
	           logmb.insertarLog(log);
		   } catch (Exception e) {
			   System.out.println("Error:"+e.getMessage());
			   e.printStackTrace();
		   }   
	}
	
	
	
	
	/**##########################setter and  getter#####################################*/

	public Boolean getEditar() {
		return editar;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<TipoDocumento> getListaTipoDocumento() {
		return listaTipoDocumento;
	}

	public void setListaTipoDocumento(List<TipoDocumento> listaTipoDocumento) {
		this.listaTipoDocumento = listaTipoDocumento;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public TipoDocumento getDocumentoSelec() {
		return documentoSelec;
	}

	public void setDocumentoSelec(TipoDocumento documentoSelec) {
		this.documentoSelec = documentoSelec;
	}

	public LoginMB getLogin() {
		return login;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}
}
