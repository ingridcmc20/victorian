package com.victorian.produccion.mapper;

import java.util.List;

import com.victorian.produccion.domain.Perfil;
import com.victorian.produccion.domain.Sistema;

public interface SistemaMapper {
    
    public List<Sistema> listSistema() throws Exception;
    
    public void deleteSistema(Long cod_sistema) throws Exception;
    
    public void updateSistema(Sistema sistema) throws Exception;
    
    public void insertSistema(Sistema sistema) throws Exception;
    
    public Sistema findSistema(Sistema sistema) throws Exception;
    
    public Sistema findSistemaPorCodigo(Long cod_sistema) throws Exception;
    
    public List<Sistema> listSistemaxPerfil(Perfil perfil) throws Exception;	

}
