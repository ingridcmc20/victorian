package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.OrdenTrabajoMaquinaria;
import com.victorian.produccion.mapper.OrdenTrabajoMaquinariaMapper;

public class OrdenTrabajoMaquinariaServices implements OrdenTrabajoMaquinariaMapper {
	OrdenTrabajoMaquinariaMapper ordenTrabajoMaquinariaMapper = (OrdenTrabajoMaquinariaMapper) ServiceFinder.findBean("ordenTrabajoMaquinariaMapper");

	@Override
	public void insert(OrdenTrabajoMaquinaria ordenTrabajoMaquinaria) {
		// TODO Auto-generated method stub
		ordenTrabajoMaquinariaMapper.insert(ordenTrabajoMaquinaria);
	}

	@Override
	public void delete(Integer id_ordentrabajo) {
		// TODO Auto-generated method stub
		ordenTrabajoMaquinariaMapper.delete(id_ordentrabajo);
	}

}
