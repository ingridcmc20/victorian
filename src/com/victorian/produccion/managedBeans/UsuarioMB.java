package com.victorian.produccion.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.FacesUtils;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Empresa;
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.domain.Perfil;
import com.victorian.produccion.domain.TipoUsuario;
import com.victorian.produccion.domain.Usuario;
import com.victorian.produccion.services.EmpresaService;
import com.victorian.produccion.services.MenuServices;
import com.victorian.produccion.services.TipoUsuarioService;
import com.victorian.produccion.services.UsuarioServices;

@ManagedBean(name = "usuarioMB")
@ViewScoped
public class UsuarioMB extends GenericBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginMB}")
	private LoginMB login;

	@ManagedProperty(value = "#{loginMB.usuario}")
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Usuario> usuariosFilter;
	private List<Usuario> ejecutivosFilter;
	private int id_perfil;
	private Perfil perfil;
	private UsuarioServices usuarioServices;
	private MenuServices menuServices;
	private EmpresaService empresaService;
	private TipoUsuarioService tipoUsuarioService;
	private Boolean editar;
	private String lastLogin;
	private List<Empresa> listaEmpresa;
	private List<TipoUsuario> listTipoUsuario;
	private boolean view;
	private Boolean mostrarExpediente;
	RequestContext context;

	private Log log;
	private LogMB logmb;

	// Constructor
	public UsuarioMB() {
	}

	@PostConstruct
	public void inicia() {
		this.editar = Boolean.FALSE;
		this.usuarioServices = new UsuarioServices();
		this.menuServices = new MenuServices();
		this.tipoUsuarioService = new TipoUsuarioService();
		this.usuario = new Usuario();
		this.usuarios = usuarioServices.getlistaUsuario();
		this.view = true;
		this.listaEmpresa = new ArrayList<>();
		this.empresaService = new EmpresaService();

		try {
			this.listaEmpresa = this.empresaService.listaEmpresasActivas();
			this.listTipoUsuario = tipoUsuarioService.findAll();
			this.mostrarExpediente = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.context = RequestContext.getCurrentInstance();
		this.log = (Log) getSpringBean(Constante.SESSION_LOG);
		this.logmb = new LogMB();
		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:usuarios");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cambiarEstado(Usuario user) {
		if (user.getEstado()) {
			user.setEstado(Boolean.FALSE);
		} else {
			user.setEstado(Boolean.TRUE);
		}
		try {
			this.usuarioServices.actualizarEstado(user);
			log.setAccion("UPDATE");
			log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " actualizó el estado a : "
					+ user.getEstado() + " del usuario: " + this.usuario.getLogin());
			logmb.insertarLog(log);
			FacesUtils.showFacesMessage("Se cambio de estado", Constante.INFORMACION);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Para generar los mensajes de validacion esto debe ir en otra clase
	// pero por avanze se hizo aca
	private void addMessage(String key, FacesMessage.Severity severity, String message, String detail) {
		FacesMessage msg = new FacesMessage(severity, message, detail);
		FacesContext.getCurrentInstance().addMessage(key, msg);
	}

	public String addErrorMessage() {
		addMessage(null, FacesMessage.SEVERITY_ERROR, "Sistema de Nextel", "Verifique sus Datos");
		return null;
	}

	// Para Cerrar la Session
	public String closeSession() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		if (session == null) {
			return "invalid";
		} else {
			session.invalidate();
			System.out.println("Desconexion Correcta");
			return "login";
		}
	}

	// registra
	public void registrarUsuario() {
		Boolean valido = Boolean.FALSE;
		RequestContext context2 = RequestContext.getCurrentInstance();
		context2.addCallbackParam("validationFailed", valido);

		usuario.setEstado(true);

		this.usuario.setApellido_paterno(this.usuario.getApellido_paterno().trim().toUpperCase());
		this.usuario.setApellido_materno(this.usuario.getApellido_materno().trim().toUpperCase());
		this.usuario.setNombre(this.usuario.getNombre().trim().toUpperCase());
		this.usuario.setEmail(this.usuario.getEmail().trim().toUpperCase());
		this.usuario.setLogin(this.usuario.getLogin().trim());
		this.usuario.setDireccion(this.usuario.getDireccion().trim().toUpperCase());
		try {
			if (this.editar) {
				boolean pasaDni = true;
				boolean pasaLogin = true;

				Usuario usu = this.usuarioServices.getUsuario_byIdUsuario(this.usuario.getIdusuario());
				if (usu.getDni().equals(this.usuario.getDni())) {
					pasaDni = true;
				} else {
					Usuario usuarioByDNI = usuarioServices.buscarPorDni(this.usuario.getDni());
					if (usuarioByDNI == null) {
						pasaDni = true;
					} else {
						pasaDni = false;
					}
				}

				if (usu.getLogin().equals(this.usuario.getLogin())) {
					pasaLogin = true;
				} else {
					Usuario usuarioByLogin = usuarioServices.buscarPorLogin(this.usuario.getLogin());
					if (usuarioByLogin == null) {
						pasaLogin = true;
					} else {
						pasaLogin = false;
					}
				}

				if (pasaDni) {
					if (pasaLogin) {
						this.usuarioServices.actualizar(usuario);
						log.setAccion("UPDATE");
						log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " actualizó el usuario: "
								+ this.usuario.getLogin());
						logmb.insertarLog(log);
						FacesUtils.showFacesMessage("Se actualizo correctamente el usuario", Constante.INFORMACION);
						context2.update("msgGeneral");
					} else {
						FacesUtils.showFacesMessage("Usuario ya existe", Constante.ERROR);
						context2.addCallbackParam("validationFailed", Boolean.TRUE);
					}
				} else {
					FacesUtils.showFacesMessage("DNI ya existe", Constante.ERROR);
					context2.addCallbackParam("validationFailed", Boolean.TRUE);
				}

			} else {
				// Validando si el login ya se encuentra registrado
				Usuario usuarioByDNI = usuarioServices.buscarPorDni(this.usuario.getDni());
				if (usuarioByDNI == null) {
					Usuario usuarioByLogin = usuarioServices.buscarPorLogin(this.usuario.getLogin());
					if (usuarioByLogin == null) {
						usuario.setPassword(this.usuario.getDni());
						usuario.setEs_nuevo(Boolean.TRUE);
						usuario.setDotacion(Boolean.TRUE);

						usuarioServices.insertUsuario(usuario);

						log.setAccion("INSERT");
						log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " ingresó el usuario: "
								+ this.usuario.getLogin());
						logmb.insertarLog(log);
						FacesUtils.showFacesMessage("Usuario guardado exitosamente.", Constante.INFORMACION);
						context2.update("msgGeneral");
					} else {
						FacesUtils.showFacesMessage("Usuario ya existe", Constante.ERROR);
						context2.addCallbackParam("validationFailed", Boolean.TRUE);
					}
				} else {
					FacesUtils.showFacesMessage("DNI ya existe", Constante.ERROR);
					context2.addCallbackParam("validationFailed", Boolean.TRUE);
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.usuarios = usuarioServices.getlistaUsuario();
		this.editar = Boolean.FALSE;
	}

	public void eliminarUsuario() {
		System.out.println("Vamos a Realizar una eliminacion ");
		try {
			usuarioServices.deleteUsuario(usuario.getIdusuario());
			usuarios = usuarioServices.getlistaUsuario();
			/*
			 * for(Usuario u : usuarios){ try { Centro_Atencion c = new
			 * Centro_Atencion(); c =
			 * centro_atencionServices.findById(u.getId_centro_atencion());
			 * u.setNombre_centro_atencion(c.getNombre()); } catch (Exception e)
			 * { // TODO Auto-generated catch block e.printStackTrace(); } }
			 */
			log.setAccion("DELETE");
			log.setDescripcion(
					"El usuario " + this.login.getLoginUsuario() + " eliminó el usuario: " + this.usuario.getLogin());
			logmb.insertarLog(log);
			FacesUtils.showFacesMessage("Usuario eliminado exitosamente.", Constante.INFORMACION);
		} catch (Exception e) {
			FacesUtils.showFacesMessage("Usuario no se puede eliminar tiene perfiles asociados", Constante.ERROR);
			e.printStackTrace();
		}
		// context.update("msgGeneral");

	}

	public void newInsert() {
		usuario = new Usuario();

		this.editar = Boolean.FALSE;
	}

	public void newUpdate(Usuario usu) {
		System.out.println("editando usuario");
		this.editar = Boolean.TRUE;
		this.usuario = usuarioServices.buscarPorId(usu.getIdusuario());
		lastLogin = usuario.getLogin();

		try {
			this.listaEmpresa = this.empresaService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void newDelete(Usuario user) {
		this.usuario = user;
	}

	public void resetearPassword() {
		RequestContext context2;
		context2 = RequestContext.getCurrentInstance();

		System.out.println("el idusuario que selecciono es  " + usuario.getIdusuario());

		try {
			this.usuarioServices.resetearPassword(this.usuario);
			FacesUtils.showFacesMessage("Reseteado Password Correctamente.", Constante.INFORMACION);
			context2.update("msgGeneral");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/****************************/
	public void newUserResetPass(Usuario usu) {
		this.usuario = usu;
	}

	public String agregarPerfil(Usuario user) {
		String outcome = null;
		// log.info("entrando a agregar perfil");
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("usuario", user);
		System.out.println("enviando cadena de redireccion");
		outcome = "pretty:addPerfilUsuario";
		log.setAccion("UPDATE");
		log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " actualizó el perfil a : " + user.getEstado()
				+ " del usuario: " + this.usuario.getLogin());
		logmb.insertarLog(log);
		return outcome;
		// return "/faces/control_acceso/addPerfilUsuario?faces-redirect=true";

	}

	// Getter and Setter

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	public List<Usuario> getUsuariosFilter() {
		return usuariosFilter;
	}

	public void setUsuariosFilter(List<Usuario> usuariosFilter) {
		this.usuariosFilter = usuariosFilter;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioServices getUsuarioServices() {
		return usuarioServices;
	}

	public void setUsuarioServices(UsuarioServices usuarioServices) {
		this.usuarioServices = usuarioServices;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}

	public LoginMB getLogin() {
		return login;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public LogMB getLogmb() {
		return logmb;
	}

	public void setLogmb(LogMB logmb) {
		this.logmb = logmb;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Usuario> getEjecutivosFilter() {
		return ejecutivosFilter;
	}

	public void setEjecutivosFilter(List<Usuario> ejecutivosFilter) {
		this.ejecutivosFilter = ejecutivosFilter;
	}

	public boolean isView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}

	public List<TipoUsuario> getListTipoUsuario() {
		return listTipoUsuario;
	}

	public void setListTipoUsuario(List<TipoUsuario> listTipoUsuario) {
		this.listTipoUsuario = listTipoUsuario;
	}

	public Boolean getMostrarExpediente() {
		return mostrarExpediente;
	}

	public void setMostrarExpediente(Boolean mostrarExpediente) {
		this.mostrarExpediente = mostrarExpediente;
	}


}