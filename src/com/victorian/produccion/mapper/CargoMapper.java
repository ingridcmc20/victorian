package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Cargo;


public interface CargoMapper {
	@Select("select * from victorian.t_cargo e where e.id_cargo = #{p_cargo}")
	public Cargo findById(@Param("p_cargo") Integer codigoCargo) throws Exception;
	
	@Select("select * from victorian.t_cargo order by descripcion asc")
	public List<Cargo> findAll() throws Exception;
	
	@Select("select * from victorian.t_cargo where activo = 'TRUE' order by descripcion asc")
	public List<Cargo> listaCargosActivo() throws Exception;
	
	@Insert("insert into victorian.t_cargo (descripcion, activo) values (#{descripcion},#{activo})")
	public void crearCargo(Cargo cargo) throws Exception;
	
	@Update("update victorian.t_cargo set descripcion = #{descripcion}, activo = #{activo} where id_cargo= #{id_cargo}")
	@Options(flushCache=true,useCache=true)
    public void actualizarCargo(Cargo cargo) throws Exception;
	
	@Delete("delete  from victorian.t_cargo  where id_cargo = #{id_cargo}")
	@Options(flushCache=true)
	public void eliminarCargo(@Param("id_cargo") Integer id_cargo) throws Exception;
	
}
