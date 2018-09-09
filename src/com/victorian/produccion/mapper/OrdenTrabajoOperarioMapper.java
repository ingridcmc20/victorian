package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.victorian.produccion.domain.OrdenTrabajoOperario;

public interface OrdenTrabajoOperarioMapper {
	
	@Insert("INSERT INTO victorian.t_ordentrabajo_operario(id_operario, id_ordentrabajo, id_etapa, id_nivel, puntaje_obtenido) "
			+ "VALUES (#{id_operario}, #{id_ordentrabajo}, #{id_etapa}, #{id_nivel}, #{puntaje_obtenido})")
	public void insert(OrdenTrabajoOperario ordenTrabajoOperario);
	
	@Delete("delete from victorian.t_ordentrabajo_operario where id_ordentrabajo=#{id_ordentrabajo}")
	public void delete(Integer id_ordentrabajo);
}
