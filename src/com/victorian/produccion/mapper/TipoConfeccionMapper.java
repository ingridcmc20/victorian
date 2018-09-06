package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.TipoConfeccion;

public interface TipoConfeccionMapper {
	@Select("SELECT id_tipoconfeccion, descripcion FROM victorian.t_tipo_confeccion")
	public List<TipoConfeccion> findAll() throws Exception;
}
