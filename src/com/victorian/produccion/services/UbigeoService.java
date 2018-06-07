package com.victorian.produccion.services;

import java.util.List;

import com.victorian.produccion.domain.Ubigeo;
import com.victorian.produccion.mapper.UbigeoMapper;
import com.pe.victorian.produccion.commons.ServiceFinder;

public class UbigeoService implements UbigeoMapper{
	
	UbigeoMapper ubigeoMapper = (UbigeoMapper)ServiceFinder.findBean("ubigeoMapper");

	@Override
	public List<Ubigeo> findAll() throws Exception {
		return ubigeoMapper.findAll();
	}

	@Override
	public List<Ubigeo> listarDepartamentos() {
		return ubigeoMapper.listarDepartamentos();
	}

	@Override
	public List<Ubigeo> listarProvincias(String sdepartamento) {
		return ubigeoMapper.listarProvincias(sdepartamento);
	}

	@Override
	public List<Ubigeo> listardistritos(String sdepartamento, String sprovincia) {
		return ubigeoMapper.listardistritos(sdepartamento, sprovincia);
	}

	@Override
	public Ubigeo obtenerUbigeoById(Integer sid_ubigeo) {
		// TODO Auto-generated method stub
		return ubigeoMapper.obtenerUbigeoById(sid_ubigeo);
	}

	@Override
	public List<Ubigeo> listardistritosByProvincia(String sprovincia) {
		// TODO Auto-generated method stub
		return ubigeoMapper.listardistritosByProvincia(sprovincia);
	}


	
	

}
