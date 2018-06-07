package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Prioridad;
import com.victorian.produccion.mapper.PrioridadMapper;

public class PrioridadServices implements PrioridadMapper {
	PrioridadMapper prioridadMapper = (PrioridadMapper) ServiceFinder.findBean("prioridadMapper");

	@Override
	public List<Prioridad> findAll() {
		// TODO Auto-generated method stub
		return prioridadMapper.findAll();
	}

}
