package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.TipoConfeccion;

public interface TipoConfeccionMapper {
	@Select("SELECT idtipoconfeccion, descripcion FROM t_tipoconfeccion")
	public List<TipoConfeccion> findAll() throws Exception;	
}
