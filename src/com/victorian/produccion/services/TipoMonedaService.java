package com.victorian.produccion.services;

import java.util.List;

import com.victorian.produccion.domain.TipoMoneda;
import com.victorian.produccion.mapper.TipoMonedaMapper;
import com.pe.victorian.produccion.commons.ServiceFinder;

public class TipoMonedaService implements TipoMonedaMapper {

	TipoMonedaMapper tipoMonedaMapper = (TipoMonedaMapper)ServiceFinder.findBean("tipoMonedaMapper");

	@Override
	public TipoMoneda findById(Integer codigoEstado) throws Exception {
		// TODO Auto-generated method stub
		return tipoMonedaMapper.findById(codigoEstado);
	}

	@Override
	public List<TipoMoneda> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoMonedaMapper.findAll();
	}

	@Override
	public void crearTipoMoneda(TipoMoneda resultado) throws Exception {
		tipoMonedaMapper.crearTipoMoneda(resultado);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarTipoMoneda(TipoMoneda tipomoneda)
			throws Exception {
		tipoMonedaMapper.actualizarTipoMoneda(tipomoneda);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTipoMoneda(Integer id_tipo_moneda)
			throws Exception {
		tipoMonedaMapper.eliminarTipoMoneda(id_tipo_moneda);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoMoneda> findByEstado(boolean estado) throws Exception {
		// TODO Auto-generated method stub
		return tipoMonedaMapper.findByEstado(estado);
	}
	
	
	
}
