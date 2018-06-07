package com.victorian.produccion.domain;

public class Proveedor {
	
	private Integer id_proveedor;
	private String razon_social;
	private String ruc;
	
	public Proveedor() {
	}

	public Integer getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(Integer id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
}
