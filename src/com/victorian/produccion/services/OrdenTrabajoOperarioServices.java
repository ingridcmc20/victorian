package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.OrdenTrabajoOperario;
import com.victorian.produccion.mapper.OrdenTrabajoOperarioMapper;

public class OrdenTrabajoOperarioServices implements OrdenTrabajoOperarioMapper {
	OrdenTrabajoOperarioMapper ordenTrabajoOperarioMapper = (OrdenTrabajoOperarioMapper) ServiceFinder.findBean("ordenTrabajoOperarioMapper");

	@Override
	public void insert(OrdenTrabajoOperario ordenTrabajoOperario) {
		// TODO Auto-generated method stub
		ordenTrabajoOperarioMapper.insert(ordenTrabajoOperario);
	}

	@Override
	public void delete(Integer id_orden_trabajo) {
		// TODO Auto-generated method stub
		ordenTrabajoOperarioMapper.delete(id_orden_trabajo);
	}
}
