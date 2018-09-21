package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Pedido;

public interface PedidoMapper {
	@Select("SELECT id_pedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, p.id_modo_pago modo_pago, fecha_registro as fechapedido, "
			+ "fecha_entrega, p.id_estado, e.descripcion as des_estado, p.id_tipoconfeccion, tc.descripcion as des_tipoconfeccion,"
			+ "c.nombre_cliente, m.descripcion as des_modo_pago "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.id_estado "
			+ "inner join victorian.t_tipo_confeccion tc on tc.id_tipoconfeccion=p.id_tipoconfeccion "
			+ "inner join victorian.t_cliente c on c.id_cliente=p.id_cliente "
			+ "inner join victorian.t_modo_pago m on m.id_modo_pago=p.id_modo_pago "
			+ "order by c.nombre_cliente, fecha_registro")
	public List<Pedido> findAll() throws Exception;
		
	@Select("SELECT p.id_pedido, p.tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, p.id_modo_pago modo_pago, p.fecha_registro fechapedido, "
			+ "p.fecha_entrega, p.id_estado, e.descripcion as des_estado, p.id_tipoconfeccion, tc.descripcion as des_tipoconfeccion, "
			+ "c.nombre_cliente, m.descripcion as des_modo_pago, "
			+ "(select count(id_fichatecnica)>0 from victorian.t_fichatecnica where id_producto=p.tipo_prenda) bool_ficha_tecnica "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.id_estado "
			+ "inner join victorian.t_tipo_confeccion tc on tc.id_tipoconfeccion=p.id_tipoconfeccion "
			+ "inner join victorian.t_cliente c on c.id_cliente=p.id_cliente "
			+ "inner join victorian.t_modo_pago m on p.id_modo_pago=m.id_modo_pago "
			+ "where p.id_estado=#{id_estado} and p.fecha_entrega>=current_timestamp "
			+ "order by c.nombre_cliente, p.fecha_registro")
	public List<Pedido> findByEstado(@Param("id_estado") Integer id_estado) throws Exception;
	
	@Select("SELECT id_pedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, p.id_modo_pago modo_pago, fecha_registro as fechapedido, "
			+ "fecha_entrega, p.id_estado, e.descripcion as des_estado, p.id_tipoconfeccion, tc.descripcion as des_tipoconfeccion "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.id_estado "
			+ "inner join victorian.t_tipo_confeccion tc on tc.id_tipoconfeccion=p.id_tipoconfeccion "
			+ "order by p.id_estado asc, fecha_entrega desc")
	public List<Pedido> findAllByFechaEstadoYEntrega() throws Exception;
	
	@Insert("INSERT INTO victorian.t_pedido(tipo_prenda, cantidad_prenda, fecha_registro, fecha_entrega, id_estado, id_tipoconfeccion) "
			+ "VALUES (#{tipo_prenda}, #{cantidad_prenda}, #{fechapedido}, #{fecha_entrega}, #{id_estado}, #{id_tipoconfeccion})")
	public void crearPedido(Pedido pedido) throws Exception;

	@Update("UPDATE victorian.t_pedido "
			+ "SET tipo_prenda=#{tipo_prenda}, cantidad_prenda=#{cantidad_prenda}, fecha_registro=#{fechapedido}, "
			+ "fecha_entrega=#{fecha_entrega}, id_tipoconfeccion=#{id_tipoconfeccion},  id_estado=#{id_estado}, "
			+ "id_planproduccion=#{id_planproduccion} "
			+ "WHERE id_pedido=#{id_pedido}")
	@Options(flushCache=true,useCache=true)
    public void actualizarPedido(Pedido pedido) throws Exception;
	
	@Select("SELECT distinct p.id_pedido, p.tipo_prenda, p.cantidad_prenda, p.id_modo_pago, p.fecha_registro as fechapedido, p.fecha_entrega, p.id_estado, p.id_tipoconfeccion, p.id_cliente, pp.id_planproduccion "
			+ "FROM victorian.t_pedido p inner join victorian.t_plan_produccion pp on pp.id_planproduccion=p.id_planproduccion where pp.id_planproduccion=#{id_planproduccion}")
	public List<Pedido> findByPlanProduccion(@Param("id_planproduccion") Integer idplan) throws Exception;
	
	@Select("SELECT id_pedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, p.id_modo_pago modo_pago, fecha_registro as fechapedido, "
			+ "fecha_entrega, p.id_estado, e.descripcion as des_estado, p.id_tipoconfeccion, tc.descripcion as des_tipoconfeccion,"
			+ "c.nombre_cliente, m.descripcion as des_modo_pago "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.id_estado "
			+ "inner join victorian.t_tipo_confeccion tc on tc.id_tipoconfeccion=p.id_tipoconfeccion "
			+ "inner join victorian.t_cliente c on c.id_cliente=p.id_cliente "
			+ "inner join victorian.t_modo_pago m on p.id_modo_pago=m.id_modo_pago "
			+ "WHERE id_pedido=#{id_pedido} "
			+ "order by c.nombre_cliente, fecha_registro")
	public Pedido findById(@Param("id_pedido") Integer id_pedido) throws Exception;
	
	@Select("SELECT p.id_pedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, p.id_modo_pago modo_pago, p.fecha_registro as fechapedido, "
			+ "fecha_entrega, p.id_estado, e.descripcion as des_estado, p.id_tipoconfeccion, tc.descripcion as des_tipoconfeccion,"
			+ "c.nombre_cliente, m.descripcion as des_modo_pago, pp.id_planproduccion "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.id_estado "
			+ "inner join victorian.t_tipo_confeccion tc on tc.id_tipoconfeccion=p.id_tipoconfeccion "
			+ "inner join victorian.t_cliente c on c.id_cliente=p.id_cliente "
			+ "inner join victorian.t_modo_pago m on p.id_modo_pago=m.id_modo_pago "
			+ "inner join victorian.t_plan_produccion pp on pp.id_planproduccion=p.id_planproduccion "
			+ "WHERE p.id_pedido=#{id_pedido} and pp.id_estado=#{id_estado} "
			+ "order by c.nombre_cliente, p.fecha_registro")
	public Pedido findByIdAndByEstado(@Param("id_pedido") Integer id_pedido, @Param("id_estado") Integer id_estado) throws Exception;
	
}
