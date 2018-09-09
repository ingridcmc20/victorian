package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.victorian.produccion.domain.OrdenTrabajoMaquinaria;

public interface OrdenTrabajoMaquinariaMapper {
	@Insert("INSERT INTO victorian.t_ordentrabajo_maquinaria(id_maquinaria, id_ordentrabajo, id_etapa) "
			+ "VALUES (#{id_maquinaria}, #{id_ordentrabajo}, #{id_etapa})")
	public void insert(OrdenTrabajoMaquinaria ordenTrabajoMaquinaria);
	
	@Delete("delete from victorian.t_ordentrabajo_maquinaria where id_ordentrabajo=#{id_ordentrabajo}")
	public void delete(Integer id_ordentrabajo);
}
