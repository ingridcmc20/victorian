package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.victorian.produccion.domain.TipoMoneda;
import com.victorian.produccion.services.MenuServices;
import com.victorian.produccion.services.TipoMonedaService;

@ManagedBean(name="tipoMonedaMB")
@ViewScoped

public class TipoMonedaMB extends GenericBeans implements Serializable{
	
	private TipoMoneda tipoMoneda;
	private List<TipoMoneda> listaTipoMoneda;
	private Boolean editar;
	private MenuServices menuServices;
	private TipoMoneda monedaSelec;
	private Log log;
	private LogMB logmb;
	@ManagedProperty(value= "#{loginMB}")
	private LoginMB login;
	
	private TipoMonedaService tipoMonedaService;
	RequestContext context; 
	
	public TipoMonedaMB(){
	}
	
	@PostConstruct
	public void inicia()
	{
		this.monedaSelec = new TipoMoneda();
		this.listaTipoMoneda = new ArrayList();
		this.editar = Boolean.FALSE;
		menuServices = new MenuServices();
		
		this.tipoMonedaService = new TipoMonedaService();
		
		try {
			this.listaTipoMoneda = this.tipoMonedaService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log = (Log)getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();
		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:tipoMoneda");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
	
	
	public void guardarTipoMoneda() {
		Boolean valido=Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();  
   	    context.addCallbackParam("esValido", valido);
		
		try {
			this.monedaSelec.setDescripcion(this.monedaSelec.getDescripcion().trim().toUpperCase());
			
			if(this.editar) {
				this.tipoMonedaService.actualizarTipoMoneda(monedaSelec);;
				FacesUtils.showFacesMessage("Tipo Moneda ha sido actualizado", 3);
				log.setAccion("UPDATE");
		        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" actualizó el tipo Moneda: "+this.monedaSelec.getDescripcion());
		        logmb.insertarLog(log);
				
			}else{
				//this.resultado.setEstado(Boolean.TRUE);
				this.tipoMonedaService.crearTipoMoneda(monedaSelec);;
				FacesUtils.showFacesMessage("Tipo Moneda ha sido creado", 3);
				 log.setAccion("INSERT");
		         log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" registró  : " + this.monedaSelec.getDescripcion());
		         logmb.insertarLog(log);
			}
			this.tipoMoneda = new TipoMoneda();
			this.monedaSelec = new TipoMoneda();
			this.editar = Boolean.FALSE;
			
			this.listaTipoMoneda = tipoMonedaService.findAll();
			context.update("sms");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoTipoMoneda(){
		this.monedaSelec = new TipoMoneda();
		this.editar = Boolean.FALSE;
		this.monedaSelec.setEstado(Boolean.TRUE);
	}
	

	public void editarTipoMoneda(TipoMoneda tipMon){
		this.monedaSelec = tipMon;
		this.editar = Boolean.TRUE;
	}
	
	public void eliminarTipoMoneda(TipoMoneda tipMon){
		this.monedaSelec = tipMon;
		
	}
	
	public void confirmaEliminar()
	{
		try {
			this.tipoMonedaService.eliminarTipoMoneda(this.monedaSelec.getId_tipo_moneda());
			FacesUtils.showFacesMessage("Tipo Moneda ha sido eliminado", 3);
			this.listaTipoMoneda = this.tipoMonedaService.findAll();
			log.setAccion("DELETE");
	        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" ha eliminado el tipo de moneda: " + this.monedaSelec.getDescripcion());
	        logmb.insertarLog(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public TipoMoneda getMonedaSelec() {
		return monedaSelec;
	}

	public void setMonedaSelec(TipoMoneda monedaSelec) {
		this.monedaSelec = monedaSelec;
	}

	public void cambiarEstado(TipoMoneda tipoMoneda){
		   String estado = "";
		   if(tipoMoneda.getEstado()){
			   tipoMoneda.setEstado(Boolean.FALSE);
			   estado ="INACTIVO";
		   }else{
			   tipoMoneda.setEstado(Boolean.TRUE);
			   estado ="ACTIVO";
		   }
		   
		   try {
			   this.tipoMonedaService.actualizarTipoMoneda(tipoMoneda);;
			   FacesUtils.showFacesMessage("Tipo Moneda modificado correctamente",Constante.INFORMACION);
			   this.listaTipoMoneda = this.tipoMonedaService.findAll();
			   log.setAccion("UPDATE");
	           log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" actualizó el estado a "+estado+" el tipo de moneda: " + tipoMoneda.getEstado());
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

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public List<TipoMoneda> getListaTipoMoneda() {
		return listaTipoMoneda;
	}

	public void setListaTipoMoneda(List<TipoMoneda> listaTipoMoneda) {
		this.listaTipoMoneda = listaTipoMoneda;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public LoginMB getLogin() {
		return login;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}

	
	

}
