package com.victorian.produccion.services;

import java.util.List;

import com.victorian.produccion.domain.Empresa;
import com.victorian.produccion.mapper.EmpresaMapper;
import com.pe.victorian.produccion.commons.ServiceFinder;

public class EmpresaService implements EmpresaMapper{

	EmpresaMapper empresaMapper = (EmpresaMapper)ServiceFinder.findBean("empresaMapper");

	@Override
	public Empresa findById(Integer codigoEstado) throws Exception {
		return empresaMapper.findById(codigoEstado);
	}

	@Override
	public List<Empresa> findAll() throws Exception {
		return empresaMapper.findAll();
	}

	@Override
	public void crearEmpresa(Empresa resultado) throws Exception {
		empresaMapper.crearEmpresa(resultado);
	}

	@Override
	public void actualizarEmpresa(Empresa empresa)
			throws Exception {
		empresaMapper.actualizarEmpresa(empresa);
	}

	@Override
	public void eliminarEmpresa(Integer id_empresa)
			throws Exception {
		empresaMapper.eliminarEmpresa(id_empresa);
	}

	@Override
	public List<Empresa> listaEmpresasActivas() throws Exception {
		return empresaMapper.listaEmpresasActivas();
	}
	//no elimina Empresa asociado a un Proyecto
	@Override
	public Integer listProyectoxEmpresa(Integer id_empresa) 
			throws Exception {		
		return empresaMapper.listProyectoxEmpresa(id_empresa);
	}
	
	

}
