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
	public List<Maquinaria> findById(Integer idmaquinaria) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaMapper.findById(idmaquinaria);
	}

	@Override
	public List<String> findByEstadoAndByIdOrden(String tipo, Integer id_orden_trabajo) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaMapper.findByEstadoAndByIdOrden(tipo, id_orden_trabajo);
	}

	@Override
	public List<Maquinaria> findByEstadoDisponible(String tipo_operario) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaMapper.findByEstadoDisponible(tipo_operario);
	}

}
