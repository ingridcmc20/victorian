package com.victorian.produccion.services;

import java.util.List;

import com.victorian.produccion.domain.EstadoCivil;
import com.victorian.produccion.mapper.EstadoCivilMapper;
import com.pe.victorian.produccion.commons.ServiceFinder;

public class EstadoCivilService implements EstadoCivilMapper{

	EstadoCivilMapper estadoCivilMapper = (EstadoCivilMapper)ServiceFinder.findBean("estadoCivilMapper");

	@Override
	public EstadoCivil findById(Integer codigoEstado) throws Exception {
		// TODO Auto-generated method stub
		return estadoCivilMapper.findById(codigoEstado);
	}

	@Override
	public List<EstadoCivil> findAll() throws Exception {
		// TODO Auto-generated method stub
		return estadoCivilMapper.findAll();
	}

	@Override
	public void crearEstadoCivil(EstadoCivil resultado) throws Exception {
		estadoCivilMapper.crearEstadoCivil(resultado);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEstadoCivil(EstadoCivil estadocivil)
			throws Exception {
		estadoCivilMapper.actualizarEstadoCivil(estadocivil);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEstadoCivil(Integer id_estado_civil)
			throws Exception {
		estadoCivilMapper.eliminarEstadoCivil(id_estado_civil);
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public List<TipoDocumentoPago> listaTipoDocumentoActivo() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}
