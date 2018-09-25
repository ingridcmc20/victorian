package com.victorian.produccion.domain;

import java.sql.Timestamp;

public class OrdenTrabajoOperario {
	private Integer id_operario;
	private Integer id_ordentrabajo;
	private Integer id_etapa;
	private Integer id_nivel;
	private Integer puntaje_obtenido;
	private Timestamp fecha_nivel;

	public Integer getId_operario() {
		return id_operario;
	}

	public void setId_operario(Integer id_operario) {
		this.id_operario = id_operario;
	}

	public Integer getId_etapa() {
		return id_etapa;
	}

	public void setId_etapa(Integer id_etapa) {
		this.id_etapa = id_etapa;
	}

	public Integer getId_ordentrabajo() {
		return id_ordentrabajo;
	}

	public void setId_ordentrabajo(Integer id_ordentrabajo) {
		this.id_ordentrabajo = id_ordentrabajo;
	}

	public Integer getId_nivel() {
		return id_nivel;
	}

	public void setId_nivel(Integer id_nivel) {
		this.id_nivel = id_nivel;
	}

	public Integer getPuntaje_obtenido() {
		return puntaje_obtenido;
	}

	public void setPuntaje_obtenido(Integer puntaje_obtenido) {
		this.puntaje_obtenido = puntaje_obtenido;
	}

	public Timestamp getFecha_nivel() {
		return fecha_nivel;
	}

	public void setFecha_nivel(Timestamp fecha_nivel) {
		this.fecha_nivel = fecha_nivel;
	}
}
