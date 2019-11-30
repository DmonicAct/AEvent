package com.pucp.aevent.util;

public class UtilConstanst {
	public static final String  APP_CONFIG_NAME = "angularApp";
	public static final String  APP_CONFIG_PASSWORD = "angularApp";
	public static final Integer APP_CONFIG_TOKEN_VALIDITY_TIME = 3600;
	public static final Integer APP_CONFIG_TOKEN_REFRESH_TIME = 3600;
	public static final String  APP_ORIGIN_ROUTE_LOCAL = "http://localhost:4200";
	//Origin IPV4 AWS
	//public static final String  APP_ORIGIN_ROUTE_LOCAL = "http://18.206.239.108.nip.io:8080";
	public static final String  APP_ORIGIN_ROUTE_DEPLOY = ""; 
	public static final String  APP_ORIGIN_HEADERS = "Content-Type";
	public static final String  APP_ORIGIN_HEADERS_TYPE = "Authorization";
	
	//Routes Common All
	public static final String APP_ROUTE_OUT_ACCESS= "/api/usuarios/out/**";
	
	
	//ROLES
	public static final long ROLE_ADMIN = 1;
	public static final long ROLE_ORGANIZER = 2;
	public static final long ROLE_DEFAULT= 3;
	
	public static final String NAME_ROLE_ADMIN = "ROLE_ADMIN";
	public static final String NAME_ROLE_ORGANIZER = "ROLE_ORGANIZER";
	public static final String NAME_ROLE_DAFAULT = "ROLE_DAFAULT";
	
	//EVENTO
	public static final String EVENTO_FASE_BORRADOR					= "EVENTO_BORRADOR";
	public static final String EVENTO_POR_APROBACION  				= "EVENTO_POR_APROBACION";
	public static final String EVENTO_LANZAMIENTO 					= "EVENTO_LANZAMIENTO";
	public static final String EVENTO_FINALIZADO 					= "EVENTO_FINALIZADO";	
	public static final String EVENTO_CANCELADO						= "EVENTO_CANCELADO";

	
	//PROPUESTA 
	public static final String PROPUESTA_SIN_ASIGNAR 				= "PROPUESTA_SIN_ASIGNAR";
	public static final String PROPUESTA_ASIGNADA	 				= "PROPUESTA_ASIGNADA";
	public static final String PROPUESTA_APROBADA	 				= "PROPUESTA_APROBADA";	
	public static final String PROPUESTA_RECHAZADA	 				= "PROPUESTA_RECHAZADA";

	//POSTULACION
	public static final String POSTULACION_EN_CURSO 				= "POSTULACION_EN_CURSO";
	public static final String POSTULACION_EN_ESPERA 				= "POSTULACION_EN_ESPERA";
	public static final String POSTULACION_APROBADA 				= "POSTULACION_APROBADA";
	public static final String POSTULACION_RECHAZADA 				= "POSTULACION_RECHAZADA";
	public static final String POSTULACION_BORRADOR					= "POSTULACION_BORRADOR";
	
	//EVALUACION 
	public static final String EVALUACION_ASIGNADA 					= "EVALUACION_ASIGNADA";
	public static final String EVALUACION_CORREGIDA 				= "EVALUACION_CORREGIDA";
	
	//FASES
	public static final String FASE_APROBADA 			= "FASE_APROBADA";
	public static final String FASE_ESPERA				= "FASE_ESPERA";
	public static final String FASE_BORRADOR			= "FASE_BORRADOR";
	public static final String FASE_OBSERVADA			= "FASE_OBSERVADA";
	
	//PREFERENCIAS
	public static final String PREFERENCIA_DEFAULT 		= "SIN DETERMINAR";
}
