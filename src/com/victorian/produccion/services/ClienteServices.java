package com.victorian.produccion.services;

import com.pe.victorian.produccion.commons.ServiceFinder;
import com.victorian.produccion.mapper.ClienteMapper;

public class ClienteServices implements ClienteMapper {
	ClienteMapper clienteMapper = (ClienteMapper)ServiceFinder.findBean("clienteMapper");
}
