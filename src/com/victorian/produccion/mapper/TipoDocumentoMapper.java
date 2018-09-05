package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.TipoDocumento;

public interface TipoDocumentoMapper {
	

	@Select("select * from victorian.t_tipodocumento e where e.id_tipodocumento = #{id_tipodocumento}")
	public TipoDocumento findById(@Param("id_tipodocumento") Integer id_tipodocumento) throws Exception;
	
	@Select("select * from victorian.t_tipodocumento")
	public List<TipoDocumento> findAll() throws Exception;
	
	@Select("select * from victorian.t_tipodocumento where activo = 'TRUE' order by descripcion asc")
	public List<TipoDocumento> listaTipoDocumentoActivo() throws Exception;
	
	@Insert("insert into victorian.t_tipodocumento (descripcion, activo) values (#{descripcion},#{activo})")
	public void crearTipoDocumento(TipoDocumento resultado) throws Exception;
	
	@Update("update victorian.t_tipodocumento set descripcion = #{descripcion}, activo = #{activo} where id_tipodocumento= #{id_tipodocumento}")
	@Options(flushCache=true,useCache=true)
    public void actualizarTipoDocumento(TipoDocumento tipodocumento) throws Exception;
	
	@Delete("delete  from victorian.t_tipodocumento  where id_tipodocumento = #{id_tipodocumento}")
	@Options(flushCache=true)
	public void eliminarTipoDocumento(@Param("id_tipodocumento") Integer id_tipodocumento) throws Exception;
	
	@Select("select * from victorian.t_tipodocumento e where e.descripcion = #{descripcion}")
	public TipoDocumento findByDescripcion(@Param("descripcion") String descripcion) throws Exception;
	
}
