package com.victorian.produccion.domain;

public class Recurso {
	private String tipo_recurso;
	private Integer cantidad;

	public String getTipo_recurso() {
		return tipo_recurso;
	}

	public void setTipo_recurso(String tipo_recurso) {
		this.tipo_recurso = tipo_recurso;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
