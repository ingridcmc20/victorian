package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Merma;

public interface MermaMapper {
	@Select("SELECT id_merma, id_orden_trabajo, descripcion, id_estado FROM victorian.t_merma where id_estado=8 order by descripcion")
	public List<Merma> findAll();
	
	@Select("SELECT id_merma, id_orden_trabajo, descripcion, id_estado "
			+ "FROM victorian.t_merma "
			+ "where id_orden_trabajo=#{id_orden_trabajo} and id_estado=8 order by descripcion")
	public List<Merma> findByOrdenTrabajo(Integer id_orden_trabajo);
	
	@Insert("INSERT INTO victorian.t_merma(id_orden_trabajo, descripcion, id_estado) "
			+ "VALUES (#{id_orden_trabajo}, #{descripcion}, #{id_estado})")
	public void insert(Merma merma);
}
