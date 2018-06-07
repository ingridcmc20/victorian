package src.com.victorian.produccion.utils;

import java.util.ArrayList;
import java.util.List;

public class VMetodizado {
	
	
//	reporte de crédito
	VCliente cliente = new VCliente(); //cambiar a VGeneric
	
//	cuadro de posicion
	private List<VGeneric> bancos = new ArrayList<VGeneric>();
	
//	estados financiero económico
	private VGeneric objBalanceGeneral = new VGeneric();
	private List<VGeneric> balanceGeneral_activo = new ArrayList<VGeneric>();
	private List<VGeneric> balanceGeneral_pasivo = new ArrayList<VGeneric>();
	private List<VGeneric> balanceGeneral_patrimonio = new ArrayList<VGeneric>();
	
	private VGeneric objPerdidaGanancia = new VGeneric();
	private List<VGeneric> perdidaGanancia = new ArrayList<VGeneric>();
	private VGeneric objRatio = new VGeneric();
	private List<VGeneric> ratio = new ArrayList<VGeneric>();
	

	public VCliente getCliente() {
		return cliente;
	}

	public void setCliente(VCliente cliente) {
		this.cliente = cliente;
	}

	public List<VGeneric> getBancos() {
		return bancos;
	}

	public void setBancos(List<VGeneric> bancos) {
		this.bancos = bancos;
	}

	public VGeneric getObjBalanceGeneral() {
		return objBalanceGeneral;
	}

	public void setObjBalanceGeneral(VGeneric objBalanceGeneral) {
		this.objBalanceGeneral = objBalanceGeneral;
	}


	public VGeneric getObjPerdidaGanancia() {
		return objPerdidaGanancia;
	}

	public void setObjPerdidaGanancia(VGeneric objPerdidaGanancia) {
		this.objPerdidaGanancia = objPerdidaGanancia;
	}

	public List<VGeneric> getPerdidaGanancia() {
		return perdidaGanancia;
	}

	public void setPerdidaGanancia(List<VGeneric> perdidaGanancia) {
		this.perdidaGanancia = perdidaGanancia;
	}

	public VGeneric getObjRatio() {
		return objRatio;
	}

	public void setObjRatio(VGeneric objRatio) {
		this.objRatio = objRatio;
	}

	public List<VGeneric> getRatio() {
		return ratio;
	}

	public void setRatio(List<VGeneric> ratio) {
		this.ratio = ratio;
	}

	public List<VGeneric> getBalanceGeneral_activo() {
		return balanceGeneral_activo;
	}

	public void setBalanceGeneral_activo(List<VGeneric> balanceGeneral_activo) {
		this.balanceGeneral_activo = balanceGeneral_activo;
	}

	public List<VGeneric> getBalanceGeneral_pasivo() {
		return balanceGeneral_pasivo;
	}

	public void setBalanceGeneral_pasivo(List<VGeneric> balanceGeneral_pasivo) {
		this.balanceGeneral_pasivo = balanceGeneral_pasivo;
	}

	public List<VGeneric> getBalanceGeneral_patrimonio() {
		return balanceGeneral_patrimonio;
	}

	public void setBalanceGeneral_patrimonio(
			List<VGeneric> balanceGeneral_patrimonio) {
		this.balanceGeneral_patrimonio = balanceGeneral_patrimonio;
	}
	
	
	
	
	
}
