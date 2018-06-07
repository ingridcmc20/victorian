package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.mapper.ModoPagoMapper;

public class ModoPagoServices implements ModoPagoMapper {
	ModoPagoMapper modoPagoMapper = (ModoPagoMapper)ServiceFinder.findBean("modoPagoMapper");
}
