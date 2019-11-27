package com.pucp.aevent.service;

import com.pucp.aevent.entity.Correo;

public interface ICorreoService {
	public Correo save(Correo correo);
	public Correo get();
}