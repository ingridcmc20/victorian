package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.TipoUsuario;

public interface TipoUsuarioMapper {
	@Select("select * from t_tipo_usuario")
	public List<TipoUsuario> findAll() throws Exception;
}
