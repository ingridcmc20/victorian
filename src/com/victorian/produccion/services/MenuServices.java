package com.victorian.produccion.services; 

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Menu;
import com.victorian.produccion.domain.Perfil;
import com.victorian.produccion.domain.Sistema;
import com.victorian.produccion.mapper.MenuMapper;

public class MenuServices implements MenuMapper{

	MenuMapper menuMapper = (MenuMapper)ServiceFinder.findBean("menuMapper");

	public List<Menu> listMenu() throws Exception{
	    return menuMapper.listMenu();
	}

	public void deleteMenu(Menu menu)  throws Exception{
	    menuMapper.deleteMenu(menu);
	}

	public void updateMenu(Menu menu) throws Exception{
	    menuMapper.updateMenu(menu);
	}

	public void insertMenu(Menu menu) throws Exception{
	    menuMapper.insertMenu(menu);
	}

	public Menu findMenu(int id)  throws Exception{
	    return menuMapper.findMenu(id);
	}
	
	public Menu findMenuxNombre(String nombreMenu)  throws Exception{
	    return menuMapper.findMenuxNombre(nombreMenu);
	}


	public List<Menu>  findMenus(Menu menu)  throws Exception{
	    return menuMapper.findMenus(menu);
	}
	
	public List<Menu> listMenuxSistema(Perfil perfil) throws Exception{
	    return menuMapper.listMenuxSistema(perfil);
	}
	
	//ww
	@Override
	public List<Menu> listMenuxSistemaId(Long sistemaid)	throws Exception {
		return menuMapper.listMenuxSistemaId(sistemaid);
	}
	
	//ww
	@Override
	public List<Sistema> listSistemas() throws Exception {
		return menuMapper.listSistemas();
	}
	
	
	@Override
	public int opcionMenuByPrettyCod(String pretty) throws Exception {
		// TODO Auto-generated method stub
		return menuMapper.opcionMenuByPrettyCod(pretty); 
	}

	@Override
	public Menu opcionMenuByPretty(String pretty) throws Exception {
		// TODO Auto-generated method stub
		return menuMapper.opcionMenuByPretty(pretty);
	}

} 
