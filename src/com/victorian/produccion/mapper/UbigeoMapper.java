package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Ubigeo;

public interface UbigeoMapper {

	
	@Select("select * from victorian.t_ubigeo order by sdepartamento asc ,sprovincia asc,sdistrito asc")
	public List<Ubigeo> findAll() throws Exception;
	
	@Select("select distinct sdepartamento from victorian.t_ubigeo order by sdepartamento asc")
	public List<Ubigeo> listarDepartamentos();
	
	@Select("select distinct sprovincia from victorian.t_ubigeo where sdepartamento= #{sdepartamento} order by sprovincia asc;")
	public List<Ubigeo> listarProvincias(String sdepartamento);
	
	@Select("select * from victorian.t_ubigeo where sprovincia= #{sprovincia} and sdepartamento= #{sdepartamento} order by sdistrito asc")
	public List<Ubigeo> listardistritos(@Param("sdepartamento") String sdepartamento,@Param("sprovincia") String sprovincia);
	
	@Select("Select * from victorian.t_ubigeo where sid_ubigeo = #{sid_ubigeo} ")
	public Ubigeo obtenerUbigeoById(@Param("sid_ubigeo") Integer sid_ubigeo);
	
	@Select("select * from victorian.t_ubigeo where sprovincia= #{sprovincia} order by sdistrito asc")
	public List<Ubigeo> listardistritosByProvincia(@Param("sprovincia") String sprovincia);
	
}
