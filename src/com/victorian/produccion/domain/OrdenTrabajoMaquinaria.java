package com.victorian.produccion.domain;

public class OrdenTrabajoMaquinaria {
	private Integer id_maquinaria;
	private Integer id_ordentrabajo;
	private Integer id_etapa;
	private String observacion;

	public Integer getId_maquinaria() {
		return id_maquinaria;
	}

	public void setId_maquinaria(Integer id_maquinaria) {
		this.id_maquinaria = id_maquinaria;
	}

	public Integer getId_ordentrabajo() {
		return id_ordentrabajo;
	}

	public void setId_ordentrabajo(Integer id_ordentrabajo) {
		this.id_ordentrabajo = id_ordentrabajo;
	}

	public Integer getId_etapa() {
		return id_etapa;
	}

	public void setId_etapa(Integer id_etapa) {
		this.id_etapa = id_etapa;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
