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
	
	@Select("SELECT idplan, fechainicioplan, fechafinplan, cantidad_operarios, maquinaria, estado FROM victorian.t_plan_produccion where estado=#{estado}")
	public List<PlanProduccion> findByEstado(@Param("estado") String estado);
	
	@Select("SELECT idplan, fechainicioplan, fechafinplan, cantidad_operarios, maquinaria, estado FROM victorian.t_plan_produccion where idplan=#{idplan}")
	public PlanProduccion findById(@Param("idplan") Integer idplan);
}
