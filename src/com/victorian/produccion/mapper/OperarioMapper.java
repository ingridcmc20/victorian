package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Operario;

public interface OperarioMapper {
	
	@Select("SELECT o.idoperario, o.tipo_operario, o.estado, u.apellido_paterno || ' ' || u.apellido_materno || ' ' "
			+ "|| u.nombre as nombre_operario FROM t_operario o inner join t_usuario u on u.idusuario=o.idoperario "
			+ "where tipo_operario=#{tipo_operario}")
	public List<Operario> findByEstado(@Param("tipo_operario") String tipo_operario) throws Exception;
	
	@Select("SELECT o.idoperario, o.tipo_operario, o.estado, u.apellido_paterno || ' ' || u.apellido_materno || ' ' "
			+ "|| u.nombre as nombre_operario FROM t_operario o inner join t_usuario u on u.idusuario=o.idoperario "
			+ "where tipo_operario=#{tipo_operario} and o.idoperario not in (select x.id_operario from t_orden_trabajo_operario x inner join t_orden_trabajo y on y.id_orden_trabajo=x.id_orden_trabajo where y.id_estado not in (6))")
	public List<Operario> findByEstadoDisponible(@Param("tipo_operario") String tipo_operario) throws Exception;
	
	@Select("SELECT o.idoperario, o.tipo_operario, o.estado, u.apellido_paterno || ' ' || u.apellido_materno || ' ' "
			+ "|| u.nombre as nombre_operario, o.id_nivel, o.puntaje_acumulado, o.puntaje_obtenido, o.fecha_subida_nivel "
			+ "FROM t_operario o inner join t_usuario u on u.idusuario=o.idoperario "
			+ "where o.idoperario=#{id_operario}")
	public Operario findById(@Param("id_operario") Integer id_operario) throws Exception;
	
	@Select("SELECT o.idoperario||'' as idoperario "
			+ "FROM t_operario o inner join t_usuario u on u.idusuario=o.idoperario inner join t_orden_trabajo_operario oto on oto.id_operario=o.idoperario "
			+ "where tipo_operario=#{tipo_operario} and id_orden_trabajo=#{id_orden_trabajo}")
	public List<String> findByTipoAndByIdOrden(@Param("tipo_operario") String tipo_operario, @Param("id_orden_trabajo") Integer id_orden_trabajo) throws Exception;
	
	@Select("SELECT o.idoperario, u.apellido_paterno || ' ' || u.apellido_materno || ', ' || u.nombre as nombre_operario, o.tipo_operario, o.id_nivel "
			+ "FROM t_operario o inner join t_usuario u on u.idusuario=o.idoperario inner join t_orden_trabajo_operario oto on oto.id_operario=o.idoperario "
			+ "inner join t_orden_trabajo_detalle otd on otd.id_orden_trabajo=oto.id_orden_trabajo and otd.id_etapa=oto.id_etapa "
			+ "where tipo_operario in ('CORTADOR','CONFECCIONISTA') and extract(year from fecha_subida_nivel) = extract(year from current_date) "
			+ "and extract(month from fecha_subida_nivel) = extract(month from current_date) ")
	public List<Operario> findCortadorYConfeccion() throws Exception;
	
	@Update("UPDATE t_operario SET puntaje_obtenido=#{puntaje_obtenido}, puntaje_acumulado=#{puntaje_acumulado}, id_nivel=#{id_nivel}, fecha_subida_nivel=#{fecha_subida_nivel} WHERE idoperario=#{idoperario}")
	public void updateOperario(Operario operario) throws Exception;
}
