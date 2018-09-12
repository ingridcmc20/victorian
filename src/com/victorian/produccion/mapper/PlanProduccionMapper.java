package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.PlanProduccion;

public interface PlanProduccionMapper {

	public void insert(PlanProduccion planProduccion) throws Exception;

	@Update("UPDATE victorian.t_plan_produccion SET id_estado=#{id_estado} WHERE id_planproduccion=#{id_planproduccion}")
	@Options(flushCache=true,useCache=true)
	public void update(PlanProduccion p);
	
	@Select("SELECT pp.id_planproduccion, pp.fecha_inicioplan, pp.fecha_finplan, pp.cantidad_operarios, pp.cantidad_maquinaria, "
			+ "pp.id_estado, e.descripcion as des_estado FROM victorian.t_plan_produccion pp inner join victorian.t_estado e "
			+ "on e.id_estado=pp.id_estado where pp.id_estado=#{id_estado}")
	public List<PlanProduccion> findByEstado(@Param("id_estado") Integer estado);
	
	@Select("SELECT pp.id_planproduccion, pp.fecha_inicioplan, pp.fecha_finplan, pp.cantidad_operarios, pp.cantidad_maquinaria, "
			+ "pp.id_estado, e.descripcion as des_estado FROM victorian.t_plan_produccion pp inner join victorian.t_estado e "
			+ "on e.id_estado=pp.id_estado where pp.id_planproduccion=#{id_planproduccion}")
	public PlanProduccion findById(@Param("id_planproduccion") Integer id_planproduccion);
}
