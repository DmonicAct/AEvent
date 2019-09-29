package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IRolDao;
import com.pucp.aevent.entity.Role;
import com.pucp.aevent.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	IRolDao dao;
	
	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

}
