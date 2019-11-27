package com.pucp.aevent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.ICorreoDao;
import com.pucp.aevent.entity.Correo;
import com.pucp.aevent.service.ICorreoService;

@Service
public class CorreoService implements ICorreoService{
	@Autowired
	private ICorreoDao correoDAO;
	
	@Override
	public Correo save(Correo correo) {
		try {
			correoDAO.save(correo);
			return correo;
		}catch(Exception e) {
			System.out.print(e.getMessage());
			return new Correo();
		}
	}
	
	@Override
	public Correo get() {
		return correoDAO.findByIdCorreo(1);
	}
}