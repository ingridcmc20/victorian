package com.victorian.produccion.domain;

public class Insumo {
	private Integer idinsumo;
	private String descripcion;
	private Double precio;

	public Integer getIdinsumo() {
		return idinsumo;
	}

	public void setIdinsumo(Integer idinsumo) {
		this.idinsumo = idinsumo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
