package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.OrdenTrabajoOperario;

public interface OrdenTrabajoOperarioMapper {

	@Insert("INSERT INTO victorian.t_ordentrabajo_operario(id_operario, id_ordentrabajo, id_etapa, id_nivel, puntaje_obtenido) "
			+ "VALUES (#{id_operario}, #{id_ordentrabajo}, #{id_etapa}, #{id_nivel}, #{puntaje_obtenido})")
	public void insert(OrdenTrabajoOperario ordenTrabajoOperario);

	@Delete("delete from victorian.t_ordentrabajo_operario where id_ordentrabajo=#{id_ordentrabajo}")
	public void delete(Integer id_ordentrabajo);

	@Update("UPDATE victorian.t_ordentrabajo_operario SET puntaje_obtenido=#{puntaje_obtenido}, id_nivel=#{id_nivel}, fecha_nivel=#{fecha_nivel} WHERE id_operario=#{id_operario} and id_ordentrabajo=#{id_ordentrabajo}")
	public void updateOrdenTrabajoOperario(OrdenTrabajoOperario operarioTrabajo) throws Exception;
	
	@Select("select id_ordentrabajo,id_etapa,id_operario,puntaje_obtenido,fecha_nivel,id_nivel from victorian.t_ordentrabajo_operario where id_operario=#{p_id_operario} and id_ordentrabajo=#{p_id_ordentrabajo}")
	public OrdenTrabajoOperario findByOperarioYOrdenTrabajo(@Param("p_id_ordentrabajo") Integer id_ordentrabajo, @Param("p_id_operario") Integer id_operario);
}
