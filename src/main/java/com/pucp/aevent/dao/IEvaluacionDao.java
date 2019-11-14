package com.pucp.aevent.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface IEvaluacionDao  extends JpaRepository <Evaluacion, Long>{
	public Page<Evaluacion> findByEvaluador(Persona usuario, Pageable page);
	public Evaluacion findByEvaluadorAndPropuestaAndFase(Persona usuario,Propuesta propuesta,Fase fase);
	public List<Evaluacion> findByPropuesta(Propuesta propuesta);
	public void delete(Evaluacion evaluacion);
	
	public Evaluacion findByIdEvaluacion(int idEvaluacion);
}