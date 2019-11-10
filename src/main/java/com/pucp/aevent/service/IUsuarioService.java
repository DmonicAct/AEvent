package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);

	public Usuario findById(Integer id);
	
	public List<Usuario> findAllInactive(Pageable pageable);
	
	public List<Usuario> findAllActive(Pageable pageable);
	
	public List<Usuario> findAllActive();

	public List<Usuario> findAllInactive();
	
	public Usuario save(Persona persona);
	
	public Usuario saveOut(Persona persona);
	
	public void cambioUsuario(Usuario usuario);
	
	public Boolean existsByEmail(String email);
	
	public Boolean existsByUsername(String username);
	
	Paginacion getPaginacion();
	Error getError();
}
