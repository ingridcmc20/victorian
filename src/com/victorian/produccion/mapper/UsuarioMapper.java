package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.Usuario;

public interface UsuarioMapper {
	public List<Usuario> getlistaUsuario();

	public List<Usuario> buscarPorLoginClave(Usuario usuario);

	public Usuario buscarPorId(int id_usuario);

	public void insertUsuario(Usuario usuario);

	public void actualizarEstado(Usuario usuario) throws Exception;

	public void actualizar(Usuario usuario);

	public void actualizarPassword(Usuario usuario);

	public void actualizarFechaAcceso(Usuario usuario);

	public Usuario buscarPorLogin(String string) throws Exception;

	@Select("select * from victorian.t_usuario where dni =#{dni}")
	public Usuario buscarPorDni(@Param("dni") String dni) throws Exception;

	public void deleteUsuario(Integer id_usuario) throws Exception;

	@Update("update victorian.t_usuario set password = #{login} where id_usuario = #{id_usuario}")
	public void resetearPassword(Usuario id_usuario) throws Exception;

	@Select("select * from victorian.t_usuario where id_usuario =  #{id_usuario}")
	public Usuario getUsuario_byIdUsuario(Integer id_usuario);
	
}
