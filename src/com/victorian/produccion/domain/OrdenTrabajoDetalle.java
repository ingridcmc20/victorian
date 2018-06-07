package com.victorian.produccion.domain;

import java.sql.Date;

public class OrdenTrabajoDetalle {
	private Integer id_orden_trabajo;
	private Integer id_etapa;
	private Integer id_plan_produccion;
	private Date fecha_fin;
	private Date fecha_inicio;
	private Date fecha_real_termino;
	private Integer id_prioridad;

	public Integer getId_orden_trabajo() {
		return id_orden_trabajo;
	}

	public void setId_orden_trabajo(Integer id_orden_trabajo) {
		this.id_orden_trabajo = id_orden_trabajo;
	}

	public Integer getId_etapa() {
		return id_etapa;
	}

	public void setId_etapa(Integer id_etapa) {
		this.id_etapa = id_etapa;
	}

	public Integer getId_plan_produccion() {
		return id_plan_produccion;
	}

	public void setId_plan_produccion(Integer id_plan_produccion) {
		this.id_plan_produccion = id_plan_produccion;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_real_termino() {
		return fecha_real_termino;
	}

	public void setFecha_real_termino(Date fecha_real_termino) {
		this.fecha_real_termino = fecha_real_termino;
	}

	public Integer getId_prioridad() {
		return id_prioridad;
	}

	public void setId_prioridad(Integer id_prioridad) {
		this.id_prioridad = id_prioridad;
	}
}
