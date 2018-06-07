package com.victorian.produccion.domain;

public class Maquinaria {
	private Integer idmaquinaria;
	private String descripcion;
	private String modelo;
	private String serie;
	private String estado;
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getIdmaquinaria() {
		return idmaquinaria;
	}

	public void setIdmaquinaria(Integer idmaquinaria) {
		this.idmaquinaria = idmaquinaria;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
