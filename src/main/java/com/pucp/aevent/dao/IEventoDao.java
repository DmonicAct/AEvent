package com.pucp.aevent.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Usuario;

public interface IEventoDao extends JpaRepository<Evento, Long>{
	public Evento findByIdEvento(Integer id);	
	
	public Page<Evento> findByOrganizador(Usuario organizador,Pageable page);

	public Page<Evento> findByPresidente(Usuario presidente, Pageable page);
	
	public Page<Evento> findByComite(Usuario evaluador, Pageable page);
	
	public Page<Evento> findByEnabled(boolean flag,Pageable page);
	
	public Page<Evento> findByOrganizadorAndEnabled(Usuario organizador,boolean flag, Pageable page);

	public Page<Evento> findAll(Usuario usuario, Pageable page);
	
	public List<Evento> findByPresidente(Usuario presidente);
	public List<Evento> findByOrganizador(Usuario organizador);
	
}
