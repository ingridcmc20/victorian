package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ToggleEvent;

import com.pe.victorian.produccion.commons.Constante;
import com.pe.victorian.produccion.commons.ExportarArchivo;
import com.pe.victorian.produccion.commons.FacesUtils;
import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.FichaTecnica;
import com.victorian.produccion.domain.Formato;
import com.victorian.produccion.domain.Insumo;
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.domain.Producto;
import com.victorian.produccion.domain.ProductoInsumo;
import com.victorian.produccion.services.FichaTecnicaServices;
import com.victorian.produccion.services.InsumoServices;
import com.victorian.produccion.services.MenuServices;
import com.victorian.produccion.services.ProductoInsumoService;
import com.victorian.produccion.services.ProductoServices;

import net.sf.jasperreports.engine.JRParameter;

@ManagedBean(name = "productoMB")
@ViewScoped
public class ProductoMB extends GenericBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Producto producto;
	private Formato formato;
	private FichaTecnica fichaTecnica;
	private List<Producto> listaProductos;
	private List<Producto> listaProductosTotal;
	private List<Producto> listaProductosFilter;
	private List<Producto> listaSubProductos;
	private List<Formato> listFormatos;
	private List<Insumo> listInsumos;
	private List<FichaTecnica> listFichasTecnicas;
	private Producto productoSelec;
	private Integer id_producto;
	private Boolean editar;
	private boolean eliminar;

	private ProductoServices productoServices;
	private MenuServices menuServices;
	private InsumoServices insumoServices;
	private FichaTecnicaServices fichaTecnicaServices;
	private ProductoInsumoService productoInsumoService;

	private Log log;
	private LogMB logmb;
	@ManagedProperty(value = "#{loginMB}")
	private LoginMB login;
	RequestContext context;

	public ProductoMB() {
	}

	@PostConstruct
	public void inicia() {
		this.productoServices = new ProductoServices();
		this.menuServices = new MenuServices();
		this.insumoServices = new InsumoServices();
		this.fichaTecnicaServices = new FichaTecnicaServices();
		this.productoInsumoService = new ProductoInsumoService();

		this.productoSelec = new Producto();
		this.editar = Boolean.FALSE;
		this.listFormatos = new ArrayList<Formato>();
		this.listaProductosTotal = new ArrayList<Producto>();
		this.fichaTecnica = new FichaTecnica();

		try {
			listaProductos = this.productoServices.findAll();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		log = (Log) getSpringBean(Constante.SESSION_LOG);
		logmb = new LogMB();
		try {
			Menu codMenu = menuServices.opcionMenuByPretty("pretty:producto");
			log.setCod_menu(codMenu.getCod_menu().intValue());
			log.setIdusuario(this.login.getIdUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void retirarMaterial(FichaTecnica ft) {
		try {
			ProductoInsumo productoInsumo = new ProductoInsumo();
			productoInsumo.setId_producto(ft.getId_producto());
			productoInsumo.setId_insumo(ft.getId_insumo());

			fichaTecnicaServices.delete(ft.getId_fichatecnica());
			productoInsumoService.delete(productoInsumo);

			listFichasTecnicas = fichaTecnicaServices.findByProducto(this.fichaTecnica.getId_producto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void agregarMaterial() {
		try {
			ProductoInsumo productoInsumo = new ProductoInsumo();
			productoInsumo.setId_producto(this.fichaTecnica.getId_producto());
			productoInsumo.setId_insumo(this.fichaTecnica.getId_insumo());

			this.fichaTecnica.setPrecio_total(
					(this.fichaTecnica.getPrecio_unidad() != null ? this.fichaTecnica.getPrecio_unidad() : 0)
							* (this.fichaTecnica.getCantidad() != null ? this.fichaTecnica.getCantidad() : 0));

			productoInsumoService.insert(productoInsumo);
			fichaTecnicaServices.insert(this.fichaTecnica);

			listFichasTecnicas = fichaTecnicaServices.findByProducto(this.fichaTecnica.getId_producto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void abrirFichaTecnica(Producto p) {
		try {
			this.fichaTecnica = new FichaTecnica();
			this.productoSelec = p;
			this.fichaTecnica.setId_producto(p.getId_producto());
			this.listInsumos = insumoServices.findAll();
			listFichasTecnicas = fichaTecnicaServices.findByProducto(p.getId_producto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerPrecio(AjaxBehaviorEvent event) {
		System.out.println("obtenerPrecio");
		Insumo insumoTempo = insumoServices.findById(fichaTecnica.getId_insumo());
		fichaTecnica.setPrecio_unidad(insumoTempo.getPrecio());
	}

	public void guardarProducto() {

		Boolean valido = Boolean.TRUE;
		RequestContext context = RequestContext.getCurrentInstance();

		context.addCallbackParam("esValido", valido);

		try {
			this.productoSelec.setId_negocio(this.productoSelec.getId_negocio());
			this.productoSelec.setDescripcion(this.productoSelec.getDescripcion().trim().toUpperCase());

			if (this.editar) {
				this.productoServices.actualizarProducto(this.productoSelec);
				FacesUtils.showFacesMessage("Producto ha sido actualizado", 3);
				log.setAccion("UPDATE");
				log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " actualizó el producto: "
						+ this.productoSelec.getDescripcion() + " del negocio " + this.productoSelec.getDes_negocio());
				logmb.insertarLog(log);

			} else {

				this.productoServices.crearProducto(this.productoSelec);
				FacesUtils.showFacesMessage("Producto ha sido creado", 3);
				log.setAccion("INSERT");
				log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " registró el producto: "
						+ this.productoSelec.getDescripcion() + " para el negocio "
						+ this.productoSelec.getDes_negocio());
				logmb.insertarLog(log);
			}

			this.productoSelec = new Producto();
			this.editar = Boolean.FALSE;
			this.listaProductos = this.productoServices.findAll();

			context.update("msgGeneral");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cambiarEstado(Producto producto) {
		String estado = "";
		if (producto.isEstado()) {
			producto.setEstado(Boolean.FALSE);
			estado = "INACTIVO";
		} else {
			producto.setEstado(Boolean.TRUE);
			estado = "ACTIVO";
		}

		try {
			this.productoServices.actualizarProducto(producto);
			FacesUtils.showFacesMessage("Producto  modificado correctamente", Constante.INFORMACION);
			// this.listaProductos = this.productoServices.findAll();
			log.setAccion("UPDATE");
			log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " actualizó el estado a : " + estado
					+ " al producto " + producto.getDescripcion() + " con el negocio " + producto.getDes_negocio());
			logmb.insertarLog(log);
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void nuevoProducto() {
		this.productoSelec = new Producto();
		this.productoSelec.setEstado(Boolean.TRUE);
		this.editar = Boolean.FALSE;
	}

	public void editarProducto(Producto pro) {
		// this.productoSelec = pro;
		// System.out.println("aaa==>"+pro.getFormato().getIdformato());
		setProductoSelec(pro);
		if (productoSelec.getFormato() != null)
			productoSelec.setIdformato(productoSelec.getFormato().getIdformato());

		// System.out.println("==>"+pro.getIdformato());
		this.editar = Boolean.TRUE;
	}

	public void eliminarProducto(Producto pro) {
		this.productoSelec = pro;
		// System.out.println("*******entro a eliminar ");
		// System.out.println(" codigo
		// producto"+this.productoSelec.getId_producto());
		try {
			this.productoSelec = this.productoServices.findById(this.productoSelec.getId_producto());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void confirmaEliminar() {

		try {

			this.productoServices.eliminarProducto(this.productoSelec.getId_producto());

			FacesUtils.showFacesMessage("Producto ha sido eliminado", 3);

			// this.listaProductos = this.productoServices.findAll();
			log.setAccion("DELETE");
			log.setDescripcion("El usuario " + this.login.getLoginUsuario() + " ha eliminado el producto : "
					+ this.productoSelec.getDescripcion() + " del negocio " + this.productoSelec.getDes_negocio());
			logmb.insertarLog(log);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// lleva a la pagina subProducto
	public String agregarSubProducto(Producto pro) {

		String outcome = null;
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("producto", pro);
		outcome = "pretty:addSubProducto";

		return outcome;

	}

	public void onRowToggle(ToggleEvent event) {

	}

	public void imprimirXLS() {
		String par_negocio = "";

		try {
			/*ServletContext servletContext = (ServletContext) (FacesContext.getCurrentInstance().getExternalContext()
					.getContext());*/

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String fechaActual = formato.format(new Date());


			this.listaProductosTotal = this.productoServices.findAll();
			Integer total = this.listaProductosTotal.size();
			System.out.println("el tamaño de la lista es " + this.listaProductosTotal.size());

			Map<String, Object> input = new HashMap<String, Object>();
			input.put("P_TOTAL", total.toString());
			input.put("P_NEGOCIO", par_negocio);
			input.put("P_FSISTEMA", fechaActual);
			input.put(JRParameter.REPORT_LOCALE, new Locale("es"));
			System.out.println(" JRParameter.REPORT_LOCALE es   " + par_negocio);
			// input.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE); // no
			// parte la pagina todo lo mete en un A4

			String path = ExportarArchivo.getPath("/resources/reports/jxrml/productoXLS.jasper");
			/*HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();*/

			log.setAccion("PRINT");
			log.setDescripcion(
					"El usuario " + this.login.getLoginUsuario() + " ha empreso el archivo ConsultaProducto.xls ");
			logmb.insertarLog(log);

			byte[] bytes;
			bytes = ExportarArchivo.exportXls(path, input, listaProductosTotal, false);
			ExportarArchivo.executeExccel(bytes, "ConsultaProducto.xls");
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * #########################################################################
	 * #########################
	 */
	/*
	 * ####################################------setters y
	 * getters----###################################
	 */
	/*
	 * #########################################################################
	 * #########################
	 */

	public Producto getProducto() {
		return producto;
	}

	public FichaTecnica getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(FichaTecnica fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto getProductoSelec() {
		return productoSelec;
	}

	public void setProductoSelec(Producto productoSelec) {
		this.productoSelec = productoSelec;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public List<Producto> getListaProductosFilter() {
		return listaProductosFilter;
	}

	public void setListaProductosFilter(List<Producto> listaProductosFilter) {
		this.listaProductosFilter = listaProductosFilter;
	}

	public List<Producto> getListaSubProductos() {
		return listaSubProductos;
	}

	public void setListaSubProductos(List<Producto> listaSubProductos) {
		this.listaSubProductos = listaSubProductos;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public List<Formato> getListFormatos() {
		return listFormatos;
	}

	public void setListFormatos(List<Formato> listFormatos) {
		this.listFormatos = listFormatos;
	}

	public List<Producto> getListaProductosTotal() {
		return listaProductosTotal;
	}

	public void setListaProductosTotal(List<Producto> listaProductosTotal) {
		this.listaProductosTotal = listaProductosTotal;
	}

	public LogMB getLogmb() {
		return logmb;
	}

	public void setLogmb(LogMB logmb) {
		this.logmb = logmb;
	}

	public LoginMB getLogin() {
		return login;
	}

	public void setLogin(LoginMB login) {
		this.login = login;
	}

	public List<Insumo> getListInsumos() {
		return listInsumos;
	}

	public void setListInsumos(List<Insumo> listInsumos) {
		this.listInsumos = listInsumos;
	}

	public List<FichaTecnica> getListFichasTecnicas() {
		return listFichasTecnicas;
	}

	public void setListFichasTecnicas(List<FichaTecnica> listFichasTecnicas) {
		this.listFichasTecnicas = listFichasTecnicas;
	}

}