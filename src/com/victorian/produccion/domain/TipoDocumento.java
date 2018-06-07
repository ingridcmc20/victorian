package com.victorian.produccion.domain;

public class TipoDocumento {

	private Integer id_tipo_documento;
	private String descripcion;
	private Boolean estado;
	
	public Integer getId_tipo_documento() {
		return id_tipo_documento;
	}
	public void setId_tipo_documento(Integer id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
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
