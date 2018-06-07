package com.victorian.produccion.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.victorian.produccion.domain.Ubigeo;
import com.victorian.produccion.services.UbigeoService;

@ViewScoped
@ManagedBean(name = "ucaMB")
public class UtilCombosAnidadosMB {
	
	

	private List<Ubigeo> u_listaUbigeo;
	private List<Ubigeo> u_listaDepartamento;
	private List<Ubigeo> u_listaProvincia;
	private List<Ubigeo> u_listaDistrito;
	private Ubigeo u_departamento;
	private Ubigeo u_provincia;
	private Ubigeo u_distrito;
	
	// services
	private UbigeoService ubigeoService;

	public void cargarListas_oficina() {
		this.ubigeoService = new UbigeoService();

		this.u_listaUbigeo = new ArrayList<Ubigeo>();
		this.u_listaDepartamento = new ArrayList<Ubigeo>();
		this.u_listaProvincia = new ArrayList<Ubigeo>();
		this.u_listaDistrito = new ArrayList<Ubigeo>();
		this.u_departamento = new Ubigeo();
		this.u_provincia = new Ubigeo();
		this.u_distrito = new Ubigeo();

		try {
			this.u_listaUbigeo = this.ubigeoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void inicializarComboUbigeo() {
		this.u_listaDepartamento = this.ubigeoService.listarDepartamentos();
		this.u_listaProvincia = new ArrayList<Ubigeo>();
		this.u_listaDistrito = new ArrayList<Ubigeo>();

		this.u_departamento = new Ubigeo();
		this.u_provincia = new Ubigeo();
		this.u_distrito = new Ubigeo();
	}

	public void seleccionarDepartamento() {
		this.u_listaProvincia = this.ubigeoService.listarProvincias(this.u_departamento.getSdepartamento());
		this.u_listaDistrito = new ArrayList<Ubigeo>();

		this.u_distrito = new Ubigeo();
	}

	public void seleccionarProvincia() {
		this.u_listaDistrito = this.ubigeoService.listardistritos(this.u_departamento.getSdepartamento(), this.u_provincia.getSprovincia());

	}

	public void seleccionarDistrito() {

	}

	public Ubigeo getU_departamento() {
		return u_departamento;
	}

	public void setU_departamento(Ubigeo u_departamento) {
		this.u_departamento = u_departamento;
	}

	public Ubigeo getU_provincia() {
		return u_provincia;
	}

	public void setU_provincia(Ubigeo u_provincia) {
		this.u_provincia = u_provincia;
	}

	public Ubigeo getU_distrito() {
		return u_distrito;
	}

	public void setU_distrito(Ubigeo u_distrito) {
		this.u_distrito = u_distrito;
	}

	public List<Ubigeo> getU_listaDepartamento() {
		return u_listaDepartamento;
	}

	public List<Ubigeo> getU_listaProvincia() {
		return u_listaProvincia;
	}

	public List<Ubigeo> getU_listaDistrito() {
		return u_listaDistrito;
	}

	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}

	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}

}
