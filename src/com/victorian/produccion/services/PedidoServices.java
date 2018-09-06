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
	public List<Pedido> findByEstado(Integer id_estado) throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findByEstado(id_estado);
	}

	@Override
	public List<Pedido> findByPlanProduccion(Integer idplan) throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findByPlanProduccion(idplan);
	}

	@Override
	public Pedido findById(Integer id_pedido) throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findById(id_pedido);
	}

	@Override
	public Pedido findByIdAndByEstado(Integer id_pedido, Integer id_estado) throws Exception {
		// TODO Auto-generated method stub
		return pedidoMapper.findByIdAndByEstado(id_pedido, id_estado);
	}

}
