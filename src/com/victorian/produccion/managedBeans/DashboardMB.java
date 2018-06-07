package com.victorian.produccion.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.chart.MeterGaugeChartModel;

import com.pe.victorian.produccion.commons.GenericBeans;
import com.victorian.produccion.domain.Merma;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.domain.OrdenTrabajo;
import com.victorian.produccion.domain.Pedido;
import com.victorian.produccion.services.MermaServices;
import com.victorian.produccion.services.OperarioServices;
import com.victorian.produccion.services.OrdenTrabajoServices;
import com.victorian.produccion.services.PedidoServices;

@ManagedBean(name = "dashboardMB")
@ViewScoped
public class DashboardMB extends GenericBeans implements Serializable {
	private List<OrdenTrabajo> listaOrdenTrabajo;
	private List<Operario> listaOperarios;
	private Date fecha_pedido;
	private Date fecha_entrega;
	private MeterGaugeChartModel mgmMermas;
	
	private OrdenTrabajoServices ordenTrabajoServices;
	private MermaServices mermaServices;
	private OperarioServices operarioServices;
	
	RequestContext context;

	@PostConstruct
	public void inicia() {
		this.ordenTrabajoServices = new OrdenTrabajoServices();
		this.mermaServices = new MermaServices();
		this.operarioServices = new OperarioServices();
		
		this.fecha_pedido=new Date();
		this.fecha_entrega=new Date();

		try {
			this.listaOrdenTrabajo = this.ordenTrabajoServices.findAllByFechaEstadoYEntrega();
			this.listaOperarios = operarioServices.findCortadorYConfeccion();
			createMeterGaugeModels();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createMeterGaugeModels() {
		List<Number> intervals = new ArrayList<Number>(){{            
            add(10);
            add(15);
            add(20);
            add(25);
            add(30);
        }};
        List<Merma> lstMermas = mermaServices.findAll();
		mgmMermas = new MeterGaugeChartModel(lstMermas.size(), intervals);;
		mgmMermas.setTitle("Nivel de mermas");
		mgmMermas.setGaugeLabel("unidad");
		mgmMermas.setSeriesColors("04B404,2EFE2E,FFFF00,FF0000,B40404");
		
	}

	public void refrescar(){
		try {
			System.out.println("Entro refrescar :)");
			this.listaOrdenTrabajo = this.ordenTrabajoServices.findAllByFechaEstadoYEntrega();
			this.listaOperarios = operarioServices.findCortadorYConfeccion();
			createMeterGaugeModels();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public MeterGaugeChartModel getMgmMermas() {
		return mgmMermas;
	}

	public void setMgmMermas(MeterGaugeChartModel mgmMermas) {
		this.mgmMermas = mgmMermas;
	}

	public List<OrdenTrabajo> getListaOrdenTrabajo() {
		return listaOrdenTrabajo;
	}

	public void setListaOrdenTrabajo(List<OrdenTrabajo> listaOrdenTrabajo) {
		this.listaOrdenTrabajo = listaOrdenTrabajo;
	}

	public List<Operario> getListaOperarios() {
		return listaOperarios;
	}

	public void setListaOperarios(List<Operario> listaOperarios) {
		this.listaOperarios = listaOperarios;
	}

}
