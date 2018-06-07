package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.Producto;
import com.victorian.produccion.mapper.ProductoMapper;

public class ProductoServices implements ProductoMapper{
	
	ProductoMapper productoMapper = (ProductoMapper)ServiceFinder.findBean("productoMapper");

	@Override
	public Producto findById(Integer codigoProducto) throws Exception {
		return productoMapper.findById(codigoProducto);
	}

	@Override
	public List<Producto> findAll() throws Exception {		
		return productoMapper.findAll();
	}

	@Override
	public List<Producto> listaProductosActivo() throws Exception {		
		return productoMapper.listaProductosActivo();
	}


	@Override
	public List<Producto> listaProductosPorNegocio(Integer negocioId)
			throws Exception {
		return productoMapper.listaProductosPorNegocio(negocioId);
	}
	
	@Override
	public void crearProducto(Producto producto) throws Exception {		
		productoMapper.crearProducto(producto);
	}

	@Override
	public void actualizarProducto(Producto producto)
			throws Exception {
		productoMapper.actualizarProducto(producto);
	}

	@Override
	public void eliminarProducto(Integer id_producto) throws Exception {	
		productoMapper.eliminarProducto(id_producto);
	}
	

	@Override
	public Integer listProductoxNegocio(Integer id_negocio) throws Exception {
		// TODO Auto-generated method stub
		return productoMapper.listProductoxNegocio(id_negocio);
	}

	@Override
	public List<Producto> listSubProducto(Integer id_producto) throws Exception {
		// TODO Auto-generated method stub
		return productoMapper.listSubProducto(id_producto);
	}

	@Override
	public List<Producto> listaProductosxFormato(Integer idformato)
			throws Exception {
		return productoMapper.listaProductosxFormato(idformato);
	}

	@Override
	public List<Producto> buscarProductoByNegocio(Integer id_negocio)
			throws Exception {
		return this.productoMapper.buscarProductoByNegocio(id_negocio);
	}
	
	@Override
	public List<Producto> buscarProductoByNegocioByProducto(Integer id_negocio, Integer id_producto_padre)
			throws Exception {
		return this.productoMapper.buscarProductoByNegocioByProducto(id_negocio,id_producto_padre);
	}

	@Override
	public Producto buscarProductoByCodigoBanco(String codigo_banco,Integer id_negocio)
			throws Exception {
		// TODO Auto-generated method stub
		return productoMapper.buscarProductoByCodigoBanco(codigo_banco,id_negocio);
	}

	@Override
	public List<Producto> listProductoDistinctTablComision(Integer id_negocio)
			throws Exception {
		// TODO Auto-generated method stub
		return productoMapper.listProductoDistinctTablComision(id_negocio);
	}

	@Override
	public List<Producto> buscarProductoProgramacion(Integer id_negocio)
			throws Exception {
		// TODO Auto-generated method stub
		return productoMapper.buscarProductoProgramacion(id_negocio);
	}

	@Override
	public List<Producto> listaProductosGeneralesxNegocio(Integer negocioId)
			throws Exception {
		// TODO Auto-generated method stub
		return productoMapper.listaProductosGeneralesxNegocio(negocioId);
	}


}