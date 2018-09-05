package com.victorian.produccion.domain;

public class Insumo {
	private Integer id_insumo;
	private String descripcion;
	private Double precio;

	public Integer getId_insumo() {
		return id_insumo;
	}

	public void setId_insumo(Integer id_insumo) {
		this.id_insumo = id_insumo;
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
