package com.victorian.produccion.domain;

public class TipoDocumento {

	private Integer id_tipodocumento;
	private String descripcion;
	private Boolean activo;


	public Integer getId_tipodocumento() {
		return id_tipodocumento;
	}

	public void setId_tipodocumento(Integer id_tipodocumento) {
		this.id_tipodocumento = id_tipodocumento;
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
