package com.victorian.produccion.domain;

public class AsignacionRecurso {
	private Integer id_asignacion_recurso;
	private Integer id_pedido;
	private Integer id_cortador;
	private Integer id_confeccionista;
	private Integer id_empaquetador;
	private Integer id_maquina_corte;
	private Integer id_maquina_confeccion;

	public Integer getId_asignacion_recurso() {
		return id_asignacion_recurso;
	}

	public void setId_asignacion_recurso(Integer id_asignacion_recurso) {
		this.id_asignacion_recurso = id_asignacion_recurso;
	}

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Integer getId_cortador() {
		return id_cortador;
	}

	public void setId_cortador(Integer id_cortador) {
		this.id_cortador = id_cortador;
	}

	public Integer getId_confeccionista() {
		return id_confeccionista;
	}

	public void setId_confeccionista(Integer id_confeccionista) {
		this.id_confeccionista = id_confeccionista;
	}

	public Integer getId_empaquetador() {
		return id_empaquetador;
	}

	public void setId_empaquetador(Integer id_empaquetador) {
		this.id_empaquetador = id_empaquetador;
	}

	public Integer getId_maquina_corte() {
		return id_maquina_corte;
	}

	public void setId_maquina_corte(Integer id_maquina_corte) {
		this.id_maquina_corte = id_maquina_corte;
	}

	public Integer getId_maquina_confeccion() {
		return id_maquina_confeccion;
	}

	public void setId_maquina_confeccion(Integer id_maquina_confeccion) {
		this.id_maquina_confeccion = id_maquina_confeccion;
	}
}
