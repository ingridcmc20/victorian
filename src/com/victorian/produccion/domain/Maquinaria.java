package com.victorian.produccion.domain;

public class Maquinaria {
	private Integer id_maquinaria;
	private String descripcion;
	private String modelo;
	private String serie;
	private String tipo;
	private boolean activo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId_maquinaria() {
		return id_maquinaria;
	}

	public void setId_maquinaria(Integer id_maquinaria) {
		this.id_maquinaria = id_maquinaria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
