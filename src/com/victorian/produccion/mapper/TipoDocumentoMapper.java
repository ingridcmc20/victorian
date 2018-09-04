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
	

	@Select("select * from victorian.t_tipo_documento e where e.id_tipo_documento = #{p_id_tipo_documento}")
	public TipoDocumento findById(@Param("p_id_tipo_documento") Integer codigoEstado) throws Exception;
	
	@Select("select * from victorian.t_tipo_documento")
	public List<TipoDocumento> findAll() throws Exception;
	
	@Select("select * from victorian.t_tipo_documento where estado = 'TRUE' order by descripcion asc")
	public List<TipoDocumento> listaTipoDocumentoActivo() throws Exception;
	
	@Insert("insert into victorian.t_tipo_documento (descripcion, estado) values (#{descripcion},#{estado})")
	public void crearTipoDocumento(TipoDocumento resultado) throws Exception;
	
	@Update("update victorian.t_tipo_documento set descripcion = #{descripcion}, estado = #{estado} where id_tipo_documento= #{id_tipo_documento}")
	@Options(flushCache=true,useCache=true)
    public void actualizarTipoDocumento(TipoDocumento tipodocumento) throws Exception;
	
	@Delete("delete  from victorian.t_tipo_documento  where id_tipo_documento = #{id_tipo_documento}")
	@Options(flushCache=true)
	public void eliminarTipoDocumento(@Param("id_tipo_documento") Integer id_tipo_documento) throws Exception;
	
	@Select("select * from victorian.t_tipo_documento e where e.descripcion = #{descripcion}")
	public TipoDocumento findByDescripcion(@Param("descripcion") String descripcion) throws Exception;
	
}
