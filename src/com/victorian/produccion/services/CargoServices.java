package com.victorian.produccion.services;

import java.util.List;

import com.victorian.produccion.domain.Cargo;
import com.victorian.produccion.mapper.CargoMapper;
import com.pe.victorian.produccion.commons.ServiceFinder;

public class CargoServices implements CargoMapper {

	CargoMapper cargoMapper = (CargoMapper) ServiceFinder.findBean("cargoMapper");

	@Override
	public Cargo findById(Integer codigoCargo) throws Exception {
		return cargoMapper.findById(codigoCargo);
	}

	@Override
	public List<Cargo> findAll() throws Exception {
		return cargoMapper.findAll();
	}

	@Override
	public List<Cargo> listaCargosActivo() throws Exception {
		return cargoMapper.listaCargosActivo();
	}

	@Override
	public void crearCargo(Cargo cargo) throws Exception {
		cargoMapper.crearCargo(cargo);
	}

	@Override
	public void actualizarCargo(Cargo cargo) throws Exception {
		cargoMapper.actualizarCargo(cargo);
	}

	@Override
	public void eliminarCargo(Integer id_cargo) throws Exception {
		cargoMapper.eliminarCargo(id_cargo);
	}
}
