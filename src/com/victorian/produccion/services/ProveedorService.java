package com.victorian.produccion.services;

import java.util.List;

import com.victorian.produccion.domain.Proveedor;
import com.victorian.produccion.mapper.ProveedorMapper;
import com.pe.victorian.produccion.commons.ServiceFinder;

public class ProveedorService implements ProveedorMapper{

	ProveedorMapper proveedorMapper = (ProveedorMapper)ServiceFinder.findBean("proveedorMapper");

	@Override
	public List<Proveedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return proveedorMapper.findAll();
	}

	@Override
	public void crearProveedor(Proveedor proveedor) throws Exception {
		// TODO Auto-generated method stub
		proveedorMapper.crearProveedor(proveedor);
	}

	@Override
	public void actualizarProveedor(Proveedor proveedor) throws Exception {
		// TODO Auto-generated method stub
		proveedorMapper.actualizarProveedor(proveedor);
	}

	@Override
	public void eliminarProveedor(Integer id_proveedor) throws Exception {
		// TODO Auto-generated method stub
		proveedorMapper.eliminarProveedor(id_proveedor);
	}

	
	

}
