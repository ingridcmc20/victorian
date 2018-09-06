package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.victorian.produccion.domain.OrdenTrabajoOperario;

public interface OrdenTrabajoOperarioMapper {
	
	@Insert("INSERT INTO victorian.t_orden_trabajo_operario(id_operario, id_orden_trabajo, id_prioridad, id_etapa) "
			+ "VALUES (#{id_operario}, #{id_orden_trabajo}, #{id_prioridad}, #{id_etapa})")
	public void insert(OrdenTrabajoOperario ordenTrabajoOperario);
	
	@Delete("delete from victorian.t_orden_trabajo_operario where id_orden_trabajo=#{id_orden_trabajo}")
	public void delete(Integer id_orden_trabajo);
}
