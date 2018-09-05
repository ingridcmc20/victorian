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
import com.victorian.produccion.domain.Cargo;
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.services.CargoServices;
import com.victorian.produccion.services.MenuServices;

@ManagedBean(name = "cargoMB")
@ViewScoped
public class CargoMB extends GenericBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cargo cargo;
	private List<Cargo> listaCargos;
	private Cargo cargoSelec;
	private Boolean editar;

	private CargoServices cargoServices;
	private MenuServices menuServices;

	public CargoMB() {
	}

	private Log log;
	private LogMB logmb;
	RequestContext context;
	@ManagedProperty(value = "#{loginMB}")
	private LoginMB login;

	@PostConstruct
	public void inicia() {

		this.cargoSelec = new Cargo();
		this.editar = Boolean.FALSE;
		this.cargoServices = new CargoServices();
		menuServices = new MenuServices();

		try {
			this.listaCargos = this.cargoServices.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log = (Log) getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();
		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:cargo");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void guardarCargo() {
		Boolean valido = Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("esValido", valido);

		try {

			this.cargoSelec.setDescripcion(this.cargoSelec.getDescripcion().trim().toUpperCase());

			if (this.editar) {
				this.cargoServices.actualizarCargo(this.cargoSelec);
				FacesUtils.showFacesMessage("Cargo ha sido actualizado", 3);
				log.setAccion("UPDATE");
				log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " actualizó el tipo de cargo: "
						+ this.cargoSelec.getDescripcion());
				logmb.insertarLog(log);

			} else {
				this.cargoServices.crearCargo(this.cargoSelec);
				FacesUtils.showFacesMessage("Cargo ha sido creado", 3);
				log.setAccion("INSERT");
				log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " registró el tipo de cargo: "
						+ this.cargoSelec.getDescripcion());
				logmb.insertarLog(log);
			}

			this.cargoSelec = new Cargo();
			this.editar = Boolean.FALSE;

			this.listaCargos = this.cargoServices.findAll();

			context.update("msgGeneral");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cambiarEstado(Cargo cargo) {
		String estado = "";
		if (cargo.isActivo()) {
			cargo.setActivo(Boolean.FALSE);
			estado = "INACTIVO";
		} else {
			cargo.setActivo(Boolean.TRUE);
			estado = "ACTIVO";
		}

		try {
			this.cargoServices.actualizarCargo(cargo);
			FacesUtils.showFacesMessage("Cargo  modificado correctamente", Constante.INFORMACION);
			this.listaCargos = this.cargoServices.findAll();
			log.setAccion("UPDATE");
			log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " actualizó el estado del tipo de cargo "
					+ cargo.getDescripcion() + " a  : " + estado);
			logmb.insertarLog(log);
		} catch (Exception e) {
			// System.out.println("Error:"+e.getMessage());
			e.printStackTrace();
		}
	}

	public void nuevoCargo() {
		this.cargoSelec = new Cargo();
		this.cargoSelec.setActivo(Boolean.TRUE);
		this.editar = Boolean.FALSE;
	}

	public void editarCargo(Cargo car) {
		this.cargoSelec = car;
		this.editar = Boolean.TRUE;
	}

	public void eliminarCargo(Cargo car) {
		this.cargoSelec = car;
	}

	public void confirmaEliminar() {
		try {
			this.cargoServices.eliminarCargo(this.cargoSelec.getId_cargo());
			FacesUtils.showFacesMessage("Cargo ha sido eliminado", 3);
			this.listaCargos = this.cargoServices.findAll();
			log.setAccion("DELETE");
			log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " eliminó el tipo de cargo: "
					+ this.cargoSelec.getDescripcion());
			logmb.insertarLog(log);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * #########################################################################
	 * #########################
	 */
	/*
	 * ####################################------setters y
	 * getters----###################################
	 */
	/*
	 * #########################################################################
	 * #########################
	 */

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<Cargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	public Cargo getCargoSelec() {
		return cargoSelec;
	}

	public void setCargoSelec(Cargo cargoSelec) {
		this.cargoSelec = cargoSelec;
	}

	public Boolean getEditar() {
		return editar;
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
