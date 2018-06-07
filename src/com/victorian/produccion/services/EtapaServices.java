package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Etapa;
import com.victorian.produccion.mapper.EtapaMapper;

public class EtapaServices implements EtapaMapper {
	EtapaMapper etapaMapper = (EtapaMapper) ServiceFinder.findBean("etapaMapper");

	@Override
	public List<Etapa> findAll() throws Exception {
		// TODO Auto-generated method stub
		return etapaMapper.findAll();
	}

}
