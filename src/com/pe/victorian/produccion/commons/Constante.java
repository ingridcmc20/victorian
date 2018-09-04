package com.pe.victorian.produccion.commons;

public class Constante {
	public static final String SESSION_USER = "usuarioEnSesion";
	public static final String SESSION_LOG = "logEnSesion";
	/************* para tpos de mensaje: will *******/
	public static final Integer ERROR = 1;
	public static final Integer FATAL = 2;
	public static final Integer INFORMACION = 3;
	public static final Integer ADVERTENCIA = 4;
	
	/**ESTADOS**/
	/**PEDIDOS**/
	public static final Integer PENDIENTE_APROBACION = 1;
	public static final Integer APROBADO = 2;
	public static final Integer ACEPTADO = 3;
	public static final Integer PROGRAMADO = 9;
	
	public static final String PP_PENDIENTE_APROBACION = "PENDIENTE DE APROBACION";
	public static final String PP_APROBADO = "APROBADO";
	
	public static final Integer OT_PENDIENTE = 4;
	public static final Integer OT_EN_CURSO = 5;
	public static final Integer OT_TERMINADO = 6;
	
	public static final Integer OT_ETAPA_DISENIO = 1;
	public static final Integer OT_ETAPA_CORTE = 2;
	public static final Integer OT_ETAPA_CONFECCION = 3;
	public static final Integer OT_ETAPA_EMPAQUETADO = 4;
	
	
	// Perfiles
	public static final Integer PERFIL_USUARIO_DISENIADOR = 42;
	public static final Integer PERFIL_USUARIO_CORTADOR = 43;
	public static final Integer PERFIL_USUARIO_CONFECCIONISTA = 44;
	public static final Integer PERFIL_USUARIO_EMPAQUETADOR = 45;
	
	public static final String TO_CORTADOR = "CORTADOR";
	public static final String TO_CONFECCIONISTA = "CONFECCIONISTA";
	
	// Menu oculto
	public static final Integer MENU_LOGIN = 230;

}
