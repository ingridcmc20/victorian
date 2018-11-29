package com.victorian.produccion.services;

import java.util.List;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.domain.OrdenTrabajo;
import com.victorian.produccion.mapper.OrdenTrabajoMapper;

public class OrdenTrabajoServices implements OrdenTrabajoMapper {
	OrdenTrabajoMapper ordenTrabajoMapper = (OrdenTrabajoMapper) ServiceFinder.findBean("ordenTrabajoMapper");

	@Override
	public List<OrdenTrabajo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return ordenTrabajoMapper.findAll();
	}

	@Override
	public void insert(OrdenTrabajo ordenTrabajo) {
		// TODO Auto-generated method stub
		ordenTrabajoMapper.insert(ordenTrabajo);
	}

	@Override
	public List<OrdenTrabajo> findAllByFechaEstadoYEntrega() throws Exception {
		// TODO Auto-generated method stub
		return ordenTrabajoMapper.findAllByFechaEstadoYEntrega();
	}

	@Override
	public List<OrdenTrabajo> findByEtapa(Integer id_etapa) throws Exception {
		// TODO Auto-generated method stub
		return ordenTrabajoMapper.findByEtapa(id_etapa);
	}

	@Override
	public void updateEstadoYEtapa(OrdenTrabajo ordenTrabajo) throws Exception {
		// TODO Auto-generated method stub
		ordenTrabajoMapper.updateEstadoYEtapa(ordenTrabajo);
	}

	@Override
	public List<OrdenTrabajo> findByEtapaYUsuario(Integer id_etapa, Integer idUsuario) throws Exception {
		// TODO Auto-generated method stub
		return ordenTrabajoMapper.findByEtapaYUsuario(id_etapa, idUsuario);
	}

	@Override
	public void updateEstado(OrdenTrabajo ordenTrabajo) throws Exception {
		// TODO Auto-generated method stub
		ordenTrabajoMapper.updateEstado(ordenTrabajo);
	}

	@Override
	public void update(OrdenTrabajo ordenTrabajo) throws Exception {
		// TODO Auto-generated method stub
		ordenTrabajoMapper.update(ordenTrabajo);
	}

	@Override
	public OrdenTrabajo findById(Integer id_ordentrabajo) throws Exception {
		// TODO Auto-generated method stub
		return ordenTrabajoMapper.findById(id_ordentrabajo);
	}

}
