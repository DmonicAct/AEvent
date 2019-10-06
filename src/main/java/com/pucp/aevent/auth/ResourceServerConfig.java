package com.pucp.aevent.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.pucp.aevent.util.UtilConstanst;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		/*
		 * RUTAS DE ACCESSO ACORDE A ROL
		 * */
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,UtilConstanst.APP_ROUTE_FULL_ACCESS_EMAIL).permitAll() 
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource(){
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList(UtilConstanst.APP_ORIGIN_ROUTE_LOCAL));
		config.setAllowedMethods(Arrays.asList(	HttpMethod.GET.name(),
												HttpMethod.POST.name(),
												HttpMethod.PUT.name(),
												HttpMethod.DELETE.name(),
												HttpMethod.OPTIONS.name()));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList(UtilConstanst.APP_ORIGIN_HEADERS,UtilConstanst.APP_ORIGIN_HEADERS_TYPE));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",config);
		
		return source;
	}
	
	@Bean 
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter> (new CorsFilter(corsConfigurationSource()));

		//Dar un orden bajo mientras mas bajo mayor la precedencia

		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
