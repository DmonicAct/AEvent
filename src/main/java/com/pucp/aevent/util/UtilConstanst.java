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
	public static final String APP_ROUTE_FULL_ACCESS_EMAIL = "/api/usuarios/email/**";
}
