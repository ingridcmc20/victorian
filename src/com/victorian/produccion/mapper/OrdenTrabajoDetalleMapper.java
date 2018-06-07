package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.OrdenTrabajoDetalle;

public interface OrdenTrabajoDetalleMapper {
	@Insert("INSERT INTO t_orden_trabajo_detalle(id_orden_trabajo, id_etapa, id_plan_produccion, fecha_fin, "
			+ "fecha_inicio, fecha_real_termino, id_prioridad) VALUES (#{id_orden_trabajo}, #{id_etapa}, "
			+ "#{id_plan_produccion}, #{fecha_fin}, #{fecha_inicio}, #{fecha_real_termino}, #{id_prioridad})")
	public void insert(OrdenTrabajoDetalle ordenTrabajoDetalle);
	
	@Select("SELECT id_orden_trabajo, id_etapa, id_plan_produccion, fecha_fin, fecha_inicio, fecha_real_termino, "
				+ "id_prioridad "
				+ "FROM t_orden_trabajo_detalle "
				+ "where id_orden_trabajo=#{id_orden_trabajo} and id_etapa=#{id_etapa}")
	public OrdenTrabajoDetalle findByIdOrdenByEstapa(@Param("id_orden_trabajo") Integer id_orden_trabajo, @Param("id_etapa") Integer id_etapa);
	
	@Update("UPDATE t_orden_trabajo_detalle SET fecha_real_termino=#{fecha_real_termino} WHERE id_orden_trabajo=#{id_orden_trabajo} and id_etapa=#{id_etapa}")
	public void updateFechaReal(OrdenTrabajoDetalle ordenTrabajoDetalle);
}
