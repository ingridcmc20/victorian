package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.domain.MenuXPerfil;
import com.victorian.produccion.domain.Perfil;
import com.victorian.produccion.domain.Sistema;
import com.victorian.produccion.services.MenuPerfilServices;
import com.victorian.produccion.services.MenuServices;

@ManagedBean(name = "permisosPerfilMB")
@ViewScoped
public class PermisosPerfilMB extends GenericBeans implements Serializable {

	private List<Sistema> listaModulos;
	private Perfil perfil;
	private MenuServices menuServices;

	private MenuPerfilServices menuPerfilServices;

	private Log log;
	private LogMB logmb;
	@ManagedProperty(value = "#{loginMB}")
	private LoginMB login;

	public PermisosPerfilMB() {

	}

	@PostConstruct
	public void inicia() {
		this.menuPerfilServices = new MenuPerfilServices();
		this.menuServices = new MenuServices();
		log = (Log) getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();
		// System.out.println("iniciando mb asignar perfil");
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		this.perfil = (Perfil) flash.get("perfil");

		this.crearTablaSubtabla();

		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:perfiles");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * desc:crea una tabla con subtabla
	 * 
	 * @return
	 */
	public void crearTablaSubtabla() {

		try {
			MenuXPerfil menuPerfil = null;
			this.listaModulos = this.menuServices.listSistemas();
			for (Sistema sis : this.listaModulos) {
				sis.setListaMenu(this.menuServices.listMenuxSistemaId(sis.getCod_sistema()));
				for (Menu menu : sis.getListaMenu()) {
					// consultar
					menuPerfil = this.menuPerfilServices.buscarMenuPerfil(menu.getCod_menu(),
							this.perfil.getCod_perfil());
					if (menuPerfil != null) {
						menu.setBanderin(Boolean.TRUE);
					} else {
						menu.setBanderin(Boolean.FALSE);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Desc: elimina/inserta en la tabla t_opcion_menuxperfil
	 * 
	 * @param menu
	 */
	public void cambiarEstado(Menu menu) {
		// System.out.println("menu seleccionado :"+menu.getDescripcion());
		if (menu.getBanderin()) {
			// eliminar
			menu.setBanderin(Boolean.FALSE);
			try {
				this.menuPerfilServices.eliminarPerfilUsuario(menu.getCod_menu(), this.perfil.getCod_perfil());
				log.setAccion("DELETE");
				log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " ha eliminado el perfil "
						+ this.perfil.getDescripcion());
				logmb.insertarLog(log);
			} catch (Exception e) {
				// System.out.println("Error eliminando
				// menuPerfil"+e.getMessage());
				e.printStackTrace();
			}
		} else {
			// crear
			menu.setBanderin(Boolean.TRUE);
			try {
				this.menuPerfilServices.crearMenuPerfil(menu.getCod_menu(), this.perfil.getCod_perfil(), Boolean.TRUE);
				log.setAccion("INSERT");
				log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " ha creado el menu del perfil "
						+ this.perfil.getDescripcion());
				logmb.insertarLog(log);
			} catch (Exception e) {
				// System.out.println("Eliminando error
				// menuPerfil:"+e.getMessage());
				e.printStackTrace();
			}
		}

		// llamando a service para recarcar datatable
		this.crearTablaSubtabla();

	}

	/* #########--------setters y getters-------############## */

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Sistema> getListaModulos() {
		return listaModulos;
	}

	public void setListaModulos(List<Sistema> listaModulos) {
		this.listaModulos = listaModulos;
	}

	public LoginMB getLogin() {
		return login;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}

}
