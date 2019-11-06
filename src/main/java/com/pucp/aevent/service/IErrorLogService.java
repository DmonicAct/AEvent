package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.ErrorLog;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface IErrorLogService {
	Error getError();
	public List<ErrorLog> findAll();
	
	public List<ErrorLog> findAll(Pageable pageable);
	
	Paginacion getPaginacion();
	
	public void save(ErrorLog error); 
}
