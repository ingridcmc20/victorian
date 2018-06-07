package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.FichaTecnica;

public interface FichaTecnicaMapper {
	@Select("SELECT idfichatecnica, nombreinsumo, unidad, cantidad, preciounidad, preciototal, idproducto, idinsumo FROM t_fichatecnica")
	public List<FichaTecnica> findAll() throws Exception;
	
	@Select("SELECT idfichatecnica, nombreinsumo, unidad, cantidad, preciounidad, preciototal, idproducto, f.idinsumo, i.descripcion nom_insumo FROM t_fichatecnica f inner join t_insumo i on i.idinsumo=f.idinsumo WHERE idproducto=#{idproducto}")
	public List<FichaTecnica> findByProducto(@Param("idproducto") Integer idproducto) throws Exception;

	@Insert("INSERT INTO t_fichatecnica(nombreinsumo, unidad, cantidad, preciounidad, preciototal, idproducto, idinsumo) "
			+ "VALUES (#{nombreinsumo}, #{unidad}, #{cantidad}, #{preciounidad}, #{preciototal}, #{idproducto}, #{idinsumo})")
	public void insert(FichaTecnica fichaTecnica) throws Exception;
	
	@Delete("delete from t_fichatecnica where idfichatecnica = #{idfichatecnica}")
	@Options(flushCache=true)
	public void delete(@Param("idfichatecnica") Integer idfichatecnica) throws Exception;
}
