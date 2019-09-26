package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
//	public List<Usuario>  findByRoles(Integer idRol);
	public Usuario findById(Integer id);
	
	//public List<Usuario> findAll(PageRequest pageable);
	public List<Usuario> findAll(Pageable pageable);
	
	public void save(Usuario usuario);
	
	public void delete(Usuario usuario);
	
	Paginacion getPaginacion();
	Error getError();
//	public List<Usuario> findByEmail(String email);
}
