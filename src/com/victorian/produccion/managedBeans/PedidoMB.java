package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.FacesUtils;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Pedido;
import com.victorian.produccion.domain.Producto;
import com.victorian.produccion.domain.TipoConfeccion;
import com.victorian.produccion.services.PedidoServices;
import com.victorian.produccion.services.ProductoServices;
import com.victorian.produccion.services.TipoConfeccionServices;

@ManagedBean(name = "pedidoMB")
@ViewScoped
public class PedidoMB extends GenericBeans implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pedido pedido;
	private List<Pedido> listaPedidos;
	private List<Producto> listaProducto;
	private List<TipoConfeccion> listaTipoConfeccion;
	private Pedido pedidoSelec;
	private Boolean editar;
	private Date fecha_pedido;
	private Date fecha_entrega;

	private PedidoServices pedidoServices;
	private ProductoServices productoServices;
	private TipoConfeccionServices tipoConfeccionServices;

	RequestContext context;

	@PostConstruct
	public void inicia() {
		this.pedidoSelec = new Pedido();
		this.editar = Boolean.FALSE;
		this.pedidoServices = new PedidoServices();
		this.productoServices = new ProductoServices();
		this.tipoConfeccionServices = new TipoConfeccionServices();
		this.fecha_pedido = new Date();
		this.fecha_entrega = new Date();

		try {
			this.listaPedidos = this.pedidoServices.findAll();
			this.listaProducto = this.productoServices.findAll();
			this.listaTipoConfeccion = this.tipoConfeccionServices.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void guardarPedido() {
		Boolean valido = Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("esValido", valido);

		try {

			this.pedidoSelec.setFechapedido(new java.sql.Date(fecha_pedido.getTime()));
			this.pedidoSelec.setFecha_entrega(new java.sql.Date(fecha_entrega.getTime()));
			this.pedidoSelec.setId_estado(Constante.REGISTRADO);

			if (this.editar) {
				this.pedidoServices.actualizarPedido(this.pedidoSelec);
				FacesUtils.showFacesMessage("Pedido ha sido actualizado", 3);
			} else {
				this.pedidoServices.crearPedido(this.pedidoSelec);
				FacesUtils.showFacesMessage("Pedido ha sido creado", 3);
			}

			this.pedidoSelec = new Pedido();
			this.editar = Boolean.FALSE;

			this.listaPedidos = this.pedidoServices.findAll();

			context.update("msgGeneral");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void nuevoPedido() {
		this.pedidoSelec = new Pedido();
		// this.pedidoSelec.setEstado(Boolean.TRUE);
		this.editar = Boolean.FALSE;
	}

	public void editarPedido(Pedido car) {
		this.pedidoSelec = car;
		this.editar = Boolean.TRUE;
	}

	public void eliminarPedido(Pedido car) {
		this.pedidoSelec = car;
	}

	public void confirmaEliminar() {

	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public Pedido getPedidoSelec() {
		return pedidoSelec;
	}

	public void setPedidoSelec(Pedido pedidoSelec) {
		this.pedidoSelec = pedidoSelec;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public List<TipoConfeccion> getListaTipoConfeccion() {
		return listaTipoConfeccion;
	}

	public void setListaTipoConfeccion(List<TipoConfeccion> listaTipoConfeccion) {
		this.listaTipoConfeccion = listaTipoConfeccion;
	}

	public Date getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

}
