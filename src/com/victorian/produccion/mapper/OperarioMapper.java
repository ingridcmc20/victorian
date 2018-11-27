package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Operario;
import com.victorian.produccion.domain.OrdenTrabajoOperario;

public interface OperarioMapper {

	@Select("SELECT o.id_operario, o.id_tipooperario, u.apellido_paterno || ' ' || u.apellido_materno || ' ' "
			+ "|| u.nombre as nombre_operario,o.puntaje_acumulado FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_usuario "
			+ "where id_tipooperario=#{id_tipooperario}")
	public List<Operario> findByEstado(@Param("id_tipooperario") Integer id_tipooperario) throws Exception;

	@Select("SELECT o.id_operario, o.id_tipooperario, u.apellido_paterno || ' ' || u.apellido_materno || ' ' "
			+ "|| u.nombre as nombre_operario,o.puntaje_acumulado FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_usuario "
			+ "where id_tipooperario=#{id_tipooperario} and o.id_operario not in (select x.id_operario from victorian.t_ordentrabajo_operario x inner join victorian.t_orden_trabajo y on y.id_ordentrabajo=x.id_ordentrabajo where y.id_estado not in (7,8))")
	public List<Operario> findByEstadoDisponible(@Param("id_tipooperario") Integer id_tipooperario) throws Exception;

	@Select("SELECT o.id_operario, o.id_tipooperario, u.apellido_paterno || ' ' || u.apellido_materno || ' ' || u.nombre as nombre_operario,"
			+ "case when o.puntaje_acumulado <5 then 1 when o.puntaje_acumulado <10 then 2 when o.puntaje_acumulado <15 then 3 when o.puntaje_acumulado <20 then 4 "
			+ "when o.puntaje_acumulado >=20 then 5 end id_nivel,o.puntaje_acumulado "
			+ "FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_usuario "
			+ "where o.id_operario=#{id_operario}")
	public Operario findById(@Param("id_operario") Integer id_operario) throws Exception;

	@Select("SELECT o.id_operario||'' as id_operario "
			+ "FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_usuario inner join victorian.t_ordentrabajo_operario oto on oto.id_operario=o.id_operario "
			+ "where id_tipooperario=#{id_tipooperario} and id_ordentrabajo=#{id_ordentrabajo}")
	public List<String> findByTipoAndByIdOrden(@Param("id_tipooperario") Integer id_tipooperario,
			@Param("id_ordentrabajo") Integer id_ordentrabajo) throws Exception;

	@Select("SELECT o.id_operario, u.apellido_paterno || ' ' || u.apellido_materno || ', ' || u.nombre as nombre_operario, o.id_tipooperario, oto.id_nivel "
			+ "FROM victorian.t_operario o inner join victorian.t_usuario u on u.id_usuario=o.id_usuario inner join victorian.t_ordentrabajo_operario oto on oto.id_operario=o.id_operario "
			+ "inner join victorian.t_orden_trabajo_detalle otd on otd.id_ordentrabajo=oto.id_ordentrabajo and otd.id_etapa=oto.id_etapa "
			+ "where id_tipooperario in (2,3) and extract(year from fecha_nivel) = extract(year from current_date) "
			+ "and extract(month from fecha_nivel) = extract(month from current_date) ")
	public List<Operario> findCortadorYConfeccion() throws Exception;

	@Update("UPDATE victorian.t_operario SET puntaje_acumulado=#{puntaje_acumulado} WHERE id_operario=#{id_operario}")
	public void updateOperario(Operario operario) throws Exception;
}

