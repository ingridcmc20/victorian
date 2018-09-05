package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Insumo;

public interface InsumoMapper {
	@Select("SELECT id_insumo, descripcion, precio FROM victorian.t_insumo")
	public List<Insumo> findAll() throws Exception;

	@Select("SELECT id_insumo, descripcion, precio FROM victorian.t_insumo where id_insumo=#{id_insumo}")
	public Insumo findById(@Param("id_insumo") Integer id_insumo);
}
