package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Merma;
import com.victorian.produccion.mapper.MermaMapper;

public class MermaServices implements MermaMapper {
	MermaMapper mermaMapper = (MermaMapper) ServiceFinder.findBean("mermaMapper");

	@Override
	public List<Merma> findAll() {
		// TODO Auto-generated method stub
		return mermaMapper.findAll();
	}

	@Override
	public void insert(Merma merma) {
		// TODO Auto-generated method stub
		mermaMapper.insert(merma);
	}

	@Override
	public List<Merma> findByOrdenTrabajo(Integer id_ordentrabajo) {
		// TODO Auto-generated method stub
		return mermaMapper.findByOrdenTrabajo(id_ordentrabajo);
	}

}
