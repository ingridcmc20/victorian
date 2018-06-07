package com.victorian.produccion.domain;

public class OrdenTrabajoOperario {
	private Integer idoperario;
	private Integer id_orden_trabajo;
	private Integer id_prioridad;
	private Integer id_etapa;

	public Integer getId_etapa() {
		return id_etapa;
	}

	public void setId_etapa(Integer id_etapa) {
		this.id_etapa = id_etapa;
	}

	public Integer getIdoperario() {
		return idoperario;
	}

	public void setIdoperario(Integer idoperario) {
		this.idoperario = idoperario;
	}

	public Integer getId_orden_trabajo() {
		return id_orden_trabajo;
	}

	public void setId_orden_trabajo(Integer id_orden_trabajo) {
		this.id_orden_trabajo = id_orden_trabajo;
	}

	public Integer getId_prioridad() {
		return id_prioridad;
	}

	public void setId_prioridad(Integer id_prioridad) {
		this.id_prioridad = id_prioridad;
	}
}
