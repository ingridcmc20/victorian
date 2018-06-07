package com.victorian.produccion.domain;

import java.sql.Date;

public class PlanProduccion {
	private Integer idplan;
	private Date fechainicioplan;
	private Date fechafinplan;
	private Integer cantidad_operarios;
	private Integer maquinaria;
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdplan() {
		return idplan;
	}

	public void setIdplan(Integer idplan) {
		this.idplan = idplan;
	}

	public Date getFechainicioplan() {
		return fechainicioplan;
	}

	public void setFechainicioplan(Date fechainicioplan) {
		this.fechainicioplan = fechainicioplan;
	}

	public Date getFechafinplan() {
		return fechafinplan;
	}

	public void setFechafinplan(Date fechafinplan) {
		this.fechafinplan = fechafinplan;
	}

	public Integer getCantidad_operarios() {
		return cantidad_operarios;
	}

	public void setCantidad_operarios(Integer cantidad_operarios) {
		this.cantidad_operarios = cantidad_operarios;
	}

	public Integer getMaquinaria() {
		return maquinaria;
	}

	public void setMaquinaria(Integer maquinaria) {
		this.maquinaria = maquinaria;
	}

}
