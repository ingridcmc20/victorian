package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.OrdenTrabajo;

public interface OrdenTrabajoMapper {
	public List<OrdenTrabajo> findAll() throws Exception;
	
	public List<OrdenTrabajo> findAllByFechaEstadoYEntrega() throws Exception;	
	
	public void insert(OrdenTrabajo ordenTrabajo);
	
	public List<OrdenTrabajo> findByEtapa(Integer id_etapa) throws Exception;
	
	@Select("SELECT ot.id_orden_trabajo, ot.fecha_registro,cl.nombre_cliente,pr.descripcion as des_tipo_prenda,"+ 
				"tc.descripcion as des_tipo_confeccion, ot.fecha_entrega_orden, ot.fecha_entrega_pedido,"+ 
				"ot.id_prioridad, ot.id_pedido, ot.id_estado, pri.descripcion as des_prioridad,"+
				"ot.id_etapa, e.descripcion as des_etapa, otd.fecha_fin, otd.fecha_inicio "+
				"FROM victorian.t_orden_trabajo ot inner join victorian.t_pedido p on p.id_pedido=ot.id_pedido "+
				"inner join victorian.t_cliente cl on cl.idcliente=p.idcliente "+
				"inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "+
				"inner join victorian.t_tipo_confeccion tc on tc.id_tipoconfeccion=p.id_tipoconfeccion "+
				"inner join victorian.t_prioridad pri on pri.id_prioridad=ot.id_prioridad "+
				"inner join victorian.t_etapa e on e.id_etapa=ot.id_etapa "+
				"inner join victorian.t_estado es on es.id_estado=ot.id_estado "+
				"inner join victorian.t_orden_trabajo_detalle otd on otd.id_orden_trabajo=ot.id_orden_trabajo and otd.id_etapa=ot.id_etapa "+
				"inner join victorian.t_orden_trabajo_operario oto on oto.id_orden_trabajo=ot.id_orden_trabajo "+
				"WHERE	ot.id_estado in (4,5) and ot.id_etapa=#{id_etapa} and oto.id_operario=#{idUsuario} "+
				"ORDER BY ot.id_etapa desc, ot.fecha_entrega_orden desc")
	public List<OrdenTrabajo> findByEtapaYUsuario(@Param("id_etapa") Integer id_etapa, @Param("idUsuario") Integer idUsuario) throws Exception;
	
	@Update("UPDATE victorian.t_orden_trabajo SET id_estado=#{id_estado}, id_etapa=#{id_etapa} WHERE id_orden_trabajo=#{id_orden_trabajo}")
	public void updateEstadoYEtapa(OrdenTrabajo ordenTrabajo) throws Exception;
	
	@Update("UPDATE victorian.t_orden_trabajo SET id_estado=#{id_estado} WHERE id_orden_trabajo=#{id_orden_trabajo}")
	public void updateEstado(OrdenTrabajo ordenTrabajo) throws Exception;
	
	@Update("UPDATE victorian.t_orden_trabajo SET id_prioridad=#{id_prioridad} WHERE id_orden_trabajo=#{id_orden_trabajo}")
	public void update(OrdenTrabajo ordenTrabajo) throws Exception;
}
