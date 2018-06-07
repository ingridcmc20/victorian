package com.victorian.produccion.services;

import java.util.List;

import com.victorian.produccion.domain.TipoUsuario;
import com.victorian.produccion.mapper.TipoUsuarioMapper;
import com.pe.victorian.produccion.commons.ServiceFinder;

public class TipoUsuarioService implements TipoUsuarioMapper {

	private TipoUsuarioMapper tipoUsuarioMapper = (TipoUsuarioMapper)ServiceFinder.findBean("tipoUsuarioMapper");
	
	@Override
	public List<TipoUsuario> findAll() throws Exception {
		return tipoUsuarioMapper.findAll();
	}

}
