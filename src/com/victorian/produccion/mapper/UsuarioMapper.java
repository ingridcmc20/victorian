package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Usuario;

public interface UsuarioMapper {
	public List<Usuario> getlistaUsuario();

	public List<Usuario> buscarPorLoginClave(Usuario usuario);

	public Usuario buscarPorId(int idusuario);

	public void insertUsuario(Usuario usuario);

	public void actualizarEstado(Usuario usuario) throws Exception;

	public void actualizar(Usuario usuario);

	public void actualizarPassword(Usuario usuario);

	public void actualizarFechaAcceso(Usuario usuario);

	public Usuario buscarPorLogin(String string) throws Exception;

	@Select("select * from t_usuario where dni =#{dni}")
	public Usuario buscarPorDni(@Param("dni") String dni) throws Exception;

	public void deleteUsuario(Integer idusuario) throws Exception;

	@Update("update t_usuario set password = #{login} where idusuario = #{idusuario}")
	public void resetearPassword(Usuario usuario) throws Exception;

	@Select("select * from t_usuario where idusuario =  #{idusuario}")
	public Usuario getUsuario_byIdUsuario(Integer idusuario);
	
}
