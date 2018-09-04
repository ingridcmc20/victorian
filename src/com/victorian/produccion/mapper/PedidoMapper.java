package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Pedido;

public interface PedidoMapper {
	@Select("SELECT idpedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, modo_pago, fechapedido, "
			+ "fechaentrega, estadopedido, e.descripcion as des_estado, p.idtipoconfeccion, tc.descripcion as des_tipoconfeccion,"
			+ "c.nombre_cliente, m.descripcion as des_modo_pago "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.estadopedido "
			+ "inner join victorian.t_tipoconfeccion tc on tc.idtipoconfeccion=p.idtipoconfeccion "
			+ "inner join victorian.t_cliente c on c.idcliente=p.idcliente "
			+ "inner join victorian.t_modo_pago m on p.modo_pago=m.id_modo_pago "
			+ "order by c.nombre_cliente, fechapedido")
	public List<Pedido> findAll() throws Exception;

	@Select("SELECT idpedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, modo_pago, fechapedido, "
			+ "fechaentrega, estadopedido, e.descripcion as des_estado, p.idtipoconfeccion, tc.descripcion as des_tipoconfeccion,"
			+ "c.nombre_cliente, m.descripcion as des_modo_pago, "
			+ "(select count(idfichatecnica)>0 from victorian.t_fichatecnica where idproducto=tipo_prenda) bool_ficha_tecnica "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.estadopedido "
			+ "inner join victorian.t_tipoconfeccion tc on tc.idtipoconfeccion=p.idtipoconfeccion "
			+ "inner join victorian.t_cliente c on c.idcliente=p.idcliente "
			+ "inner join victorian.t_modo_pago m on p.modo_pago=m.id_modo_pago "
			+ "where p.estadopedido=#{estadopedido} and fechaentrega>=current_timestamp "
			+ "order by c.nombre_cliente, fechapedido")
	public List<Pedido> findByEstado(@Param("estadopedido") Integer estadopedido) throws Exception;
	
	@Select("SELECT idpedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, modo_pago, fechapedido, "
			+ "fechaentrega, estadopedido, e.descripcion as des_estado, p.idtipoconfeccion, tc.descripcion as des_tipoconfeccion "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.estadopedido "
			+ "inner join victorian.t_tipoconfeccion tc on tc.idtipoconfeccion=p.idtipoconfeccion "
			+ "order by estadopedido asc, fechaentrega desc")
	public List<Pedido> findAllByFechaEstadoYEntrega() throws Exception;
	
	@Insert("INSERT INTO victorian.t_pedido(tipo_prenda, cantidad_prenda, fechapedido, fechaentrega, estadopedido, idtipoconfeccion) "
			+ "VALUES (#{tipo_prenda}, #{cantidad_prenda}, #{fechapedido}, #{fechaentrega}, #{estadopedido}, #{idtipoconfeccion})")
	public void crearPedido(Pedido pedido) throws Exception;

	@Update("UPDATE victorian.t_pedido "
			+ "SET tipo_prenda=#{tipo_prenda}, cantidad_prenda=#{cantidad_prenda}, fechapedido=#{fechapedido}, "
			+ "fechaentrega=#{fechaentrega}, idtipoconfeccion=#{idtipoconfeccion},  estadopedido=#{estadopedido}"
			+ "WHERE idpedido=#{idpedido}")
	@Options(flushCache=true,useCache=true)
    public void actualizarPedido(Pedido pedido) throws Exception;
	
	@Select("SELECT distinct p.idpedido, p.tipo_prenda, p.cantidad_prenda, p.modo_pago, p.fechapedido, p.fechaentrega, p.estadopedido, p.idtipoconfeccion, p.idcliente "
			+ "FROM victorian.t_pedido p inner join victorian.t_plan_pedido pp on pp.idpedido=p.idpedido where idplan=#{idplan}")
	public List<Pedido> findByPlanProduccion(@Param("idplan") Integer idplan) throws Exception;
	
	@Select("SELECT idpedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, modo_pago, fechapedido, "
			+ "fechaentrega, estadopedido, e.descripcion as des_estado, p.idtipoconfeccion, tc.descripcion as des_tipoconfeccion,"
			+ "c.nombre_cliente, m.descripcion as des_modo_pago "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.estadopedido "
			+ "inner join victorian.t_tipoconfeccion tc on tc.idtipoconfeccion=p.idtipoconfeccion "
			+ "inner join victorian.t_cliente c on c.idcliente=p.idcliente "
			+ "inner join victorian.t_modo_pago m on p.modo_pago=m.id_modo_pago "
			+ "WHERE idpedido=#{idpedido} "
			+ "order by c.nombre_cliente, fechapedido")
	public Pedido findById(@Param("idpedido") Integer idpedido) throws Exception;
	
	@Select("SELECT idpedido, tipo_prenda,pr.descripcion as des_tipo_prenda, cantidad_prenda, modo_pago, fechapedido, "
			+ "fechaentrega, estadopedido, e.descripcion as des_estado, p.idtipoconfeccion, tc.descripcion as des_tipoconfeccion,"
			+ "c.nombre_cliente, m.descripcion as des_modo_pago "
			+ "FROM victorian.t_pedido p inner join victorian.t_producto pr on pr.id_producto=p.tipo_prenda "
			+ "inner join victorian.t_estado e on e.id_estado=p.estadopedido "
			+ "inner join victorian.t_tipoconfeccion tc on tc.idtipoconfeccion=p.idtipoconfeccion "
			+ "inner join victorian.t_cliente c on c.idcliente=p.idcliente "
			+ "inner join victorian.t_modo_pago m on p.modo_pago=m.id_modo_pago "
			+ "WHERE idpedido=#{idpedido} and p.estadopedido=#{estadopedido} "
			+ "order by c.nombre_cliente, fechapedido")
	public Pedido findByIdAndByEstado(@Param("idpedido") Integer idpedido, @Param("estadopedido") Integer estadopedido) throws Exception;
	
}
