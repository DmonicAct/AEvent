package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.ErrorLog;
import com.pucp.aevent.entity.TipoCriterio;

public interface IErrorLogDao extends JpaRepository <ErrorLog, Long>{
	public List<ErrorLog> findAll();

	public Page<ErrorLog> findAll(Pageable pageable);
}
