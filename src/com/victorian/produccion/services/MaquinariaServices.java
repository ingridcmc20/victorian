package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Maquinaria;
import com.victorian.produccion.mapper.MaquinariaMapper;

public class MaquinariaServices implements MaquinariaMapper {
	MaquinariaMapper maquinariaMapper = (MaquinariaMapper)ServiceFinder.findBean("maquinariaMapper");
	
	@Override
	public List<Maquinaria> findByEstado(String tipo) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaMapper.findByEstado(tipo);
	}

	@Override
	public List<Maquinaria> findById(Integer id_maquinaria) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaMapper.findById(id_maquinaria);
	}

	@Override
	public List<String> findByEstadoAndByIdOrden(String tipo, Integer id_ordentrabajo) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaMapper.findByEstadoAndByIdOrden(tipo, id_ordentrabajo);
	}

	@Override
	public List<Maquinaria> findByEstadoDisponible(String id_tipooperario) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaMapper.findByEstadoDisponible(id_tipooperario);
	}

}
