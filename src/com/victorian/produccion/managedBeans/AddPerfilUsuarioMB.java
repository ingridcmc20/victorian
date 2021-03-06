package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.primefaces.context.RequestContext;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.FacesUtils;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.domain.Perfil;
import com.victorian.produccion.domain.Usuario;
import com.victorian.produccion.domain.UsuarioPerfil;
import com.victorian.produccion.services.MenuServices;
import com.victorian.produccion.services.PerfilServices;
import com.victorian.produccion.services.UsuarioPerfilServices;

@ManagedBean(name = "addPerfilUsuarioMB")
@ViewScoped
public class AddPerfilUsuarioMB extends GenericBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Perfil> listaPerfil;
	private List<UsuarioPerfil> listaPerfilUsuario;
	private PerfilServices perfilServices;
	private UsuarioPerfilServices usuarioPerfilServices;
	private UsuarioPerfil usuarioPerfil;
	private Perfil perfil;
	private RequestContext context;
	private Log log;
	private LogMB logmb;
	private MenuServices menuServices;
	@ManagedProperty(value = "#{loginMB}")
	private LoginMB login;

	@PostConstruct
	public void inicia() {

		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		this.usuario = (Usuario) flash.get("usuario");

		this.usuarioPerfilServices = new UsuarioPerfilServices();
		this.perfilServices = new PerfilServices();
		this.perfil = new Perfil();
		this.context = RequestContext.getCurrentInstance();
		menuServices = new MenuServices();
		log = (Log) getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();

		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:usuarios");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
			listaPerfil = perfilServices.listPerfil();
			// System.out.println("tamano de lista perfiles usuario
			// :"+usuarioPerfilServices.listarPerfilesPorUsuario(this.usuario.getId_usuario()).size());
			listaPerfilUsuario = usuarioPerfilServices.listarPerfilesPorUsuario(this.usuario.getId_usuario());
		} catch (Exception e) {
			// System.out.println("Error :"+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void insertarPerfil() {

		// System.out.println("verificando que no este repetido");
		try {
			this.usuarioPerfil = this.usuarioPerfilServices.buscarPerfilUsuario(this.usuario.getId_usuario(),
					this.perfil.getCod_perfil());
			if (this.usuarioPerfil != null) {
				FacesUtils.showFacesMessage("Perfil ya existe,Seleccione un perfil valido", Constante.ADVERTENCIA);
			} else {

				// System.out.println("Ahora si grabamos");
				this.perfil = this.perfilServices.findPerfilPorCodigo(this.perfil.getCod_perfil());
				UsuarioPerfil usrPerfil = new UsuarioPerfil();
				usrPerfil.setCod_perfil(this.perfil.getCod_perfil());
				usrPerfil.setId_usuario(this.usuario.getId_usuario());
				usrPerfil.setFecha_finvig(new Date());
				usrPerfil.setFecha_iniciovig(new Date());
				usrPerfil.setFecha_modif(new Date());
				// usrPerfil.setUsuario_modif(this.login.getLogin());
				// usrPerfil.setUsuario_registro(this.login.getLogin());
				usrPerfil.setFecha_registro(new Date());
				usrPerfil.setInd_activo(Boolean.TRUE);
				this.usuarioPerfilServices.insertUsuarioPeril(usrPerfil);
				log.setAccion("INSERT");
				log.setDescripcion("Se a�adi� el perfil " + this.perfil.getDescripcion() + " al usuario "
						+ this.usuario.getNombre() + " " + this.usuario.getApellido_paterno()
						+ this.usuario.getApellido_materno());
				logmb.insertarLog(log);
				this.listaPerfilUsuario = this.usuarioPerfilServices
						.listarPerfilesPorUsuario(this.usuario.getId_usuario());

				FacesUtils.showFacesMessage("Perfil guardado correctamente", Constante.INFORMACION);
			}

			context.update("msgGeneral");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void eliminarPerfil() {
		// System.out.println("eliminar perfil:
		// "+this.usuarioPerfil.getCod_perfil());
		try {
			this.usuarioPerfilServices.eliminarPerfilUsuario(this.usuario.getId_usuario(),
					this.usuarioPerfil.getCod_perfil());
			listaPerfilUsuario = this.usuarioPerfilServices.listarPerfilesPorUsuario(this.usuario.getId_usuario());
			log.setAccion("DELETE");
			log.setDescripcion("Se elimin� el perfil " + this.usuarioPerfil.getDescripcion() + " al usuario "
					+ this.usuario.getNombre() + " " + this.usuario.getApellido_paterno()
					+ this.usuario.getApellido_materno());

			logmb.insertarLog(log);
			FacesUtils.showFacesMessage("Perfil eliminado correctamente", Constante.INFORMACION);
			RequestContext.getCurrentInstance().update("grSms");
		} catch (Exception e) {
			// System.out.println("Error :"+e.getMessage());
		}

	}

	/*
	 * #######################---getters y
	 * setters----------########################
	 */

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public List<UsuarioPerfil> getListaPerfilUsuario() {
		return listaPerfilUsuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	public void setListaPerfilUsuario(List<UsuarioPerfil> listaPerfilUsuario) {
		this.listaPerfilUsuario = listaPerfilUsuario;
	}

	public AddPerfilUsuarioMB() {

	}

	public UsuarioPerfil getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public LoginMB getLogin() {
		return login;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}

}
