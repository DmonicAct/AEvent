package com.pucp.aevent.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.service.IPersonaService;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private IPersonaService service;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Persona persona = service.findByUsername(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("nombre_usuario", persona.getNombre());
		info.put("email_usuario", persona.getEmail());
		info.put("appaterno_usuario", persona.getAppaterno());
		info.put("apmaterno_usuario", persona.getApmaterno());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);;
		return accessToken;
	}

}
