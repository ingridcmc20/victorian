package com.victorian.produccion.domain;

import java.sql.Date;

public class PlanPedido {
	private Integer idplan;
	private Integer idpedido;
	private Integer idfichatecnica;
	private Date fechainicio;
	private Date fechafin;
	private Integer estado;

	public Integer getIdplan() {
		return idplan;
	}

	public void setIdplan(Integer idplan) {
		this.idplan = idplan;
	}

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	public Integer getIdfichatecnica() {
		return idfichatecnica;
	}

	public void setIdfichatecnica(Integer idfichatecnica) {
		this.idfichatecnica = idfichatecnica;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
