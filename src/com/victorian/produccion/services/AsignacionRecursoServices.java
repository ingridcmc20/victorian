package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.AsignacionRecurso;
import com.victorian.produccion.domain.Recurso;
import com.victorian.produccion.mapper.AsignacionRecursoMapper;

public class AsignacionRecursoServices implements AsignacionRecursoMapper {
	AsignacionRecursoMapper asignacionRecursoMapper = (AsignacionRecursoMapper)ServiceFinder.findBean("asignacionRecursoMapper");
	
	@Override
	public AsignacionRecurso findByIdPedido(Integer id_pedido) throws Exception {
		// TODO Auto-generated method stub
		return asignacionRecursoMapper.findByIdPedido(id_pedido);
	}

	@Override
	public void insert(AsignacionRecurso asignacionRecurso) throws Exception {
		// TODO Auto-generated method stub
		asignacionRecursoMapper.insert(asignacionRecurso);
	}

	@Override
	public void update(AsignacionRecurso asignacionRecurso) throws Exception {
		// TODO Auto-generated method stub
		asignacionRecursoMapper.update(asignacionRecurso);
	}

	@Override
	public List<Recurso> listarRecursosDisponibles() throws Exception {
		// TODO Auto-generated method stub
		return asignacionRecursoMapper.listarRecursosDisponibles();
	}

}
