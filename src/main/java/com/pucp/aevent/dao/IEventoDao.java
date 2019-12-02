package com.pucp.aevent.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Usuario;

public interface IEventoDao extends JpaRepository<Evento, Long>{
	public Evento findByIdEvento(Integer id);	
	
	public Page<Evento> findByOrganizador(Usuario organizador,Pageable page);

	public Page<Evento> findByPresidente(Usuario presidente, Pageable page);
	
	public Page<Evento> findByComite(Usuario evaluador, Pageable page);
	
	public Page<Evento> findByEnabledAndEstadoEvento(boolean flag, String estado, Pageable page);
	
	public Page<Evento> findByEnabled(boolean flag, Pageable page);
	
	public Page<Evento> findByOrganizadorAndEnabled(Usuario organizador,boolean flag, Pageable page);

	public Page<Evento> findAll(Usuario usuario, Pageable page);
	
	public List<Evento> findByPresidente(Usuario presidente);
	public List<Evento> findByOrganizador(Usuario organizador);
	
	public Page<Evento> findByEstadoEvento(String estado, Pageable page);
	
	public Page<Evento> findByEnabledAndEstadoEventoIn(Boolean enabled, List<String> estado, Pageable page);
	
	/*
	 * 
	 * Listado de Evento
	 * */
	public Page<Evento> findByEnabledAndOrganizadorAndTituloContains(boolean flag,Usuario organizador, String titulo,Pageable page);
	public Page<Evento> findByEnabledAndOrganizadorAndCategoriasIn(boolean flag,Usuario organizador, List<Categoria> categorias,Pageable page);
	public Page<Evento> findByEnabledAndOrganizadorAndPresidente(boolean flag,Usuario organizador, Usuario presidente,Pageable page);
	public Page<Evento> findByMotivoFinAndOrganizador(String motivo,Usuario organizador,Pageable page);
	
	
}
