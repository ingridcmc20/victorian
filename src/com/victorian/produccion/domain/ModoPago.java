package com.victorian.produccion.domain;

public class ModoPago {
	private Integer id_modo_pago;
	private String descripcion;
	private Boolean activo;

	public Integer getId_modo_pago() {
		return id_modo_pago;
	}

	public void setId_modo_pago(Integer id_modo_pago) {
		this.id_modo_pago = id_modo_pago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
