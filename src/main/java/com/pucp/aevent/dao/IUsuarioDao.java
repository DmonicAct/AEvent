package com.pucp.aevent.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pucp.aevent.entity.Usuario;

public interface IUsuarioDao extends JpaRepository <Usuario, Long>{
	public Usuario findByUsername(String username);

	public Usuario findByIdUsuario(Integer id);	
	
	public Page<Usuario> findByEnabledTrue(org.springframework.data.domain.Pageable pageable);
	
	public Page<Usuario> findByEnabledFalse(org.springframework.data.domain.Pageable pageable);
	
	public List<Usuario> findByEnabled(Boolean enabled);
	
	public Usuario getUsernameAndEmailByIdUsuario(Integer id);
	
	public Boolean existsByEmail(String email);
	
	public Boolean existsByUsername(String username);
	
	/*
	 * Query Sample
	 * */
	@Query(nativeQuery = true,value = "call SEG_OBTENER_USUARIOS(:IN_USERNAME,:IN_VEMAIL,:IN_IDUSUARIO,:IN_NOMBRE,:IN_APPATERNO,:IN_APMATERNO,:IN_ID_ROL)")
	public List<Object[]> findAll3
			(
			String IN_USERNAME,
			String IN_VEMAIL,
			Integer IN_IDUSUARIO,
			String IN_NOMBRE,
			String IN_APPATERNO,
			String IN_APMATERNO,
			Integer IN_ID_ROL
			);
	
	
	@Query(value = "SELECT VUSERNAME,NUSUARIO_ACTIVO,VEMAIL FROM USUARIOS", nativeQuery = true)
	public List<Object[]> findAll2();
	
	
	
}
