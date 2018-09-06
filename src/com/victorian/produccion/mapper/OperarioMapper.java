package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Operario;

public interface OperarioMapper {

	@Select("SELECT o.id_operario, o.id_tipooperario, u.apellido_paterno || ' ' || u.apellido_materno || ' ' "
			+ "|| u.nombre as nombre_operario FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_operario "
			+ "where id_tipooperario=#{id_tipooperario}")
	public List<Operario> findByEstado(@Param("id_tipooperario") Integer id_tipooperario) throws Exception;

	@Select("SELECT o.id_operario, o.id_tipooperario, u.apellido_paterno || ' ' || u.apellido_materno || ' ' "
			+ "|| u.nombre as nombre_operario FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_operario "
			+ "where id_tipooperario=#{id_tipooperario} and o.id_operario not in (select x.id_operario from victorian.t_orden_trabajo_operario x inner join victorian.t_orden_trabajo y on y.id_orden_trabajo=x.id_orden_trabajo where y.id_estado not in (6))")
	public List<Operario> findByEstadoDisponible(@Param("id_tipooperario") Integer id_tipooperario) throws Exception;

	@Select("SELECT o.id_operario, o.id_tipooperario, u.apellido_paterno || ' ' || u.apellido_materno || ' ' "
			+ "|| u.nombre as nombre_operario, o.id_nivel, o.puntaje_acumulado, o.puntaje_obtenido, o.fecha_subida_nivel "
			+ "FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_operario "
			+ "where o.id_operario=#{id_operario}")
	public Operario findById(@Param("id_operario") Integer id_operario) throws Exception;

	@Select("SELECT o.id_operario||'' as id_operario "
			+ "FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_operario inner join victorian.t_orden_trabajo_operario oto on oto.id_operario=o.id_operario "
			+ "where id_tipooperario=#{id_tipooperario} and id_orden_trabajo=#{id_orden_trabajo}")
	public List<String> findByTipoAndByIdOrden(@Param("id_tipooperario") String id_tipooperario,
			@Param("id_orden_trabajo") Integer id_orden_trabajo) throws Exception;

	@Select("SELECT o.id_operario, u.apellido_paterno || ' ' || u.apellido_materno || ', ' || u.nombre as nombre_operario, o.id_tipooperario, o.id_nivel "
			+ "FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_operario inner join victorian.t_orden_trabajo_operario oto on oto.id_operario=o.id_operario "
			+ "inner join victorian.t_orden_trabajo_detalle otd on otd.id_orden_trabajo=oto.id_orden_trabajo and otd.id_etapa=oto.id_etapa "
			+ "where id_tipooperario in (2,3) and extract(year from fecha_subida_nivel) = extract(year from current_date) "
			+ "and extract(month from fecha_subida_nivel) = extract(month from current_date) ")
	public List<Operario> findCortadorYConfeccion() throws Exception;

	@Update("UPDATE victorian.t_operario SET puntaje_obtenido=#{puntaje_obtenido}, puntaje_acumulado=#{puntaje_acumulado}, id_nivel=#{id_nivel}, fecha_subida_nivel=#{fecha_subida_nivel} WHERE id_operario=#{id_operario}")
	public void updateOperario(Operario operario) throws Exception;
}
