package com.victorian.produccion.services;


import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Formato;
import com.victorian.produccion.mapper.FormatoMapper;

public class FormatoServices implements FormatoMapper {
	
	FormatoMapper formatoMapper = (FormatoMapper)ServiceFinder.findBean("formatoMapper");

	@Override
	public Formato findById(Integer idformato) throws Exception {
		return formatoMapper.findById(idformato);
	}

	@Override
	public List<Formato> findAll() throws Exception {
		return formatoMapper.findAll();
	}

	@Override
	public void crearFormato(Formato formato) throws Exception {
		formatoMapper.crearFormato(formato);
		
	}

	@Override
	public void eliminarFormato(Integer idformato) throws Exception {
		formatoMapper.eliminarFormato(idformato);
		
	}

	@Override
	public void actualizarFormato(Formato formato) throws Exception {
		formatoMapper.actualizarFormato(formato);
		
	}
	
	@Override
	public List<Formato> listFormatoxProducto(Integer id_producto) throws Exception {		
		return formatoMapper.listFormatoxProducto(id_producto);
	}

}
