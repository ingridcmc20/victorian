package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.mapper.NivelMapper;

public class NivelServices implements NivelMapper{
	NivelMapper nivelMapper = (NivelMapper)ServiceFinder.findBean("nivelMapper");

	@Override
	public Integer findIdNivelByPuntaje(int puntaje) {
		// TODO Auto-generated method stub
		return nivelMapper.findIdNivelByPuntaje(puntaje);
	}

}
