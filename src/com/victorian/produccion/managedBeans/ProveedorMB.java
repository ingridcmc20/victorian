package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.domain.Proveedor;
import com.victorian.produccion.services.MenuServices;
import com.victorian.produccion.services.ProveedorService;
import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.FacesUtils;
import com.pe.victorian.produccion.commons.GenericBeans;

@ManagedBean(name="proveedorMB")
@ViewScoped

public class ProveedorMB extends GenericBeans implements Serializable{
	
	private Proveedor proveedor;
	private List<Proveedor> listaProveedor;
	private Boolean editar;
	private List<Proveedor> listaFiltroProveedor;
	private ProveedorService proveedorService;
	private Proveedor proveedorSelec;
	private MenuServices menuServices;
	private Log log;
	private LogMB logmb;
	RequestContext context; 
	
	
	
	@ManagedProperty(value= "#{loginMB}")
	private LoginMB login;

	public ProveedorMB(){
	}
	
	@PostConstruct
	public void inicia()
	{
		this.proveedorSelec = new Proveedor();
		this.listaProveedor = new ArrayList<>();
		this.proveedorService = new ProveedorService();
		
		this.editar = Boolean.FALSE;
		menuServices = new MenuServices();
	
		try {
			this.listaProveedor = this.proveedorService.findAll();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log = (Log)getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();
		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:proveedor");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
	}
	
	
	public void guardarProveedor() {
		Boolean valido=Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();  
   	    context.addCallbackParam("esValido", valido);
		
		try {
	
			if(this.editar) {
				this.proveedorService.actualizarProveedor(this.proveedorSelec);
				FacesUtils.showFacesMessage("Proveedor ha sido actualizado", 3);
				log.setAccion("UPDATE");
		        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" actualizó la empresa: "+this.proveedorSelec.getRazon_social());
		        logmb.insertarLog(log);
			}else{
				this.proveedorService.crearProveedor(this.proveedorSelec);
				FacesUtils.showFacesMessage("Proveedor ha sido creado", 3);
				log.setAccion("INSERT");
		        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" registró: " + this.proveedorSelec.getRazon_social());
		        logmb.insertarLog(log);
			}
			
			this.proveedorSelec = new Proveedor();
			this.editar = Boolean.FALSE;
			
			this.listaProveedor = proveedorService.findAll();
			context.update("sms");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public void nuevoProveedor(){
		this.proveedorSelec = new Proveedor();
		this.editar = Boolean.FALSE;
		System.out.println("***********creando Proveedor**************");
	}
	

	public void editarProveedor(Proveedor p){
		this.proveedorSelec = p;		
		this.editar = Boolean.TRUE;
	}
	
	public void eliminarHerramienta(Proveedor pr){
		this.proveedorSelec = pr;
		
	}
	
	public void confirmaEliminar()
	{

		try{			
			this.proveedorService.eliminarProveedor(this.proveedorSelec.getId_proveedor());
				FacesUtils.showFacesMessage("Proveedor Eliminado", 3);
				log.setAccion("DELETE");
		        log.setDescripcion("El usuario "+this.login.getLoginUsuario()+" eliminó la empresa: " +this.proveedorSelec.getId_proveedor());
		        logmb.insertarLog(log);				
				this.listaProveedor = this.proveedorService.findAll();
			//}

		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}


	/**##########################setter and  getter#####################################*/

	public Boolean getEditar() {
		return editar;
	}	

	public LoginMB getLogin() {
		return login;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Proveedor> getListaProveedor() {
		return listaProveedor;
	}

	public void setListaProveedor(List<Proveedor> listaProveedor) {
		this.listaProveedor = listaProveedor;
	}

	public List<Proveedor> getListaFiltroProveedor() {
		return listaFiltroProveedor;
	}

	public void setListaFiltroProveedor(List<Proveedor> listaFiltroProveedor) {
		this.listaFiltroProveedor = listaFiltroProveedor;
	}

	public ProveedorService getProveedorService() {
		return proveedorService;
	}

	public void setProveedorService(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}

	public Proveedor getProveedorSelec() {
		return proveedorSelec;
	}

	public void setProveedorSelec(Proveedor proveedorSelec) {
		this.proveedorSelec = proveedorSelec;
	}

	
}
