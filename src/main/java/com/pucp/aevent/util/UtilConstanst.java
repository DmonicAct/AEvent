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
	public static final long ROLE_PRESIDENT = 2;
	public static final long ROLE_ORGANIZER = 3;
	public static final long ROLE_EVALUATOR = 4;
	public static final long ROLE_USER = 5;
	
	public static final String NAME_ROLE_ADMIN = "ROLE_ADMIN";
	public static final String NAME_ROLE_PRESIDENT = "ROLE_PRESIDENT";
	public static final String NAME_ROLE_ORGANIZER = "ROLE_ORGANIZER";
	public static final String NAME_ROLE_EVALUATOR = "ROLE_EVALUATOR";
	public static final String NAME_ROLE_USER = "ROLE_USER";

}
