package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.OrdenTrabajoDetalle;

public interface OrdenTrabajoDetalleMapper {
	@Insert("INSERT INTO victorian.t_orden_trabajo_detalle(id_ordentrabajo, id_etapa, fecha_fin, "
			+ "fecha_inicio, fecha_real_fin, id_estado) VALUES (#{id_ordentrabajo}, #{id_etapa}, "
			+ "#{fecha_fin}, #{fecha_inicio}, #{fecha_real_fin}, #{id_estado})")
	public void insert(OrdenTrabajoDetalle ordenTrabajoDetalle);
	
	@Select("SELECT id_ordentrabajo, id_etapa, id_plan_produccion, fecha_fin, fecha_inicio, fecha_real_termino, "
				+ "id_prioridad "
				+ "FROM victorian.t_orden_trabajo_detalle "
				+ "where id_ordentrabajo=#{id_ordentrabajo} and id_etapa=#{id_etapa}")
	public OrdenTrabajoDetalle findByIdOrdenByEstapa(@Param("id_ordentrabajo") Integer id_ordentrabajo, @Param("id_etapa") Integer id_etapa);
	
	@Update("UPDATE victorian.t_orden_trabajo_detalle SET fecha_real_termino=#{fecha_real_termino} WHERE id_ordentrabajo=#{id_ordentrabajo} and id_etapa=#{id_etapa}")
	public void updateFechaReal(OrdenTrabajoDetalle ordenTrabajoDetalle);
}
