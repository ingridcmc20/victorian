package com.victorian.produccion.domain;

import java.sql.Date;

public class Pedido {
	private Integer id_pedido;
	private Integer tipo_prenda;
	private Integer cantidad_prenda;
	private Integer modo_pago;
	private Date fechapedido;
	private Date fecha_entrega;
	private Integer id_estado;
	private Integer id_tipoconfeccion;
	private String des_tipo_prenda;
	private String des_estado;
	private String des_tipoconfeccion;
	private String nombre_cliente;
	private String des_modo_pago;
	private boolean bool_ficha_tecnica;

	private Double subTotalProducto;
	private Double subTotalPedido;
	private Double gastosGenerales;
	private Double utilidades;
	private Double subTotal;
	private Double igv;
	private Double total;
	private Integer idplan;
	private Integer id_fichatecnica;
	private Date fechainicio;
	private Date fechafin;
	private Integer estado;

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Integer getTipo_prenda() {
		return tipo_prenda;
	}

	public void setTipo_prenda(Integer tipo_prenda) {
		this.tipo_prenda = tipo_prenda;
	}

	public Integer getCantidad_prenda() {
		return cantidad_prenda;
	}

	public void setCantidad_prenda(Integer cantidad_prenda) {
		this.cantidad_prenda = cantidad_prenda;
	}

	public Integer getModo_pago() {
		return modo_pago;
	}

	public void setModo_pago(Integer modo_pago) {
		this.modo_pago = modo_pago;
	}

	public Date getFechapedido() {
		return fechapedido;
	}

	public void setFechapedido(Date fechapedido) {
		this.fechapedido = fechapedido;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public Integer getId_tipoconfeccion() {
		return id_tipoconfeccion;
	}

	public void setId_tipoconfeccion(Integer id_tipoconfeccion) {
		this.id_tipoconfeccion = id_tipoconfeccion;
	}

	public String getDes_tipo_prenda() {
		return des_tipo_prenda;
	}

	public void setDes_tipo_prenda(String des_tipo_prenda) {
		this.des_tipo_prenda = des_tipo_prenda;
	}

	public String getDes_estado() {
		return des_estado;
	}

	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}

	public String getDes_tipoconfeccion() {
		return des_tipoconfeccion;
	}

	public void setDes_tipoconfeccion(String des_tipoconfeccion) {
		this.des_tipoconfeccion = des_tipoconfeccion;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getDes_modo_pago() {
		return des_modo_pago;
	}

	public void setDes_modo_pago(String des_modo_pago) {
		this.des_modo_pago = des_modo_pago;
	}

	public boolean isBool_ficha_tecnica() {
		return bool_ficha_tecnica;
	}

	public void setBool_ficha_tecnica(boolean bool_ficha_tecnica) {
		this.bool_ficha_tecnica = bool_ficha_tecnica;
	}

	public Double getSubTotalProducto() {
		return subTotalProducto;
	}

	public void setSubTotalProducto(Double subTotalProducto) {
		this.subTotalProducto = subTotalProducto;
	}

	public Double getSubTotalPedido() {
		return subTotalPedido;
	}

	public void setSubTotalPedido(Double subTotalPedido) {
		this.subTotalPedido = subTotalPedido;
	}

	public Double getGastosGenerales() {
		return gastosGenerales;
	}

	public void setGastosGenerales(Double gastosGenerales) {
		this.gastosGenerales = gastosGenerales;
	}

	public Double getUtilidades() {
		return utilidades;
	}

	public void setUtilidades(Double utilidades) {
		this.utilidades = utilidades;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getIdplan() {
		return idplan;
	}

	public void setIdplan(Integer idplan) {
		this.idplan = idplan;
	}

	public Integer getId_fichatecnica() {
		return id_fichatecnica;
	}

	public void setId_fichatecnica(Integer id_fichatecnica) {
		this.id_fichatecnica = id_fichatecnica;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}