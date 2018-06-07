package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.FichaTecnica;
import com.victorian.produccion.mapper.FichaTecnicaMapper;

public class FichaTecnicaServices implements FichaTecnicaMapper{
	FichaTecnicaMapper fichaTecnicaMapper = (FichaTecnicaMapper)ServiceFinder.findBean("fichaTecnicaMapper");
	
	@Override
	public List<FichaTecnica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return fichaTecnicaMapper.findAll();
	}

	@Override
	public void insert(FichaTecnica fichaTecnica) throws Exception{
		// TODO Auto-generated method stub
		fichaTecnicaMapper.insert(fichaTecnica);
	}

	@Override
	public List<FichaTecnica> findByProducto(Integer idproducto) throws Exception {
		// TODO Auto-generated method stub
		return fichaTecnicaMapper.findByProducto(idproducto);
	}

	@Override
	public void delete(Integer idfichatecnica) throws Exception {
		// TODO Auto-generated method stub
		fichaTecnicaMapper.delete(idfichatecnica);
	}

}
