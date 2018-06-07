package com.victorian.produccion.services;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Log;
import com.victorian.produccion.mapper.LogMapper;

public class LogServices implements LogMapper {
	
	LogMapper logMapper = (LogMapper)ServiceFinder.findBean("logMapper");

	@Override
	public void insertLog(Log log) throws Exception {
		// TODO Auto-generated method stub
		logMapper.insertLog(log);
	}

	@Override
	public List<Log> getLog_DateInterval(
			@Param("p_fecha_inicio") Date fecha_inicio,
			@Param("p_fecha_fin") Date fecha_fin) throws Exception {
		// TODO Auto-generated method stub
		return logMapper.getLog_DateInterval(fecha_inicio, fecha_fin); 
	}

	@Override
	public List<Integer> getAniosRegistrados() throws Exception {
		return logMapper.getAniosRegistrados();
	}

	@Override
	public List<Log> getLogFiltradoPeriodoAnio(Integer mes, Integer anio)
			throws Exception {
		return logMapper.getLogFiltradoPeriodoAnio(mes, anio);
	}

	
}
