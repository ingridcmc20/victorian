package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.TipoConfeccion;
import com.victorian.produccion.mapper.TipoConfeccionMapper;

public class TipoConfeccionServices implements TipoConfeccionMapper {
	TipoConfeccionMapper tipoConfeccionMapper = (TipoConfeccionMapper)ServiceFinder.findBean("tipoConfeccionMapper");
	
	@Override
	public List<TipoConfeccion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoConfeccionMapper.findAll();
	}

}
