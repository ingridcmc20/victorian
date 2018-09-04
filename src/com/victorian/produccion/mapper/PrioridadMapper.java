package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Prioridad;

public interface PrioridadMapper {
	@Select("select * from victorian.t_prioridad order by id_prioridad")
	public List<Prioridad> findAll();
}
