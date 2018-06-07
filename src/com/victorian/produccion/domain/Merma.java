package com.victorian.produccion.domain;

public class Merma {
	private Integer id_merma;
	private Integer id_orden_trabajo;
	private String descripcion;
	private Integer id_estado;

	public Integer getId_merma() {
		return id_merma;
	}

	public void setId_merma(Integer id_merma) {
		this.id_merma = id_merma;
	}

	public Integer getId_orden_trabajo() {
		return id_orden_trabajo;
	}

	public void setId_orden_trabajo(Integer id_orden_trabajo) {
		this.id_orden_trabajo = id_orden_trabajo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
}
