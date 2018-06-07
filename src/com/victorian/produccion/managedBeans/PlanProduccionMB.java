package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.SelectableDataModel;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.FacesUtils;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.pe.victorian.produccion.listas.ListaPedidos;
import com.victorian.produccion.domain.AsignacionRecurso;
import com.victorian.produccion.domain.FichaTecnica;
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Maquinaria;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.domain.Pedido;
import com.victorian.produccion.domain.PlanPedido;
import com.victorian.produccion.domain.PlanProduccion;
import com.victorian.produccion.domain.Producto;
import com.victorian.produccion.domain.Recurso;
import com.victorian.produccion.domain.TipoConfeccion;
import com.victorian.produccion.services.AsignacionRecursoServices;
import com.victorian.produccion.services.FichaTecnicaServices;
import com.victorian.produccion.services.MaquinariaServices;
import com.victorian.produccion.services.OperarioServices;
import com.victorian.produccion.services.PedidoServices;
import com.victorian.produccion.services.PlanPedidoServices;
import com.victorian.produccion.services.PlanProduccionServices;
import com.victorian.produccion.services.ProductoServices;
import com.victorian.produccion.services.TipoConfeccionServices;

@ManagedBean(name = "planProduccionMB")
@ViewScoped
public class PlanProduccionMB extends GenericBeans implements Serializable {
	private Pedido pedido;
	private ListaPedidos<Pedido> listaPedidos;
	private List<Pedido> listaPedidosSelected;
	private List<Producto> listaProducto;
	private List<TipoConfeccion> listaTipoConfeccion;

	private List<Operario> listaDiseniador;
	private List<Operario> listaCortador;
	private List<Operario> listaConfeccionista;
	private List<Operario> listaEmpaquetador;

	private List<Maquinaria> listaMaquinaCorte;
	private List<Maquinaria> listaMaquinaConfeccion;
	
	private List<FichaTecnica> listFichasTecnicas;

	private Integer id_cortador_seleccionado;
	private Integer id_confeccionista_seleccionado;
	private Integer id_empaquetador_seleccionado;

	private Integer id_maquina_corte_seleccionado;
	private Integer id_maquina_confeccion_seleccionado;

	private Pedido pedidoSelec;
	private Boolean editar;
	private Date fecha_pedido;
	private Date fecha_entrega;

	private AsignacionRecurso asignacionRecursoSelected;

	private PedidoServices pedidoServices;
	private ProductoServices productoServices;
	private TipoConfeccionServices tipoConfeccionServices;
	private OperarioServices operarioServices;
	private MaquinariaServices maquinariaServices;
	private AsignacionRecursoServices asignacionRecursoServices;
	private PlanProduccionServices planProduccionServices;
	private PlanPedidoServices planPedidoServices;
	private FichaTecnicaServices fichaTecnicaServices;
	

	// Contadores
	private Integer cantidad_personal_diseniadores;
	private Integer cantidad_personal_cortadores;
	private Integer cantidad_personal_confeccionistas;
	private Integer cantidad_empaquetadores;

	private Integer cantidad_maquina_cortadora;
	private Integer cantidad_maquina_confeccionista;

	private Log log;
	private LogMB logmb;

	@PostConstruct
	public void inicia() {
		this.pedidoSelec = new Pedido();
		this.editar = Boolean.FALSE;
		this.pedidoServices = new PedidoServices();
		this.productoServices = new ProductoServices();
		this.tipoConfeccionServices = new TipoConfeccionServices();
		this.operarioServices = new OperarioServices();
		this.maquinariaServices = new MaquinariaServices();
		this.asignacionRecursoServices = new AsignacionRecursoServices();
		this.planProduccionServices = new PlanProduccionServices();
		this.planPedidoServices = new PlanPedidoServices();
		this.fichaTecnicaServices = new FichaTecnicaServices();

		this.fecha_pedido = new Date();
		this.fecha_entrega = new Date();

		try {
			this.listaPedidos = new ListaPedidos<Pedido>(getPedidos());
			this.listaProducto = this.productoServices.findAll();
			this.listaTipoConfeccion = this.tipoConfeccionServices.findAll();

			this.listaDiseniador = this.operarioServices.findByEstado("DISEÑADOR");
			this.listaCortador = this.operarioServices.findByEstado("CORTADOR");
			this.listaConfeccionista = this.operarioServices.findByEstado("CONFECCIONISTA");
			this.listaEmpaquetador = this.operarioServices.findByEstado("EMPAQUETADOR");

			this.listaMaquinaCorte = this.maquinariaServices.findByEstado("CORTE");
			this.listaMaquinaConfeccion = this.maquinariaServices.findByEstado("CONFECCION");

			List<Recurso> listRecursos = this.asignacionRecursoServices.listarRecursosDisponibles();
			this.cantidad_maquina_confeccionista = listRecursos.get(0).getCantidad();
			this.cantidad_maquina_cortadora = listRecursos.get(1).getCantidad();
			this.cantidad_personal_confeccionistas = listRecursos.get(2).getCantidad();
			this.cantidad_personal_cortadores = listRecursos.get(3).getCantidad();
			this.cantidad_personal_diseniadores = listRecursos.get(4).getCantidad();
			this.cantidad_empaquetadores = listRecursos.get(5).getCantidad();

			this.id_cortador_seleccionado = -1;
			this.id_confeccionista_seleccionado = -1;
			this.id_empaquetador_seleccionado = -1;

			this.id_maquina_corte_seleccionado = -1;
			this.id_maquina_confeccion_seleccionado = -1;

			this.asignacionRecursoSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		log = (Log) getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();
	}

	private List<Pedido> getPedidos() throws Exception {
		return this.pedidoServices.findByEstado(Constante.ACEPTADO);
	}

	public void cargarRecursos(Pedido p) {
		System.out.println("pedido: " + p.getIdpedido());
		this.pedidoSelec = p;

		try {
			asignacionRecursoSelected = asignacionRecursoServices.findByIdPedido(p.getIdpedido());

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

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
				ar.setId_pedido(pedidoSelec.getIdpedido());
				asignacionRecursoServices.insert(ar);
			}

			this.listaPedidos = new ListaPedidos<Pedido>(getPedidos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardarPedido() {
		Boolean valido = Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("esValido", valido);

		try {
			if(listaPedidosSelected.size()>0){
				if(this.cantidad_maquina_confeccionista > 0 && this.cantidad_maquina_cortadora > 0 && 
						this.cantidad_personal_confeccionistas > 0 && this.cantidad_personal_cortadores > 0 && 
						this.cantidad_personal_diseniadores > 0 && this.cantidad_empaquetadores > 0){
					Date fechaActual = new Date();
					Calendar calPP = Calendar.getInstance();
					calPP.setTime(fechaActual);
					calPP.add(Calendar.MONTH, 1);
		
					PlanProduccion pp = new PlanProduccion();
					pp.setFechainicioplan(new java.sql.Date(fechaActual.getTime()));
					pp.setFechafinplan(new java.sql.Date(calPP.getTime().getTime()));
					pp.setEstado(Constante.PP_PENDIENTE_APROBACION);
					this.planProduccionServices.insert(pp);
		
					for (Pedido p : listaPedidosSelected) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(p.getFechapedido());
						cal.add(Calendar.MONTH, 1);
		
						p.setFechaentrega(new java.sql.Date(cal.getTime().getTime()));
						p.setEstadopedido(Constante.PENDIENTE_APROBACION);
		
						this.pedidoServices.actualizarPedido(p);
		
						List<FichaTecnica> listFichaTecnica = fichaTecnicaServices.findByProducto(p.getTipo_prenda());
						
						for(FichaTecnica ft: listFichaTecnica){
							PlanPedido planPedido = new PlanPedido();
							planPedido.setFechainicio(p.getFechapedido());
							planPedido.setFechafin(p.getFechaentrega());
							planPedido.setIdpedido(p.getIdpedido());
							planPedido.setEstado(1);
							planPedido.setIdplan(pp.getIdplan());
							planPedido.setIdfichatecnica(ft.getIdfichatecnica());
		
							this.planPedidoServices.insert(planPedido);					
						}
					}
					
					FacesUtils.showFacesMessage("Pendiente de aprobación por parte del Jefe de Producción", 3);
				}
				else{
					FacesUtils.showFacesMessage("No hay recursos disponibles para generar el plan", 1);	
				}
			}
			else{
				FacesUtils.showFacesMessage("Se debe seleccionar por lo menos un pedido para generar el plan", 1);
			}
			this.listaPedidos = new ListaPedidos<Pedido>(getPedidos());

			context.update("msgGeneral");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void calcularFichaTecnica(Pedido p){
		try {
			RequestContext context = RequestContext.getCurrentInstance();  
			double subtotalproducto=0;
			double subtotalpedido=0;
			this.pedidoSelec = p;
			this.listFichasTecnicas = fichaTecnicaServices.findByProducto(p.getTipo_prenda());
			
			for(FichaTecnica ft: listFichasTecnicas){
				subtotalproducto+=ft.getPreciototal();
			}
			
			subtotalpedido = subtotalproducto * this.pedidoSelec.getCantidad_prenda().intValue();
			
			this.pedidoSelec.setSubTotalProducto(new Double(subtotalproducto));
			this.pedidoSelec.setSubTotalPedido(new Double(subtotalpedido));
			
			context.update("dlgDetFichaTecnica");
			context.execute("PF('dlgFichaTecnica').show();");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	public ListaPedidos<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(ListaPedidos<Pedido> listaPedidos) {
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

	public Integer getCantidad_personal_cortadores() {
		return cantidad_personal_cortadores;
	}

	public void setCantidad_personal_cortadores(Integer cantidad_personal_cortadores) {
		this.cantidad_personal_cortadores = cantidad_personal_cortadores;
	}

	public Integer getCantidad_personal_confeccionistas() {
		return cantidad_personal_confeccionistas;
	}

	public void setCantidad_personal_confeccionistas(Integer cantidad_personal_confeccionistas) {
		this.cantidad_personal_confeccionistas = cantidad_personal_confeccionistas;
	}

	public Integer getCantidad_empaquetadores() {
		return cantidad_empaquetadores;
	}

	public void setCantidad_empaquetadores(Integer cantidad_empaquetadores) {
		this.cantidad_empaquetadores = cantidad_empaquetadores;
	}

	public Integer getCantidad_maquina_cortadora() {
		return cantidad_maquina_cortadora;
	}

	public void setCantidad_maquina_cortadora(Integer cantidad_maquina_cortadora) {
		this.cantidad_maquina_cortadora = cantidad_maquina_cortadora;
	}

	public Integer getCantidad_maquina_confeccionista() {
		return cantidad_maquina_confeccionista;
	}

	public void setCantidad_maquina_confeccionista(Integer cantidad_maquina_confeccionista) {
		this.cantidad_maquina_confeccionista = cantidad_maquina_confeccionista;
	}

	public List<Pedido> getListaPedidosSelected() {
		return listaPedidosSelected;
	}

	public void setListaPedidosSelected(List<Pedido> listaPedidosSelected) {
		this.listaPedidosSelected = listaPedidosSelected;
	}

	public List<FichaTecnica> getListFichasTecnicas() {
		return listFichasTecnicas;
	}

	public void setListFichasTecnicas(List<FichaTecnica> listFichasTecnicas) {
		this.listFichasTecnicas = listFichasTecnicas;
	}

	public List<Operario> getListaDiseniador() {
		return listaDiseniador;
	}

	public void setListaDiseniador(List<Operario> listaDiseniador) {
		this.listaDiseniador = listaDiseniador;
	}

	public Integer getCantidad_personal_diseniadores() {
		return cantidad_personal_diseniadores;
	}

	public void setCantidad_personal_diseniadores(Integer cantidad_personal_diseniadores) {
		this.cantidad_personal_diseniadores = cantidad_personal_diseniadores;
	}
}
