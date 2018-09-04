package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Perfil;
import com.victorian.produccion.domain.UsuarioPerfil;


public interface UsuarioPerfilMapper {
	
	public List<UsuarioPerfil> listarPerfilesPorUsuario(Integer usuarioId) throws Exception;
	
	public void insertUsuarioPeril(UsuarioPerfil usuarioPerfil) throws Exception;
	
	@Select("select * from victorian.t_usuarioxperfil p where p.idusuario = #{p_usuarioId} and p.cod_perfil = #{p_perfilId}")
	public UsuarioPerfil buscarPerfilUsuario(@Param("p_usuarioId") Integer idusuario,@Param("p_perfilId") Integer idperfil) throws Exception;
	
	@Delete("delete  from victorian.t_usuarioxperfil  where idusuario = #{p_usuarioId} and cod_perfil = #{p_perfilId}")
	@Options(flushCache=true)
	public void eliminarPerfilUsuario(@Param("p_usuarioId") Integer idusuario,@Param("p_perfilId") Integer idperfil) throws Exception;
	
	@Select("select p.cod_perfil, p.descripcion, p.proceso from victorian.t_usuarioxperfil u inner join victorian.t_perfil p on u.cod_perfil = p.cod_perfil  where idusuario = #{idusuario}")
	public List<Perfil> obtenerPerfilxUsuario(@Param("idusuario") Integer idusuario )throws Exception;
	
}

	
	

	


