package com.victorian.produccion.domain;

public class TipoMoneda {
	
	private Integer id_tipo_moneda;
	private String descripcion;
	private Boolean estado;
	
	
	public Integer getId_tipo_moneda() {
		return id_tipo_moneda;
	}
	public void setId_tipo_moneda(Integer id_tipo_moneda) {
		this.id_tipo_moneda = id_tipo_moneda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	

}
