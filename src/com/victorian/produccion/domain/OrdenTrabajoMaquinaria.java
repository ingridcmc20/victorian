package com.victorian.produccion.domain;

public class OrdenTrabajoMaquinaria {
	private Integer id_maquinaria;
	private Integer id_orden_trabajo;
	private Integer id_prioridad;

	public Integer getId_maquinaria() {
		return id_maquinaria;
	}

	public void setId_maquinaria(Integer id_maquinaria) {
		this.id_maquinaria = id_maquinaria;
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
