package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.PlanProduccion;

public interface PlanProduccionMapper {

	public void insert(PlanProduccion planProduccion) throws Exception;

	@Update("UPDATE victorian.t_plan_produccion SET estado=#{estado} WHERE idplan=#{idplan}")
	@Options(flushCache=true,useCache=true)
	public void update(PlanProduccion p);
	
	@Select("SELECT id_planproduccion, fecha_inicioplan, fecha_finplan, cantidad_operarios, cantidad_maquinaria, id_estado FROM victorian.t_plan_produccion where id_estado=#{id_estado}")
	public List<PlanProduccion> findByEstado(@Param("id_estado") Integer estado);
	
	@Select("SELECT id_planproduccion, fecha_inicioplan, fecha_finplan, cantidad_operarios, cantidad_maquinaria, id_estado FROM victorian.t_plan_produccion where id_planproduccion=#{id_planproduccion}")
	public PlanProduccion findById(@Param("id_planproduccion") Integer id_planproduccion);
}
