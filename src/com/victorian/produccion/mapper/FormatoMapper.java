package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Formato;


public interface FormatoMapper {

	@Select("select * from victorian.t_formato e where e.idformato = #{idformato}")
	public Formato findById(@Param("idformato") Integer idformato) throws Exception;
	
	@Select("select * from victorian.t_formato")
	public List<Formato> findAll() throws Exception;	
	
	@Insert("insert into victorian.t_formato (codigo, estado) values (#{codigo},#{estado})")
	public void crearFormato(Formato formato) throws Exception;
	
	@Update("update victorian.t_formato set codigo = #{codigo}, estado = #{estado} where idformato= #{idformato}")
	@Options(flushCache=true,useCache=true)
    public void actualizarFormato(Formato formato) throws Exception;
	
	//no se puede borrar asi esta mal porque tiene foraneas
	@Delete("delete from victorian.t_formato where idformato = #{idformato}")
	@Options(flushCache=true)
	public void eliminarFormato(@Param("idformato") Integer idformato) throws Exception;
	
	@Select("select f.codigo from victorian.t_formato f inner join t_producto p on p.idformato = f.idformato where id_producto =  #{id_producto}")
	public List<Formato> listFormatoxProducto(@Param("id_producto") Integer id_producto) throws Exception;
		
	
	
}
