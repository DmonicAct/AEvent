package com.pucp.aevent.util;

public class UtilConstanst {
	public static final String  APP_CONFIG_NAME = "angularApp";
	public static final String  APP_CONFIG_PASSWORD = "angularApp";
	public static final Integer APP_CONFIG_TOKEN_VALIDITY_TIME = 3600;
	public static final Integer APP_CONFIG_TOKEN_REFRESH_TIME = 3600;
	public static final String  APP_ORIGIN_ROUTE_LOCAL = "http://localhost:4200";
	public static final String  APP_ORIGIN_ROUTE_DEPLOY = ""; 
	public static final String  APP_ORIGIN_HEADERS = "Content-Type";
	public static final String  APP_ORIGIN_HEADERS_TYPE = "Authorization";
	
	//Routes Common All
	public static final String APP_ROUTE_OUT_ACCESS= "/api/usuarios/out/**";
	
	//Roles

	public static final long ROLE_ADMIN = 1;
	public static final long ROLE_ORGANIZER = 2;
	public static final long ROLE_DEFAULT= 3;
	
	public static final String NAME_ROLE_ADMIN = "ROLE_ADMIN";
	public static final String NAME_ROLE_ORGANIZER = "ROLE_ORGANIZER";
	public static final String NAME_ROLE_DAFAULT = "ROLE_DAFAULT";
	
	//Estado Evento
	public static final String EVENTO_FASE_BORRADOR					= "EVENTO_BORRADOR";
	public static final String EVENTO_FASE_PRESIDENTE  				= "EVENTO_PRESIDENTE";
	public static final String EVENTO_FASE_SELECCION_PONENCIA 		= "EVENTO_SELECCION";
	public static final String EVENTO_FASE_INICIO 					= "EVENTO_INICIO";
	
	public static final String EVENTO_CANCELADO						= "EVENTO_CANCELADO";
	//Estado Propuesta
	public static final String PROPUESTA_BORRADOR		=	"PROPUESTA_BORRADOR";
	public static final String PROPUESTA_SIN_ASIGNAR	=	"PROPUESTA_SIN_ASIGNAR";	
	public static final String PROPUESTA_ESPERA    		=	"PROPUESTA_ESPERA";	
	public static final String PROPUESTA_APROBADA  		=	"PROPUESTA_APROBADA";	
	public static final String PROPUESTA_OBSERVADA 		=	"PROPUESTA_OBSERVADA";	
	public static final String PROPUESTA_CANCELADA 		=	"PROPUESTA_CANCELADA";
}
