package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.mapper.OperarioMapper;

public class OperarioServices implements OperarioMapper{
	OperarioMapper operarioMapper = (OperarioMapper)ServiceFinder.findBean("operarioMapper");
	
	@Override
	public List<Operario> findByEstado(Integer id_tipooperario) throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findByEstado(id_tipooperario);
	}

	@Override
	public Operario findById(Integer id_operario) throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findById(id_operario);
	}

	@Override
	public List<String> findByTipoAndByIdOrden(Integer id_tipooperario, Integer id_ordentrabajo) throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findByTipoAndByIdOrden(id_tipooperario, id_ordentrabajo);
	}

	@Override
	public List<Operario> findCortadorYConfeccion() throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findCortadorYConfeccion();
	}

	@Override
	public List<Operario> findByEstadoDisponible(Integer id_tipooperario) throws Exception {
		// TODO Auto-generated method stub
		return operarioMapper.findByEstadoDisponible(id_tipooperario);
	}

	@Override
	public void updateOperario(Operario operario) throws Exception {
		// TODO Auto-generated method stub
		operarioMapper.updateOperario(operario);
	}
}
