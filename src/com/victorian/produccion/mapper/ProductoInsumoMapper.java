package com.victorian.produccion.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.victorian.produccion.domain.ProductoInsumo;

public interface ProductoInsumoMapper {
	@Insert("INSERT INTO victorian.t_producto_insumo(idproducto, idinsumo) VALUES (#{idproducto}, #{idinsumo})")
	public void insert(ProductoInsumo productoInsumo) throws Exception;
	
	@Delete("delete from victorian.t_producto_insumo where idproducto = #{idproducto} and idinsumo = #{idinsumo}")
	@Options(flushCache=true)
	public void delete(ProductoInsumo productoInsumo) throws Exception;
}
