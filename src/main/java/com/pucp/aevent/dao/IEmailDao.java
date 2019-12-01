package com.pucp.aevent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Email;

public interface IEmailDao extends JpaRepository<Email, Long> {
	public Email findByIdEmail(Integer id);
}