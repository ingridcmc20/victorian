package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Proveedor;

public interface  ProveedorMapper {

	@Select("select * from victorian.t_proveedor order by id_proveedor asc")
	public List<Proveedor> findAll() throws Exception;
	
	@Insert("insert into victorian.t_proveedor (razon_social, ruc) "
			+ "values (#{razon_social},#{ruc})")
	public void crearProveedor(Proveedor proveedor) throws Exception;
	
	@Update("update victorian.t_proveedor set razon_social = #{razon_social}, ruc= #{ruc} where id_proveedor = #{id_proveedor}")
	@Options(flushCache=true,useCache=true)
    public void actualizarProveedor(Proveedor proveedor) throws Exception;
	
	@Delete("delete from victorian.t_proveedor where id_proveedor = #{p_id_proveedor}")
	@Options(flushCache=true)
	public void eliminarProveedor(@Param("p_id_proveedor") Integer id_proveedor) throws Exception;
	
}
