package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Insumo;

public interface InsumoMapper {
	@Select("SELECT idinsumo, descripcion, precio FROM t_insumo")
	public List<Insumo> findAll() throws Exception;

	@Select("SELECT idinsumo, descripcion, precio FROM t_insumo where idinsumo=#{idinsumo}")
	public Insumo findById(@Param("idinsumo") Integer idinsumo);
}
