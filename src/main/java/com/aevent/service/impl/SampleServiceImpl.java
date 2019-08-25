package com.aevent.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aevent.service.ISampleService;

@Service
public class SampleServiceImpl implements ISampleService{

	@Override
	public List<Integer> getList() {
		List<Integer> lista = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			lista.add(i);
		}
		return lista;
	}

}
