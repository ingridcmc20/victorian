package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.PlanPedido;
import com.victorian.produccion.mapper.PlanPedidoMapper;

public class PlanPedidoServices implements PlanPedidoMapper {
	PlanPedidoMapper planPedidoMapper = (PlanPedidoMapper)ServiceFinder.findBean("planPedidoMapper");

	@Override
	public void insert(PlanPedido planPedido) throws Exception {
		// TODO Auto-generated method stub
		planPedidoMapper.insert(planPedido);
	}

	@Override
	public PlanPedido findByPedido(Integer idpedido) throws Exception {
		// TODO Auto-generated method stub
		return planPedidoMapper.findByPedido(idpedido);
	}

	@Override
	public PlanPedido findByPedidoSinFicha(Integer idpedido) throws Exception {
		// TODO Auto-generated method stub
		return planPedidoMapper.findByPedidoSinFicha(idpedido);
	}

}
