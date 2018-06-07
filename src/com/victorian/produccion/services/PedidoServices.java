package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Pedido;
import com.victorian.produccion.mapper.PedidoMapper;

public class PedidoServices implements PedidoMapper{
	PedidoMapper pedidoMapper = (PedidoMapper)ServiceFinder.findBean("pedidoMapper");
	
	@Override
	public List<Pedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findAll();
	}

	@Override
	public void crearPedido(Pedido pedido) throws Exception {
		// TODO Auto-generated method stub
		pedidoMapper.crearPedido(pedido);
	}

	@Override
	public void actualizarPedido(Pedido pedido) throws Exception {
		// TODO Auto-generated method stub
		pedidoMapper.actualizarPedido(pedido);
	}

	@Override
	public List<Pedido> findAllByFechaEstadoYEntrega() throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findAll();
	}

	@Override
	public List<Pedido> findByEstado(Integer estadopedido) throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findByEstado(estadopedido);
	}

	@Override
	public List<Pedido> findByPlanProduccion(Integer idplan) throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findByPlanProduccion(idplan);
	}

	@Override
	public Pedido findById(Integer idpedido) throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findById(idpedido);
	}

	@Override
	public Pedido findByIdAndByEstado(Integer idpedido, Integer estadopedido) throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findByIdAndByEstado(idpedido, estadopedido);
	}

}
