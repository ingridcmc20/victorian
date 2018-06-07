package com.victorian.produccion.domain;

import java.io.Serializable;

public class TipoUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tipo_usuario_id;
	
	private String descripcion;

	public Integer getTipo_usuario_id() {
		return tipo_usuario_id;
	}

	public void setTipo_usuario_id(Integer tipo_usuario_id) {
		this.tipo_usuario_id = tipo_usuario_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
