package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Empresa;

public interface  EmpresaMapper {

	@Select("select * from victorian.t_empresa e where e.id_empresa = #{p_id_empresa}")
	public Empresa findById(@Param("p_id_empresa") Integer codigoEstado) throws Exception;
	
	@Select("select * from victorian.t_empresa")
	public List<Empresa> findAll() throws Exception;
	
	@Insert("insert into victorian.t_empresa (razon_social, ruc,  estado) values (#{razon_social},#{ruc},#{estado})")
	public void crearEmpresa(Empresa resultado) throws Exception;
	
	@Update("update victorian.t_empresa set razon_social = #{razon_social}, ruc = #{ruc},  estado = #{estado} where id_empresa= #{id_empresa}")
	@Options(flushCache=true,useCache=true)
    public void actualizarEmpresa(Empresa empresa) throws Exception;
	
	@Delete("delete from victorian.t_empresa  where id_empresa = #{id_empresa}")
	@Options(flushCache=true)
	public void eliminarEmpresa(@Param("id_empresa") Integer id_empresa) throws Exception;
	
	@Select("select * from victorian.t_empresa")
	public List<Empresa> listaEmpresasActivas()throws Exception;
		
	//No permite eliminar un Empresa Asociado a un Proyecto devuelve la cantidad de Empresa asociado
	@Select("select count(*) from t_centros_atencion where id_empresa =  #{id_empresa} ")	
	public Integer listProyectoxEmpresa(@Param("id_empresa") Integer id_empresa) throws Exception;	 
	
}
