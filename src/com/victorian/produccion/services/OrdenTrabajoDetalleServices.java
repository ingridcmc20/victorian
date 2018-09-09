package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.OrdenTrabajoDetalle;
import com.victorian.produccion.mapper.OrdenTrabajoDetalleMapper;

public class OrdenTrabajoDetalleServices implements OrdenTrabajoDetalleMapper {
	OrdenTrabajoDetalleMapper ordenTrabajoDetalleMapper = (OrdenTrabajoDetalleMapper) ServiceFinder.findBean("ordenTrabajoDetalleMapper");

	@Override
	public void insert(OrdenTrabajoDetalle ordenTrabajoDetalle) {
		// TODO Auto-generated method stub
		ordenTrabajoDetalleMapper.insert(ordenTrabajoDetalle);
	}

	@Override
	public OrdenTrabajoDetalle findByIdOrdenByEstapa(Integer id_ordentrabajo, Integer id_etapa) {
		// TODO Auto-generated method stub
		return ordenTrabajoDetalleMapper.findByIdOrdenByEstapa(id_ordentrabajo, id_etapa);
	}

	@Override
	public void updateFechaReal(OrdenTrabajoDetalle ordenTrabajoDetalle) {
		// TODO Auto-generated method stub
		ordenTrabajoDetalleMapper.updateFechaReal(ordenTrabajoDetalle);
	}

}
