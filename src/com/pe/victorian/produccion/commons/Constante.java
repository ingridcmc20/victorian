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
	public static final Integer REGISTRADO = 1;
	public static final Integer ACEPTADO = 2;
	public static final Integer EN_PROCESO = 3;
	public static final Integer FINALIZADO = 4;
	
	public static final Integer PP_PENDIENTE = 5;
	public static final Integer PP_APROBADO = 6;
	
	public static final Integer OT_PENDIENTE = 7;
	public static final Integer OT_EN_CURSO = 8;
	public static final Integer OT_TERMINADO = 9;
	public static final Integer OT_POR_APROBAR = 10;
	
	public static final Integer OT_ETAPA_DISENIO = 1;
	public static final Integer OT_ETAPA_CORTE = 2;
	public static final Integer OT_ETAPA_CONFECCION = 3;
	public static final Integer OT_ETAPA_EMPAQUETADO = 4;
	
	
	// Perfiles
	public static final Integer PERFIL_USUARIO_DISENIADOR = 42;
	public static final Integer PERFIL_USUARIO_CORTADOR = 43;
	public static final Integer PERFIL_USUARIO_CONFECCIONISTA = 44;
	public static final Integer PERFIL_USUARIO_EMPAQUETADOR = 45;
	
	// Menu oculto
	public static final Integer MENU_LOGIN = 18;
	
	// Perfiles
	public static final Integer OP_DISENADOR = 1;
	public static final Integer OP_CORTADOR = 2;
	public static final Integer OP_CONFECCIONISTA = 3;
	public static final Integer OP_EMPAQUETADOR = 4;
	
	// Niveles
	public static final Integer NIVEL_1 = 1;
	public static final Integer NIVEL_2 = 2;
	public static final Integer NIVEL_3 = 3;
	public static final Integer NIVEL_4 = 4;
	public static final Integer NIVEL_5 = 5;
}
