package com.pucp.aevent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.pucp.aevent.entity.Preferencia;

public interface IPreferenciaDao extends JpaRepository <Preferencia, Long> {
	public List<Preferencia> findByIdUsuario(int idUsuario);
	public Preferencia findByIdUsuarioAndIdPropuesta(int idUsuario,int idPropuesta);
}
