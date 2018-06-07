package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.TipoMoneda;

public interface TipoMonedaMapper {

	@Select("select * from t_tipo_moneda e where e.id_tipo_moneda = #{p_id_tipo_moneda}")
	public TipoMoneda findById(@Param("p_id_tipo_moneda") Integer codigoEstado) throws Exception;
	
	@Select("select * from t_tipo_moneda")
	public List<TipoMoneda> findAll() throws Exception;
	
	@Select("select * from t_tipo_moneda where estado=#{estado}")
	public List<TipoMoneda> findByEstado(@Param("estado") boolean estado) throws Exception;
	
	@Insert("insert into t_tipo_moneda (descripcion, estado) values (#{descripcion},#{estado})")
	public void crearTipoMoneda(TipoMoneda resultado) throws Exception;
	
	@Update("update t_tipo_moneda set descripcion = #{descripcion}, estado = #{estado} where id_tipo_moneda= #{id_tipo_moneda}")
	@Options(flushCache=true,useCache=true)
    public void actualizarTipoMoneda(TipoMoneda tipomoneda) throws Exception;
	
	@Delete("delete  from t_tipo_moneda  where id_tipo_moneda = #{id_tipo_moneda}")
	@Options(flushCache=true)
	public void eliminarTipoMoneda(@Param("id_tipo_moneda") Integer id_tipo_moneda) throws Exception;
}
