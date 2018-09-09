package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Merma;

public interface MermaMapper {
	@Select("SELECT id_merma, id_ordentrabajo, descripcion, id_estado FROM victorian.t_merma where id_estado=8 order by descripcion")
	public List<Merma> findAll();
	
	@Select("SELECT id_merma, id_ordentrabajo, descripcion, id_estado "
			+ "FROM victorian.t_merma "
			+ "where id_ordentrabajo=#{id_ordentrabajo} and id_estado=8 order by descripcion")
	public List<Merma> findByOrdenTrabajo(Integer id_ordentrabajo);
	
	@Insert("INSERT INTO victorian.t_merma(id_ordentrabajo, descripcion, id_estado) "
			+ "VALUES (#{id_ordentrabajo}, #{descripcion}, #{id_estado})")
	public void insert(Merma merma);
}
