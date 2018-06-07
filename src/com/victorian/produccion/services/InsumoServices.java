package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Insumo;
import com.victorian.produccion.mapper.InsumoMapper;

public class InsumoServices implements InsumoMapper{
	InsumoMapper insumoMapper = (InsumoMapper)ServiceFinder.findBean("insumoMapper");
	
	@Override
	public List<Insumo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return insumoMapper.findAll();
	}
	
	@Override
	public Insumo findById(Integer idinsumo) {
		// TODO Auto-generated method stub
		return insumoMapper.findById(idinsumo);
	}

}
