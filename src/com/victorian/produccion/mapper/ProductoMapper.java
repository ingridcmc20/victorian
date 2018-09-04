package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Producto;


public interface ProductoMapper {


	@Select("select e.*, e.codigo_banco as codigo_banco, e.id_negocio from victorian.t_producto e where e.id_producto = #{p_producto}")
	public Producto findById(@Param("p_producto") Integer codigoProducto) throws Exception;
	
	//asociar producto y negocio
	@Select("select pr.id_producto, pr.idformato, pr.estado, pr.descripcion, pr.codigo_banco as codigoBanco from victorian.t_producto pr order by descripcion asc")
	public List<Producto> findAll() throws Exception;	
	
	@Select("select * from victorian.t_producto where estado = 'TRUE' order by descripcion asc")
	public List<Producto> listaProductosActivo() throws Exception;
	
	@Select("select * from victorian.t_producto where id_negocio =  #{p_negocioId} and estado = 'TRUE' order by descripcion")//
	public List<Producto> listaProductosPorNegocio(@Param("p_negocioId") Integer negocioId) throws Exception;
	
	@Insert("insert into victorian.t_producto (id_negocio, descripcion, estado, codigo_banco) values (#{id_negocio},#{descripcion},#{estado}, #{codigoBanco})")
	public void crearProducto(Producto producto) throws Exception;
	
	@Update("update victorian.t_producto set id_negocio = #{id_negocio}, idformato = #{idformato}, descripcion = #{descripcion}, estado = #{estado}, codigo_banco=#{codigoBanco} where id_producto= #{id_producto}")
	@Options(flushCache=true,useCache=true)
    public void actualizarProducto(Producto producto) throws Exception;
	
	@Delete("delete from victorian.t_producto  where id_producto = #{id_producto}")
	@Options(flushCache=true)
	public void eliminarProducto(@Param("id_producto") Integer id_producto) throws Exception;	
	
	//No permite eliminar un Producto Asociado a un Negocio devuelve la cantidad de Negocio asociado
	@Select("select count(*) from victorian.t_producto where id_negocio =  #{id_negocio}")
	public Integer listProductoxNegocio(@Param("id_negocio") Integer id_negocio) throws Exception;	
	
	@Select("select * from victorian.t_producto where id_producto = #{id_producto}")
	public List<Producto> listSubProducto(@Param("id_producto") Integer id_producto) throws Exception;
	
	public List<Producto> listaProductosxFormato(@Param("idformato") Integer idformato) throws Exception;
	
	@Select("select * from victorian.t_producto where id_negocio=#{id_negocio}")
	public List<Producto>buscarProductoByNegocio(@Param("id_negocio") Integer id_negocio)throws Exception;
	
	@Select("select * from victorian.t_producto where id_negocio=#{id_negocio} and id_producto = idproducto_padre")
	public List<Producto>buscarProductoProgramacion(@Param("id_negocio") Integer id_negocio)throws Exception;
	
	@Select("select * from victorian.t_producto where id_negocio=#{p_id_negocio} and idproducto_padre = #{p_idproducto_padre} order by descripcion")
	public List<Producto>buscarProductoByNegocioByProducto(@Param("p_id_negocio") Integer id_negocio,@Param("p_idproducto_padre") Integer id_producto_padre)throws Exception;

	@Select("select t_producto.*, t_producto.codigo_banco as codigoBanco from victorian.t_producto where codigo_banco = #{codigo_banco} and id_negocio = #{id_negocio}" )
	public Producto buscarProductoByCodigoBanco(@Param("codigo_banco") String codigo_banco,@Param("id_negocio") Integer id_negocio) throws Exception;
	
	@Select("select distinct p.* from victorian.t_tablero_comisiones tc inner join victorian.t_producto p on tc.id_producto = p.id_producto where tc.id_negocio = #{id_negocio} " )
	public List<Producto> listProductoDistinctTablComision(@Param("id_negocio") Integer id_negocio) throws Exception;

	@Select("select  * from victorian.t_producto where id_producto  = idproducto_padre and id_negocio = #{p_negocioId} ")//
	public List<Producto> listaProductosGeneralesxNegocio(@Param("p_negocioId") Integer negocioId) throws Exception;
	
	
}