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
import com.victorian.produccion.domain.AsignacionRecurso;
import com.victorian.produccion.domain.Maquinaria;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.domain.Pedido;
import com.victorian.produccion.domain.PlanProduccion;
import com.victorian.produccion.domain.Producto;
import com.victorian.produccion.domain.TipoConfeccion;
import com.victorian.produccion.services.AsignacionRecursoServices;
import com.victorian.produccion.services.MaquinariaServices;
import com.victorian.produccion.services.OperarioServices;
import com.victorian.produccion.services.PedidoServices;
import com.victorian.produccion.services.PlanProduccionServices;
import com.victorian.produccion.services.ProductoServices;
import com.victorian.produccion.services.TipoConfeccionServices;

@ManagedBean(name = "aprobarPlanProduccionMB")
@ViewScoped
public class AprobarPlanProduccionMB extends GenericBeans implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlanProduccion pedido;
	private List<PlanProduccion> listaPedidos;
	private List<Producto> listaProducto;
	private List<TipoConfeccion> listaTipoConfeccion;

	private List<Operario> listaCortador;
	private List<Operario> listaConfeccionista;
	private List<Operario> listaEmpaquetador;

	private List<Maquinaria> listaMaquinaCorte;
	private List<Maquinaria> listaMaquinaConfeccion;

	private Integer id_cortador_seleccionado;
	private Integer id_confeccionista_seleccionado;
	private Integer id_empaquetador_seleccionado;

	private Integer id_maquina_corte_seleccionado;
	private Integer id_maquina_confeccion_seleccionado;

	private PlanProduccion pedidoSelec;
	private Boolean editar;
	private Date fecha_pedido;
	private Date fecha_entrega;

	private AsignacionRecurso asignacionRecursoSelected;

	private PedidoServices pedidoServices;
	private ProductoServices productoServices;
	private TipoConfeccionServices tipoConfeccionServices;
	private OperarioServices operarioServices;
	private MaquinariaServices maquinariaServices;
	private PlanProduccionServices planProduccionServices;
	private AsignacionRecursoServices asignacionRecursoServices;

	RequestContext context;

	@PostConstruct
	public void inicia() {
		this.pedidoSelec = new PlanProduccion();
		this.editar = Boolean.FALSE;
		this.pedidoServices = new PedidoServices();
		this.productoServices = new ProductoServices();
		this.tipoConfeccionServices = new TipoConfeccionServices();
		this.operarioServices = new OperarioServices();
		this.maquinariaServices = new MaquinariaServices();
		this.planProduccionServices = new PlanProduccionServices();
		this.asignacionRecursoServices = new AsignacionRecursoServices();

		this.fecha_pedido = new Date();
		this.fecha_entrega = new Date();

		try {
			this.listaPedidos = this.planProduccionServices.findByEstado(Constante.PP_PENDIENTE);
			this.listaProducto = this.productoServices.findAll();
			this.listaTipoConfeccion = this.tipoConfeccionServices.findAll();

			this.listaCortador = this.operarioServices.findByEstado(Constante.OP_CORTADOR);
			this.listaConfeccionista = this.operarioServices.findByEstado(Constante.OP_CONFECCIONISTA);
			this.listaEmpaquetador = this.operarioServices.findByEstado(Constante.OP_EMPAQUETADOR);

			this.listaMaquinaCorte = this.maquinariaServices.findByEstado("CORTE");
			this.listaMaquinaConfeccion = this.maquinariaServices.findByEstado("CONFECCION");

			this.id_cortador_seleccionado = -1;
			this.id_confeccionista_seleccionado = -1;
			this.id_empaquetador_seleccionado = -1;

			this.id_maquina_corte_seleccionado = -1;
			this.id_maquina_confeccion_seleccionado = -1;

			this.asignacionRecursoSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargarRecursos(PlanProduccion p) {

		System.out.println("pedido: " + p.getId_pedido());
		this.pedidoSelec = p;

		try {
			asignacionRecursoSelected = asignacionRecursoServices.findByIdPedido(p.getId_pedido());

			if (asignacionRecursoSelected != null) {
				this.id_cortador_seleccionado = asignacionRecursoSelected.getId_cortador();
				this.id_confeccionista_seleccionado = asignacionRecursoSelected.getId_confeccionista();
				this.id_empaquetador_seleccionado = asignacionRecursoSelected.getId_empaquetador();
				this.id_maquina_corte_seleccionado = asignacionRecursoSelected.getId_maquina_corte();
				this.id_maquina_confeccion_seleccionado = asignacionRecursoSelected.getId_maquina_confeccion();
			} else {
				this.id_cortador_seleccionado = -1;
				this.id_confeccionista_seleccionado = -1;
				this.id_empaquetador_seleccionado = -1;
				this.id_maquina_corte_seleccionado = -1;
				this.id_maquina_confeccion_seleccionado = -1;
			}

			System.out.println("id_cortador_seleccionado: " + this.id_cortador_seleccionado);
			System.out.println("id_confeccionista_seleccionado: " + this.id_confeccionista_seleccionado);
			System.out.println("id_empaquetador_seleccionado: " + this.id_empaquetador_seleccionado);
			System.out.println("id_maquina_corte_seleccionado: " + this.id_maquina_corte_seleccionado);
			System.out.println("id_maquina_confeccion_seleccionado: " + this.id_maquina_confeccion_seleccionado);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void asignarRecursos() {
		try {
			Boolean valido = Boolean.TRUE;
			RequestContext context = RequestContext.getCurrentInstance();
			context.addCallbackParam("esValido", valido);

			System.out.println("id_cortador_seleccionado: " + this.id_cortador_seleccionado);
			System.out.println("id_confeccionista_seleccionado: " + this.id_confeccionista_seleccionado);
			System.out.println("id_empaquetador_seleccionado: " + this.id_empaquetador_seleccionado);

			System.out.println("id_maquina_corte_seleccionado: " + this.id_maquina_corte_seleccionado);
			System.out.println("id_maquina_confeccion_seleccionado: " + this.id_maquina_confeccion_seleccionado);

			if (asignacionRecursoSelected != null) {
				asignacionRecursoSelected.setId_cortador(this.id_cortador_seleccionado);
				asignacionRecursoSelected.setId_confeccionista(this.id_confeccionista_seleccionado);
				asignacionRecursoSelected.setId_empaquetador(this.id_empaquetador_seleccionado);
				asignacionRecursoSelected.setId_maquina_corte(this.id_maquina_corte_seleccionado);
				asignacionRecursoSelected.setId_maquina_confeccion(this.id_maquina_confeccion_seleccionado);

				asignacionRecursoServices.update(asignacionRecursoSelected);
			} else {
				AsignacionRecurso ar = new AsignacionRecurso();
				ar.setId_cortador(this.id_cortador_seleccionado);
				ar.setId_confeccionista(this.id_confeccionista_seleccionado);
				ar.setId_empaquetador(this.id_empaquetador_seleccionado);
				ar.setId_maquina_corte(this.id_maquina_corte_seleccionado);
				ar.setId_maquina_confeccion(this.id_maquina_confeccion_seleccionado);
				ar.setId_pedido(pedidoSelec.getId_pedido());
				asignacionRecursoServices.insert(ar);
			}

			this.listaPedidos = this.planProduccionServices.findByEstado(Constante.PP_APROBADO);
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void guardarPedido(PlanProduccion p) {
		List<Pedido> lstPedidos;
		Boolean valido = Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("esValido", valido);

		try {
			lstPedidos = this.pedidoServices.findByPlanProduccion(p.getId_planproduccion());

			for (Pedido pedido : lstPedidos) {
				pedido.setId_estado(Constante.ACEPTADO);
				this.pedidoServices.actualizarPedido(pedido);
			}

			p.setId_estado(Constante.PP_APROBADO);
			this.planProduccionServices.update(p);

			FacesUtils.showFacesMessage("Se aprobo correctamente el plan de producción.", 3);

			this.listaPedidos = this.planProduccionServices.findByEstado(Constante.PP_PENDIENTE);

			context.update("msgGeneral");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void nuevoPedido() {
		this.pedidoSelec = new PlanProduccion();
		// this.pedidoSelec.setEstado(Boolean.TRUE);
		this.editar = Boolean.FALSE;
	}

	public void editarPedido(PlanProduccion car) {
		this.pedidoSelec = car;
		this.editar = Boolean.TRUE;
	}

	public void eliminarPedido(PlanProduccion car) {
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

	public PlanProduccion getPedido() {
		return pedido;
	}

	public void setPedido(PlanProduccion pedido) {
		this.pedido = pedido;
	}

	public List<PlanProduccion> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<PlanProduccion> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public PlanProduccion getPedidoSelec() {
		return pedidoSelec;
	}

	public void setPedidoSelec(PlanProduccion pedidoSelec) {
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

	public List<Operario> getListaCortador() {
		return listaCortador;
	}

	public void setListaCortador(List<Operario> listaCortador) {
		this.listaCortador = listaCortador;
	}

	public List<Operario> getListaConfeccionista() {
		return listaConfeccionista;
	}

	public void setListaConfeccionista(List<Operario> listaConfeccionista) {
		this.listaConfeccionista = listaConfeccionista;
	}

	public List<Operario> getListaEmpaquetador() {
		return listaEmpaquetador;
	}

	public void setListaEmpaquetador(List<Operario> listaEmpaquetador) {
		this.listaEmpaquetador = listaEmpaquetador;
	}

	public Integer getId_cortador_seleccionado() {
		return id_cortador_seleccionado;
	}

	public void setId_cortador_seleccionado(Integer id_cortador_seleccionado) {
		this.id_cortador_seleccionado = id_cortador_seleccionado;
	}

	public Integer getId_confeccionista_seleccionado() {
		return id_confeccionista_seleccionado;
	}

	public void setId_confeccionista_seleccionado(Integer id_confeccionista_seleccionado) {
		this.id_confeccionista_seleccionado = id_confeccionista_seleccionado;
	}

	public Integer getId_empaquetador_seleccionado() {
		return id_empaquetador_seleccionado;
	}

	public void setId_empaquetador_seleccionado(Integer id_empaquetador_seleccionado) {
		this.id_empaquetador_seleccionado = id_empaquetador_seleccionado;
	}

	public List<Maquinaria> getListaMaquinaCorte() {
		return listaMaquinaCorte;
	}

	public void setListaMaquinaCorte(List<Maquinaria> listaMaquinaCorte) {
		this.listaMaquinaCorte = listaMaquinaCorte;
	}

	public List<Maquinaria> getListaMaquinaConfeccion() {
		return listaMaquinaConfeccion;
	}

	public void setListaMaquinaConfeccion(List<Maquinaria> listaMaquinaConfeccion) {
		this.listaMaquinaConfeccion = listaMaquinaConfeccion;
	}

	public Integer getId_maquina_corte_seleccionado() {
		return id_maquina_corte_seleccionado;
	}

	public void setId_maquina_corte_seleccionado(Integer id_maquina_corte_seleccionado) {
		this.id_maquina_corte_seleccionado = id_maquina_corte_seleccionado;
	}

	public Integer getId_maquina_confeccion_seleccionado() {
		return id_maquina_confeccion_seleccionado;
	}

	public void setId_maquina_confeccion_seleccionado(Integer id_maquina_confeccion_seleccionado) {
		this.id_maquina_confeccion_seleccionado = id_maquina_confeccion_seleccionado;
	}

	public AsignacionRecurso getAsignacionRecursoSelected() {
		return asignacionRecursoSelected;
	}

	public void setAsignacionRecursoSelected(AsignacionRecurso asignacionRecursoSelected) {
		this.asignacionRecursoSelected = asignacionRecursoSelected;
	}
}
