package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.OrdenTrabajoOperario;
import com.victorian.produccion.mapper.OrdenTrabajoOperarioMapper;

public class OrdenTrabajoOperarioServices implements OrdenTrabajoOperarioMapper {
	OrdenTrabajoOperarioMapper ordenTrabajoOperarioMapper = (OrdenTrabajoOperarioMapper) ServiceFinder
			.findBean("ordenTrabajoOperarioMapper");

	@Override
	public void insert(OrdenTrabajoOperario ordenTrabajoOperario) {
		// TODO Auto-generated method stub
		ordenTrabajoOperarioMapper.insert(ordenTrabajoOperario);
	}

	@Override
	public void delete(Integer id_ordentrabajo) {
		// TODO Auto-generated method stub
		ordenTrabajoOperarioMapper.delete(id_ordentrabajo);
	}

	@Override
	public void updateOrdenTrabajoOperario(OrdenTrabajoOperario operarioTrabajo) throws Exception {
		ordenTrabajoOperarioMapper.updateOrdenTrabajoOperario(operarioTrabajo);
	}

	@Override
	public OrdenTrabajoOperario findByOperarioYOrdenTrabajo(Integer id_ordentrabajo, Integer id_operario) {
		// TODO Auto-generated method stub
		return ordenTrabajoOperarioMapper.findByOperarioYOrdenTrabajo(id_ordentrabajo, id_operario);
	}
}
