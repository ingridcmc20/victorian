package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.services.OperarioServices;

@ManagedBean(name = "asignarBonoOperarioMB")
@ViewScoped
public class AsignarBonoOperarioMB extends GenericBeans implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Operario> listaOperarios;
	private OperarioServices operarioServices;
	
	@PostConstruct
	public void inicia() {
		try {
			operarioServices = new OperarioServices();
			listaOperarios = operarioServices.findCortadorYConfeccion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Operario> getListaOperarios() {
		return listaOperarios;
	}

	public void setListaOperarios(List<Operario> listaOperarios) {
		this.listaOperarios = listaOperarios;
	}
	
	
}
