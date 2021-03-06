package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Ubigeo;
import com.victorian.produccion.services.UbigeoService;

@ManagedBean(name="ubigeoMB")
@ViewScoped
public class UbigeoMB extends GenericBeans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Ubigeo> listUbigeo;
	private List<Ubigeo> listUbigeofilter;
	
	private Boolean editar;
	
	//services
	private UbigeoService ubigeoService;
	
	
	
	public UbigeoMB(){;}
	
	@PostConstruct
	public void incia()
	{
	
		this.ubigeoService = new UbigeoService();
		
		//listando
		try {
			this.listUbigeo = ubigeoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Ubigeo> getListUbigeo() {
		return listUbigeo;
	}

	public void setListUbigeo(List<Ubigeo> listUbigeo) {
		this.listUbigeo = listUbigeo;
	}

	public List<Ubigeo> getListUbigeofilter() {
		return listUbigeofilter;
	}

	public void setListUbigeofilter(List<Ubigeo> listUbigeofilter) {
		this.listUbigeofilter = listUbigeofilter;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}

	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}
	

	
	
}

