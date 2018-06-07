package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.ProductoInsumo;
import com.victorian.produccion.mapper.ProductoInsumoMapper;

public class ProductoInsumoService implements ProductoInsumoMapper{
	
	ProductoInsumoMapper productoInsumoMapper = (ProductoInsumoMapper) ServiceFinder.findBean("productoInsumoMapper");
	
	@Override
	public void insert(ProductoInsumo productoInsumo) throws Exception {
		// TODO Auto-generated method stub
		productoInsumoMapper.insert(productoInsumo);
	}

	@Override
	public void delete(ProductoInsumo productoInsumo) throws Exception {
		// TODO Auto-generated method stub
		productoInsumoMapper.delete(productoInsumo);
	}

}
