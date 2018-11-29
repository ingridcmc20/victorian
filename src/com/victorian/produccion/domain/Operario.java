package com.victorian.produccion.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Operario {
	private Integer id_operario;
	private Integer id_tipooperario;
	private String des_tipooperario;
	private Integer puntaje_acumulado;
	private Integer disponible;
	private Boolean activo;
	private String nombre_operario;
	private Integer num_pedidos;
	private Integer id_nivel;
	private Timestamp fecha_subida_nivel;

	// Datos de la orden de trabajo detalle
	private Integer id_ordentrabajo;
	private Integer id_etapa;
	private Date fecha_fin;
	private Date fecha_real_fin;

	public Integer getId_operario() {
		return id_operario;
	}

	public void setId_operario(Integer id_operario) {
		this.id_operario = id_operario;
	}

	public Integer getId_tipooperario() {
		return id_tipooperario;
	}

	public void setId_tipooperario(Integer id_tipooperario) {
		this.id_tipooperario = id_tipooperario;
	}

	public Integer getPuntaje_acumulado() {
		return puntaje_acumulado;
	}

	public void setPuntaje_acumulado(Integer puntaje_acumulado) {
		this.puntaje_acumulado = puntaje_acumulado;
	}

	public Integer getDisponible() {
		return disponible;
	}

	public void setDisponible(Integer disponible) {
		this.disponible = disponible;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombre_operario() {
		return nombre_operario;
	}

	public void setNombre_operario(String nombre_operario) {
		this.nombre_operario = nombre_operario;
	}

	public Integer getNum_pedidos() {
		return num_pedidos;
	}

	public void setNum_pedidos(Integer num_pedidos) {
		this.num_pedidos = num_pedidos;
	}

	public Integer getId_nivel() {
		return id_nivel;
	}

	public void setId_nivel(Integer id_nivel) {
		this.id_nivel = id_nivel;
	}

	public Timestamp getFecha_subida_nivel() {
		return fecha_subida_nivel;
	}

	public void setFecha_subida_nivel(Timestamp fecha_subida_nivel) {
		this.fecha_subida_nivel = fecha_subida_nivel;
	}

	public String getDes_tipooperario() {
		return des_tipooperario;
	}

	public void setDes_tipooperario(String des_tipooperario) {
		this.des_tipooperario = des_tipooperario;
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

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_real_fin() {
		return fecha_real_fin;
	}

	public void setFecha_real_fin(Date fecha_real_fin) {
		this.fecha_real_fin = fecha_real_fin;
	}

}
