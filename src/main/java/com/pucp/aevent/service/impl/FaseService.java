package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IFaseDao;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.FormularioCFP;
import com.pucp.aevent.entity.Division;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IDivisionService;
import com.pucp.aevent.service.IFaseService;
import com.pucp.aevent.service.IFormularioCFPService;

@Service
public class FaseService implements IFaseService{
	
	@Autowired
	IFaseDao dao;
	
	@Autowired
	IFormularioCFPService service;
	
	@Autowired
	IDivisionService divisionService;
	
	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Fase> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Fase save(Fase fase) {
		Fase fase_temp = null;
		try {
			fase_temp = this.dao.save(fase);
			FormularioCFP formulario = fase_temp.getFormulario();
			if(formulario!=null) {
				formulario.setDivisionList(fase.getFormulario().getDivisionList());
				this.service.save(formulario);
				if(formulario.getDivisionList()!=null) {
					List<Division> listaDivision = this.divisionService.findByIdFormulario(formulario.getIdFormulariocfp());
					formulario.setDivisionList(listaDivision);
					fase_temp.setFormulario(formulario);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		return fase_temp;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Fase> findByEvento(Evento evento) {
		return this.dao.findByIdEvento(evento);
	}

	@Override
	@Transactional
	public void delete(Long fase) {
		try {
			this.dao.deleteById(fase);
		}catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Fase findByIdFase(Long id) {
		return this.dao.findByIdFase(id);
	}
	
}
