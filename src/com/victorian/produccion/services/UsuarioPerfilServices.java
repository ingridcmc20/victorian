package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Perfil;
import com.victorian.produccion.domain.UsuarioPerfil;
import com.victorian.produccion.mapper.UsuarioPerfilMapper;

public class UsuarioPerfilServices implements UsuarioPerfilMapper{

	UsuarioPerfilMapper usuarioPerfilMapper = (UsuarioPerfilMapper)ServiceFinder.findBean("usuarioPerfilMapper");

	@Override
	public List<UsuarioPerfil> listarPerfilesPorUsuario(Integer usuarioId)
			throws Exception {
		// TODO Auto-generated method stub
		return usuarioPerfilMapper.listarPerfilesPorUsuario(usuarioId);
	}

	@Override
	public UsuarioPerfil buscarPerfilUsuario(Integer idusuario,Integer idperfil) throws Exception {
		return usuarioPerfilMapper.buscarPerfilUsuario(idusuario, idperfil);
	}

	@Override
	public void eliminarPerfilUsuario(Integer idusuario, Integer idperfil) throws Exception {
		usuarioPerfilMapper.eliminarPerfilUsuario(idusuario, idperfil);
	}

	@Override
	public void insertUsuarioPeril(UsuarioPerfil usuarioPerfil) throws Exception{
		usuarioPerfilMapper.insertUsuarioPeril(usuarioPerfil);
	}

	@Override
	public List<Perfil> obtenerPerfilxUsuario(Integer idusuario) throws Exception {
		// TODO Auto-generated method stub
		return usuarioPerfilMapper.obtenerPerfilxUsuario(idusuario);
	}

}
