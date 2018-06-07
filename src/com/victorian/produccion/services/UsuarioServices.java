package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Usuario;
import com.victorian.produccion.mapper.UsuarioMapper;

public class UsuarioServices implements UsuarioMapper{

	UsuarioMapper usuarioMapper=(UsuarioMapper)ServiceFinder.findBean("usuarioMapper");

	@Override
	public List<Usuario> buscarPorLoginClave(Usuario usuario) {
		return usuarioMapper.buscarPorLoginClave(usuario);
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		usuarioMapper.insertUsuario(usuario);
	}

	@Override
	public List<Usuario> getlistaUsuario() {
		return usuarioMapper.getlistaUsuario();
	}
	
	@Override
	public Usuario buscarPorId(int idusuario) {
		return usuarioMapper.buscarPorId(idusuario);
	}


	@Override
	public void actualizarEstado(Usuario usuario) throws Exception {
		usuarioMapper.actualizarEstado(usuario);
	}

	@Override
	public void actualizar(Usuario usuario) {
		usuarioMapper.actualizar(usuario);
	}
	
	@Override
	public void actualizarPassword(Usuario usuario) {
		usuarioMapper.actualizarPassword(usuario);
	}
		
	@Override
	public void actualizarFechaAcceso(Usuario usuario) {
		usuarioMapper.actualizarFechaAcceso(usuario);
	}

	@Override
	public Usuario buscarPorLogin(String string) throws Exception {
		return usuarioMapper.buscarPorLogin(string);
	}
	
	@Override
	public void deleteUsuario(Integer idusuario) throws Exception {
		usuarioMapper.deleteUsuario(idusuario);
	}

	@Override
	public void resetearPassword(Usuario usuario) throws Exception {
		usuarioMapper.resetearPassword(usuario);
	}

	@Override
	public Usuario buscarPorDni(String string) throws Exception {
		return usuarioMapper.buscarPorDni(string);
	}

	@Override
	public Usuario getUsuario_byIdUsuario(Integer idusuario) {
		// TODO Auto-generated method stub
		return usuarioMapper.getUsuario_byIdUsuario(idusuario);
	}
}
