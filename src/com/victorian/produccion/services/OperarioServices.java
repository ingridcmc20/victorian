package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.mapper.OperarioMapper;

public class OperarioServices implements OperarioMapper{
	OperarioMapper operarioMapper = (OperarioMapper)ServiceFinder.findBean("operarioMapper");
	
	@Override
	public List<Operario> findByEstado(String tipo_operario) throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findByEstado(tipo_operario);
	}

	@Override
	public Operario findById(Integer id_operario) throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findById(id_operario);
	}

	@Override
	public List<String> findByTipoAndByIdOrden(String tipo_operario, Integer id_orden_trabajo) throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findByTipoAndByIdOrden(tipo_operario, id_orden_trabajo);
	}

	@Override
	public List<Operario> findCortadorYConfeccion() throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findCortadorYConfeccion();
	}

	@Override
	public List<Operario> findByEstadoDisponible(String tipo_operario) throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findByEstadoDisponible(tipo_operario);
	}

	@Override
	public void updateOperario(Operario operario) throws Exception {
		// TODO Auto-generated method stub
		operarioMapper.updateOperario(operario);
	}
}
