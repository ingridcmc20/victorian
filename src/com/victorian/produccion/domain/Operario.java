package com.victorian.produccion.domain;

import java.sql.Timestamp;

public class Operario {
	private Integer idoperario;
	private String tipo_operario;
	private Integer estado;
	private String nombre_operario;
	private Integer num_pedidos;
	private Integer id_nivel;
	private Integer puntaje_acumulado;
	private Integer puntaje_obtenido;
	private Timestamp fecha_subida_nivel;

	public Integer getId_nivel() {
		return id_nivel;
	}

	public void setId_nivel(Integer id_nivel) {
		this.id_nivel = id_nivel;
	}

	public Integer getPuntaje_acumulado() {
		return puntaje_acumulado;
	}

	public void setPuntaje_acumulado(Integer puntaje_acumulado) {
		this.puntaje_acumulado = puntaje_acumulado;
	}

	public Integer getPuntaje_obtenido() {
		return puntaje_obtenido;
	}

	public void setPuntaje_obtenido(Integer puntaje_obtenido) {
		this.puntaje_obtenido = puntaje_obtenido;
	}

	public Timestamp getFecha_subida_nivel() {
		return fecha_subida_nivel;
	}

	public void setFecha_subida_nivel(Timestamp fecha_subida_nivel) {
		this.fecha_subida_nivel = fecha_subida_nivel;
	}

	public Integer getNum_pedidos() {
		return num_pedidos;
	}

	public void setNum_pedidos(Integer num_pedidos) {
		this.num_pedidos = num_pedidos;
	}

	public Integer getIdoperario() {
		return idoperario;
	}

	public void setIdoperario(Integer idoperario) {
		this.idoperario = idoperario;
	}

	public String getTipo_operario() {
		return tipo_operario;
	}

	public void setTipo_operario(String tipo_operario) {
		this.tipo_operario = tipo_operario;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombre_operario() {
		return nombre_operario;
	}

	public void setNombre_operario(String nombre_operario) {
		this.nombre_operario = nombre_operario;
	}
}
