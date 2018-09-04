package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Etapa;

public interface EtapaMapper {
	@Select("SELECT id_etapa, descripcion FROM victorian.t_etapa")
	public List<Etapa> findAll() throws Exception;
}
