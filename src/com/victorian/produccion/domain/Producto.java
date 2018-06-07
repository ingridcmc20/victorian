package com.victorian.produccion.domain;

import java.math.BigDecimal;

public class Producto {
	
	private Integer id_producto;
	private Integer id_negocio;
	private String descripcion;
	private boolean estado;
	private String des_negocio;
	private String codigoProducto;
	private Integer idformato;
	private String codigoBanco;
	private Formato formato;
	private Integer id_sub_producto;
	private Integer contador;
	
	private Integer id_indicadores_call;
	private Integer id_categoria_call;	
	
	//transitorias
	private Integer totalRegistros;
	private Integer totalRegistrosEncontrados;
	private Integer totalRegistrosNoEncontrados;
	private BigDecimal montoSolicitado;
	private BigDecimal montoAprobado;
	private Boolean estadoFacturacion;

	private BigDecimal montoSolicitadoEncontrado;
	private BigDecimal montoAprobadoEncontrado;
	private BigDecimal montoSolicitadoNoEncontrado;
	private BigDecimal montoAprobadoNoEncontrado;
	
	public Producto(){
	}
	
	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getDes_negocio() {
		return des_negocio;
	}

	public void setDes_negocio(String des_negocio) {
		this.des_negocio = des_negocio;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public Integer getIdformato() {
		return idformato;
	}

	public void setIdformato(Integer idformato) {
		this.idformato = idformato;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}



	public Integer getTotalRegistros() {
		return totalRegistros;
	}



	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}



	public Integer getTotalRegistrosEncontrados() {
		return totalRegistrosEncontrados;
	}

	public void setTotalRegistrosEncontrados(Integer totalRegistrosEncontrados) {
		this.totalRegistrosEncontrados = totalRegistrosEncontrados;
	}

	public Integer getTotalRegistrosNoEncontrados() {
		return totalRegistrosNoEncontrados;
	}

	public void setTotalRegistrosNoEncontrados(Integer totalRegistrosNoEncontrados) {
		this.totalRegistrosNoEncontrados = totalRegistrosNoEncontrados;
	}

	public BigDecimal getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(BigDecimal montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public BigDecimal getMontoAprobado() {
		return montoAprobado;
	}

	public void setMontoAprobado(BigDecimal montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	public Boolean getEstadoFacturacion() {
		return estadoFacturacion;
	}

	public void setEstadoFacturacion(Boolean estadoFacturacion) {
		this.estadoFacturacion = estadoFacturacion;
	}

	public BigDecimal getMontoSolicitadoEncontrado() {
		return montoSolicitadoEncontrado;
	}

	public void setMontoSolicitadoEncontrado(BigDecimal montoSolicitadoEncontrado) {
		this.montoSolicitadoEncontrado = montoSolicitadoEncontrado;
	}

	public BigDecimal getMontoAprobadoEncontrado() {
		return montoAprobadoEncontrado;
	}

	public void setMontoAprobadoEncontrado(BigDecimal montoAprobadoEncontrado) {
		this.montoAprobadoEncontrado = montoAprobadoEncontrado;
	}

	public BigDecimal getMontoSolicitadoNoEncontrado() {
		return montoSolicitadoNoEncontrado;
	}

	public void setMontoSolicitadoNoEncontrado(
			BigDecimal montoSolicitadoNoEncontrado) {
		this.montoSolicitadoNoEncontrado = montoSolicitadoNoEncontrado;
	}

	public BigDecimal getMontoAprobadoNoEncontrado() {
		return montoAprobadoNoEncontrado;
	}

	public void setMontoAprobadoNoEncontrado(BigDecimal montoAprobadoNoEncontrado) {
		this.montoAprobadoNoEncontrado = montoAprobadoNoEncontrado;
	}

	public Integer getId_sub_producto() {
		return id_sub_producto;
	}

	public void setId_sub_producto(Integer id_sub_producto) {
		this.id_sub_producto = id_sub_producto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}

	public Integer getId_indicadores_call() {
		return id_indicadores_call;
	}

	public void setId_indicadores_call(Integer id_indicadores_call) {
		this.id_indicadores_call = id_indicadores_call;
	}

	public Integer getId_categoria_call() {
		return id_categoria_call;
	}

	public void setId_categoria_call(Integer id_categoria_call) {
		this.id_categoria_call = id_categoria_call;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}
	
}
