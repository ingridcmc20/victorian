package com.victorian.produccion.domain;

public class Merma {
	private Integer id_merma;
	private Integer id_ordentrabajo;
	private String descripcion;
	private Integer id_estado;

	public Integer getId_merma() {
		return id_merma;
	}

	public void setId_merma(Integer id_merma) {
		this.id_merma = id_merma;
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

	public Integer getId_ordentrabajo() {
		return id_ordentrabajo;
	}

	public void setId_ordentrabajo(Integer id_ordentrabajo) {
		this.id_ordentrabajo = id_ordentrabajo;
	}
}
