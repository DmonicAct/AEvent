package com.pucp.aevent.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Usuario;

public interface IEventoDao extends JpaRepository<Evento, Long>{
	public Evento findByIdEvento(Integer id);	
	
	public Page<Evento> findByOrganizador(Usuario organizador,Pageable page);

	@Query(value = "SELECT E.* "
				 + "FROM EVENTO E, USUARIO U "
				 + "WHERE (E.ID_PRESIDENTE = U.ID_USUARIO OR E.ID_ORGANIZADOR = U.ID_USUARIO) AND U.USUARIO = ?1", nativeQuery = true)
	public List<Evento> findAllByPresidente(String username);
}
