package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.FichaTecnica;

public interface FichaTecnicaMapper {
	@Select("SELECT ft.id_fichatecnica, (select i.descripcion from victorian.t_insumo i where i.id_insumo=ft.id_insumo) nombreinsumo, ft.unidad, ft.cantidad, ft.precio_unidad, ft.precio_total, ft.id_producto, ft.id_insumo FROM victorian.t_fichatecnica ft")
	public List<FichaTecnica> findAll() throws Exception;
	
	@Select("SELECT id_fichatecnica, i.descripcion as nombreinsumo, unidad, cantidad, precio_unidad, precio_total, id_producto, f.id_insumo  FROM victorian.t_fichatecnica f inner join victorian.t_insumo i on i.id_insumo=f.id_insumo WHERE id_producto=#{id_producto}")
	public List<FichaTecnica> findByProducto(@Param("id_producto") Integer id_producto) throws Exception;

	@Insert("INSERT INTO victorian.t_fichatecnica(unidad, cantidad, precio_unidad, precio_total, id_producto, id_insumo) "
			+ "VALUES (#{unidad}, #{cantidad}, #{precio_unidad}, #{precio_total}, #{id_producto}, #{id_insumo})")
	public void insert(FichaTecnica fichaTecnica) throws Exception;
	
	@Delete("delete from victorian.t_fichatecnica where id_fichatecnica = #{id_fichatecnica}")
	@Options(flushCache=true)
	public void delete(@Param("id_fichatecnica") Integer id_fichatecnica) throws Exception;
}
