package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface IPersonaService {
	Error getError();
	public List<Persona> findAll();
	
	public void save(Persona persona);
	
	public Persona findByUsername(String username);
	
//	public Boolean existsByDni(String dni);
	
	public List<Persona> findByNombre(String nombre);
	
	public List<Persona> findByUsername(Integer id,String username,Pageable page);
	
	public List<Persona> findByEmail(Integer id,String email,Pageable page);
	
	public List<Persona> findAllDisponible(Integer id,Pageable page);
	
	public List<Persona> findByNombre(Integer id,String nombre,Pageable page);
	
	public List<Persona> findAllComite(Integer id, Pageable page);
	
	public List<Persona> findByEmailComite(Integer id,String email, Pageable page);
	public List<Persona> findByUsernameComite(Integer id,String username,Pageable page) ;
	public List<Persona> findByNombreComite(Integer id,String nombre, Pageable page) ;
	
	
	public List<Persona> findByEmailEvaluadoresAsignados(Integer id,String email, Pageable page);
	public List<Persona> findByUsernameEvaluadoresAsignados(Integer id,String username,Pageable page) ;
	public List<Persona> findByNombreEvaluadoresAsignados(Integer id,String nombre, Pageable page) ;
	
	public List<Persona> findByEmailEvaluadoresDisponibles(Integer id,String email, Pageable page);
	public List<Persona> findByUsernameEvaluadoresDisponibles(Integer id,String username,Pageable page) ;
	public List<Persona> findByNombreEvaluadoresDisponibles(Integer id,String nombre, Pageable page) ;
	public List<Persona> findByPreferenciaEvaluadoresDisponibles(Integer id,String preferencia, Pageable page);
	
	
	public List<Persona> findByNombreCompletoContainingAndEnabled(String nombre,boolean enabled,Pageable page);
	public List<Persona> findByEmailContainingAndEnabled(String email,boolean enabled,Pageable page);
	public List<Persona> findByUsernameContainingAndEnabled(String username,boolean enabled,Pageable page);
	
	public Paginacion getPaginacion() ;
}
