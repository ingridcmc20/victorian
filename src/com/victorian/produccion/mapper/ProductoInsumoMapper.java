package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.victorian.produccion.domain.ProductoInsumo;

public interface ProductoInsumoMapper {
	@Insert("INSERT INTO victorian.t_producto_insumo(id_producto, id_insumo) VALUES (#{id_producto}, #{id_insumo})")
	public void insert(ProductoInsumo productoInsumo) throws Exception;
	
	@Delete("delete from victorian.t_producto_insumo where id_producto = #{id_producto} and id_insumo = #{id_insumo}")
	@Options(flushCache=true)
	public void delete(ProductoInsumo productoInsumo) throws Exception;
}
