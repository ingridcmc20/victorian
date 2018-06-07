package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.EstadoCivil;

public interface EstadoCivilMapper {
	

	@Select("select * from t_estado_civil e where e.id_estado_civil = #{p_id_estado_civil}")
	public EstadoCivil findById(@Param("p_id_estado_civil") Integer codigoEstado) throws Exception;
	
	@Select("select * from t_estado_civil")
	public List<EstadoCivil> findAll() throws Exception;
		
	@Insert("insert into t_estado_civil (descripcion) values (#{descripcion})")
	public void crearEstadoCivil(EstadoCivil resultado) throws Exception;
	
	@Update("update t_estado_civil set descripcion = #{descripcion} where id_estado_civil= #{id_estado_civil}")
	@Options(flushCache=true,useCache=true)
    public void actualizarEstadoCivil(EstadoCivil estadocivil) throws Exception;
	
	@Delete("delete from t_estado_civil  where id_estado_civil = #{id_estado_civil}")
	@Options(flushCache=true)
	public void eliminarEstadoCivil(@Param("id_estado_civil") Integer id_estado_civil) throws Exception;	
}
