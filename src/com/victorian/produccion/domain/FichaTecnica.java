package com.victorian.produccion.domain;

public class FichaTecnica {
	private Integer id_fichatecnica;
	private String nombreinsumo;
	private String unidad;
	private Double cantidad;
	private Double precio_unidad;
	private Double precio_total;
	private Integer id_producto;
	private Integer id_insumo;
	private String nom_insumo;

	public Integer getId_insumo() {
		return id_insumo;
	}

	public void setId_insumo(Integer id_insumo) {
		this.id_insumo = id_insumo;
	}

	public String getNom_insumo() {
		return nom_insumo;
	}

	public void setNom_insumo(String nom_insumo) {
		this.nom_insumo = nom_insumo;
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

	public Double getPrecio_unidad() {
		return precio_unidad;
	}

	public void setPrecio_unidad(Double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	public Double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(Double precio_total) {
		this.precio_total = precio_total;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public Integer getId_fichatecnica() {
		return id_fichatecnica;
	}

	public void setId_fichatecnica(Integer id_fichatecnica) {
		this.id_fichatecnica = id_fichatecnica;
	}

}
