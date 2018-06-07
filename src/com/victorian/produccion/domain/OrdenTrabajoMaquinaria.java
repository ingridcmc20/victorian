package com.victorian.produccion.domain;

public class OrdenTrabajoMaquinaria {
	private Integer idmaquinaria;
	private Integer id_orden_trabajo;
	private Integer id_prioridad;

	public Integer getIdmaquinaria() {
		return idmaquinaria;
	}

	public void setIdmaquinaria(Integer idmaquinaria) {
		this.idmaquinaria = idmaquinaria;
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
