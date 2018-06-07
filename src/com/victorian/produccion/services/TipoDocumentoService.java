package com.victorian.produccion.services;

import java.util.List;

import com.victorian.produccion.domain.TipoDocumento;
import com.victorian.produccion.mapper.TipoDocumentoMapper;
import com.pe.victorian.produccion.commons.ServiceFinder;

public class TipoDocumentoService implements TipoDocumentoMapper{

	TipoDocumentoMapper tipoDocumentoMapper = (TipoDocumentoMapper)ServiceFinder.findBean("tipoDocumentoMapper");

	@Override
	public TipoDocumento findById(Integer codigoEstado) throws Exception {
		// TODO Auto-generated method stub
		return tipoDocumentoMapper.findById(codigoEstado);
	}

	@Override
	public List<TipoDocumento> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoDocumentoMapper.findAll();
	}

	@Override
	public void crearTipoDocumento(TipoDocumento resultado) throws Exception {
		tipoDocumentoMapper.crearTipoDocumento(resultado);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarTipoDocumento(TipoDocumento tipodocumento)
			throws Exception {
		tipoDocumentoMapper.actualizarTipoDocumento(tipodocumento);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTipoDocumento(Integer id_tipo_documento)
			throws Exception {
		tipoDocumentoMapper.eliminarTipoDocumento(id_tipo_documento);
		// TODO Auto-generated method stub
		
	}

@Override
	public List<TipoDocumento> listaTipoDocumentoActivo() throws Exception {
		// TODO Auto-generated method stub
		return tipoDocumentoMapper.listaTipoDocumentoActivo();
	}

	@Override
	public TipoDocumento findByDescripcion(String descripcion)
			throws Exception {
		return tipoDocumentoMapper.findByDescripcion(descripcion);
	}
	


}
