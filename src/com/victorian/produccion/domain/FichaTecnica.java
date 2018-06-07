package com.victorian.produccion.domain;

public class FichaTecnica {
	private Integer idfichatecnica;
	private String nombreinsumo;
	private String unidad;
	private Double cantidad;
	private Double preciounidad;
	private Double preciototal;
	private Integer idproducto;
	private Integer idinsumo;
	private String nom_insumo;

	public String getNom_insumo() {
		return nom_insumo;
	}

	public void setNom_insumo(String nom_insumo) {
		this.nom_insumo = nom_insumo;
	}

	public Integer getIdfichatecnica() {
		return idfichatecnica;
	}

	public void setIdfichatecnica(Integer idfichatecnica) {
		this.idfichatecnica = idfichatecnica;
	}

	public String getNombreinsumo() {
		return nombreinsumo;
	}

	public void setNombreinsumo(String nombreinsumo) {
		this.nombreinsumo = nombreinsumo;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPreciounidad() {
		return preciounidad;
	}

	public void setPreciounidad(Double preciounidad) {
		this.preciounidad = preciounidad;
	}

	public Double getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(Double preciototal) {
		this.preciototal = preciototal;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public Integer getIdinsumo() {
		return idinsumo;
	}

	public void setIdinsumo(Integer idinsumo) {
		this.idinsumo = idinsumo;
	}
}
