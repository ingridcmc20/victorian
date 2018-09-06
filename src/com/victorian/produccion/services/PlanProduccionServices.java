package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.PlanProduccion;
import com.victorian.produccion.mapper.PlanProduccionMapper;

public class PlanProduccionServices implements PlanProduccionMapper {
	PlanProduccionMapper planProduccionMapper = (PlanProduccionMapper) ServiceFinder.findBean("planProduccionMapper");

	@Override
	public void insert(PlanProduccion planProduccion) throws Exception {
		// TODO Auto-generated method stub
		planProduccionMapper.insert(planProduccion);
	}

	@Override
	public List<PlanProduccion> findByEstado(Integer estado) {
		// TODO Auto-generated method stub
		return planProduccionMapper.findByEstado(estado);
	}

	@Override
	public void update(PlanProduccion p) {
		// TODO Auto-generated method stub
		planProduccionMapper.update(p);
	}

	@Override
	public PlanProduccion findById(Integer idplan) {
		// TODO Auto-generated method stub
		return planProduccionMapper.findById(idplan);
	}

}
