package com.victorian.produccion.domain;

import java.sql.Date;

public class PlanProduccion {
	private Integer id_planproduccion;
	private Date fecha_inicioplan;
	private Date fecha_finplan;
	private Integer cantidad_operarios;
	private Integer cantidad_maquinaria;
	private Integer id_pedido;
	private Date fecha_registro;
	private Integer id_estado;
	private String des_estado;

	public Integer getId_planproduccion() {
		return id_planproduccion;
	}

	public void setId_planproduccion(Integer id_planproduccion) {
		this.id_planproduccion = id_planproduccion;
	}

	public Date getFecha_inicioplan() {
		return fecha_inicioplan;
	}

	public void setFecha_inicioplan(Date fecha_inicioplan) {
		this.fecha_inicioplan = fecha_inicioplan;
	}

	public Date getFecha_finplan() {
		return fecha_finplan;
	}

	public void setFecha_finplan(Date fecha_finplan) {
		this.fecha_finplan = fecha_finplan;
	}

	public Integer getCantidad_operarios() {
		return cantidad_operarios;
	}

	public void setCantidad_operarios(Integer cantidad_operarios) {
		this.cantidad_operarios = cantidad_operarios;
	}

	public Integer getCantidad_maquinaria() {
		return cantidad_maquinaria;
	}

	public void setCantidad_maquinaria(Integer cantidad_maquinaria) {
		this.cantidad_maquinaria = cantidad_maquinaria;
	}

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getDes_estado() {
		return des_estado;
	}

	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}
}
