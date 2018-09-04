package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.PlanPedido;

public interface PlanPedidoMapper {
	@Insert("INSERT INTO victorian.t_plan_pedido(idplan, idpedido, idfichatecnica, fechainicio, fechafin, estado) "
			+ "VALUES (#{idplan}, #{idpedido}, #{idfichatecnica}, #{fechainicio}, #{fechafin}, #{estado})")
	public void insert(PlanPedido planPedido) throws Exception;
	
	@Select("SELECT idplan, idpedido, idfichatecnica, fechainicio, fechafin, estado FROM victorian.t_plan_pedido "
			+ "where idpedido=#{idpedido}")
	public PlanPedido findByPedido(Integer idpedido) throws Exception;
	
	@Select("SELECT DISTINCT idplan, idpedido FROM victorian.t_plan_pedido where idpedido=#{idpedido}")
	public PlanPedido findByPedidoSinFicha(Integer idpedido) throws Exception;
}
