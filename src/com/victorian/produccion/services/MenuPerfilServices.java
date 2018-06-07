package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.MenuXPerfil;
import com.victorian.produccion.mapper.MenuPerfilMapper;

public class MenuPerfilServices implements MenuPerfilMapper{

	MenuPerfilMapper menuPerfilMapper = (MenuPerfilMapper)ServiceFinder.findBean("menuPerfilMapper");
	
	//busca
	@Override
	public MenuXPerfil buscarMenuPerfil(Long idMenu, Integer idPerfil) throws Exception {
		return menuPerfilMapper.buscarMenuPerfil(idMenu, idPerfil);
	}

	@Override
	public void crearMenuPerfil(Long idMenu, Integer idperfil, Boolean activo) throws Exception {
		menuPerfilMapper.crearMenuPerfil(idMenu, idperfil, activo);
	}

	@Override
	public void eliminarPerfilUsuario(Long idMenu,Integer idperfil) throws Exception {
		
		menuPerfilMapper.eliminarPerfilUsuario(idMenu, idperfil);
		
	}



}
