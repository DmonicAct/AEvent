package com.pucp.aevent.dao;

import org.springframework.data.repository.CrudRepository;

import com.pucp.aevent.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
	public Usuario findByUsername(String username);
}
