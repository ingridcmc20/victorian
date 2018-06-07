package com.victorian.produccion.domain;

public class Cliente {
	private Integer idcliente;
	private String nombre_cliente;
	private Integer id_tipo_doc;
	private String nro_documento;
	private Boolean activo;

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public Integer getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(Integer id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
