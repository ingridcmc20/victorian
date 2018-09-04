package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.victorian.produccion.domain.OrdenTrabajoMaquinaria;

public interface OrdenTrabajoMaquinariaMapper {
	@Insert("INSERT INTO victorian.t_orden_trabajo_maquinaria(id_maquinaria, id_orden_trabajo, id_prioridad) "
			+ "VALUES (#{idmaquinaria}, #{id_orden_trabajo}, #{id_prioridad})")
	public void insert(OrdenTrabajoMaquinaria ordenTrabajoMaquinaria);
	
	@Delete("delete from victorian.t_orden_trabajo_maquinaria where id_orden_trabajo=#{id_orden_trabajo}")
	public void delete(Integer id_orden_trabajo);
}
