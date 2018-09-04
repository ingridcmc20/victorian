package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface NivelMapper {
	@Select("SELECT max(id_nivel) as id_nivel FROM victorian.t_nivel where puntaje_obtenido <= #{puntaje}")
	public Integer findIdNivelByPuntaje(@Param("puntaje") int puntaje);
}
