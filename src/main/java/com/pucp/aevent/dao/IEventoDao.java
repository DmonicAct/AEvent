package com.pucp.aevent.dao;


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
}
