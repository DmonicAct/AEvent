package com.pucp.aevent.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IEvaluacionDao;
import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.dao.IPreferenciaDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Lugar;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	IPersonaDao dao;
	
	@Autowired
	IEventoDao daoEvento;
	
	@Autowired
	IUsuarioDao daoUsuario;
	
	@Autowired
	IPropuestaDao daoPropuesta;
	
	@Autowired
	IPreferenciaDao daoPreferencia;
	
	@Autowired
	IEvaluacionDao daoEvaluacion;
	
	private Paginacion paginacion;
	
	
	
	public Paginacion getPaginacion() {
		return paginacion;
	}

	public void setPaginacion(Paginacion paginacion) {
		this.paginacion = paginacion;
	}

	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		return dao.findByEnabled(true);
	}

	@Override
	@Transactional
	public void save(Persona persona) {
		this.dao.save(persona);
	}

	@Override
	@Transactional(readOnly=true)
	public Persona findByUsername(String username) {
		return this.dao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByNombre(String nombre) {
		return dao.findByNombreStartsWith(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByNombre(Integer id,String nombre, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> comite = e.getComite();
			List<Integer> idsComite = new ArrayList<Integer>();
			for (Usuario u: comite) {
				idsComite.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsComite,"ROLE_ADMIN",true);
			
			
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase()))
					ids.add(u.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByUsername(Integer id,String username,Pageable page) {
		Page<Persona> lista = null;
		boolean flagAdmin = false;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> comite = e.getComite();
			List<Integer> idsComite = new ArrayList<Integer>();
			for (Usuario u: comite) {
				idsComite.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsComite,"ROLE_ADMIN",true);
			//List<Persona> listaUsuarios= dao.findByIdUsuarioNotIn(idsComite);
			
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getUsername().toLowerCase().contains(username.toLowerCase())) {
					ids.add(u.getIdUsuario());
				}
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAllDisponible(Integer id, Pageable page) {
		Page<Persona> lista = null;
		Boolean flag = false;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			List<Usuario> listaUsuarios = e.getComite();
			HashSet<Integer> ids = new HashSet<Integer>();
			for (Usuario u: listaUsuarios) {	
				ids.add(u.getIdUsuario());
			}	
			//Buscamos administradores
			listaUsuarios = daoUsuario.findByRoles_nombreAndEnabled("ROLE_ADMIN", true);
			for (Usuario u: listaUsuarios) {	
				ids.add(u.getIdUsuario());
			}	
			List<Integer> listaIDs = new ArrayList<>(ids); 
			lista = dao.findByEnabledAndIdUsuarioNotIn(true,listaIDs, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAllComite(Integer id, Pageable page) {
		Page<Persona> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			List<Usuario> listaUsuarios = e.getComite();
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) 
				ids.add(u.getIdUsuario());
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}

	@Override
	public List<Persona> findByEmail(Integer id,String email, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> comite = e.getComite();
			List<Integer> idsComite = new ArrayList<Integer>();
			for (Usuario u: comite) {
				idsComite.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsComite,"ROLE_ADMIN",true);
			
			
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getEmail().toLowerCase().contains(email.toLowerCase()))
					ids.add(u.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByNombreComite(Integer id,String nombre, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> listaUsuarios= e.getComite();
			List<Integer> ids =new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase()))
					ids.add(u.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByUsernameComite(Integer id,String username,Pageable page) {
		Page<Persona> lista = null;
		boolean flagAdmin = false;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> listaUsuarios= e.getComite();
			List<Integer> ids =new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getUsername().toLowerCase().contains(username.toLowerCase())) {
					ids.add(u.getIdUsuario());
				}
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	public List<Persona> findByEmailComite(Integer id,String email, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> listaUsuarios= e.getComite();
			List<Integer> ids =new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getEmail().toLowerCase().contains(email.toLowerCase()))
					ids.add(u.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByNombreEvaluadoresAsignados(Integer id,String nombre, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			
			Propuesta p  = daoPropuesta.findByIdPropuesta(id);
			List<Evaluacion> evaluaciones = daoEvaluacion.findByPropuesta(p);
			List<Persona> evaluadores = new ArrayList<Persona>();
			for (Evaluacion e : evaluaciones) {
				evaluadores.add(dao.findByIdUsuario(e.getEvaluador().getIdUsuario()));
			}
			System.out.println(evaluadores.get(0).getNombreCompleto());
			
			List<Integer> ids =new ArrayList<Integer>();
			for (Usuario u: evaluadores) {
				if(u.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase()))
					ids.add(u.getIdUsuario());
			}
			System.out.println(ids.toString());	
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByUsernameEvaluadoresAsignados(Integer id,String username,Pageable page) {
		Page<Persona> lista = null;
		boolean flagAdmin = false;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			
			Propuesta p  = daoPropuesta.findByIdPropuesta(id);
			List<Evaluacion> evaluaciones = daoEvaluacion.findByPropuesta(p);
			List<Persona> evaluadores = new ArrayList<Persona>();
			for (Evaluacion e : evaluaciones) {
				evaluadores.add(dao.findByIdUsuario(e.getEvaluador().getIdUsuario()));
			}
			System.out.println(evaluadores.get(0).getUsername());
			List<Integer> ids =new ArrayList<Integer>();
			for (Usuario u: evaluadores) {
				if(u.getUsername().toLowerCase().contains(username.toLowerCase())) {
					ids.add(u.getIdUsuario());
				}
			}
			System.out.println(ids.toString());	
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	public List<Persona> findByEmailEvaluadoresAsignados(Integer id,String email, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			
			Propuesta p  = daoPropuesta.findByIdPropuesta(id);
			List<Evaluacion> evaluaciones = daoEvaluacion.findByPropuesta(p);
			List<Persona> evaluadores = new ArrayList<Persona>();
			for (Evaluacion e : evaluaciones) {
				evaluadores.add(dao.findByIdUsuario(e.getEvaluador().getIdUsuario()));
			}
			System.out.println(evaluadores.get(0).getEmail());
			List<Integer> ids =new ArrayList<Integer>();
			for (Usuario u: evaluadores) {
				if(u.getEmail().toLowerCase().contains(email.toLowerCase()))
					ids.add(u.getIdUsuario());
			}
			System.out.println(ids.toString());	
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByNombreEvaluadoresDisponibles(Integer id,String nombre, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Propuesta p  = daoPropuesta.findByIdPropuesta(id);
			List<Evaluacion> evaluaciones = daoEvaluacion.findByPropuesta(p);
			List<Persona> evaluadores = new ArrayList<Persona>();
			for (Evaluacion e : evaluaciones) {
				evaluadores.add(dao.findByIdUsuario(e.getEvaluador().getIdUsuario()));
			}
			
			List<Integer> idsEvaluadores = new ArrayList<Integer>();
			for (Usuario u: evaluadores) {
				idsEvaluadores.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsEvaluadores,"ROLE_ADMIN",true);
			
			List<Integer> ids =new ArrayList<Integer>();
			for (Usuario u2: listaUsuarios) {
				if(u2.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase()))
					ids.add(u2.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByUsernameEvaluadoresDisponibles(Integer id,String username,Pageable page) {
		Page<Persona> lista = null;
		boolean flagAdmin = false;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Propuesta p  = daoPropuesta.findByIdPropuesta(id);
			List<Evaluacion> evaluaciones = daoEvaluacion.findByPropuesta(p);
			List<Persona> evaluadores = new ArrayList<Persona>();
			for (Evaluacion e : evaluaciones) {
				evaluadores.add(dao.findByIdUsuario(e.getEvaluador().getIdUsuario()));
			}
			
			List<Integer> idsEvaluadores = new ArrayList<Integer>();
			for (Usuario u: evaluadores) {
				idsEvaluadores.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsEvaluadores,"ROLE_ADMIN",true);
			
			List<Integer> ids =new ArrayList<Integer>();
			for (Usuario u2: listaUsuarios) {
				if(u2.getUsername().toLowerCase().contains(username.toLowerCase())) {
					ids.add(u2.getIdUsuario());
				}
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	public List<Persona> findByEmailEvaluadoresDisponibles(Integer id,String email, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Propuesta p  = daoPropuesta.findByIdPropuesta(id);
			List<Evaluacion> evaluaciones = daoEvaluacion.findByPropuesta(p);
			List<Persona> evaluadores = new ArrayList<Persona>();
			for (Evaluacion e : evaluaciones) {
				evaluadores.add(dao.findByIdUsuario(e.getEvaluador().getIdUsuario()));
			}
			
			List<Integer> idsEvaluadores = new ArrayList<Integer>();
			for (Usuario u: evaluadores) {
				idsEvaluadores.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsEvaluadores,"ROLE_ADMIN",true);
			
			
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u2: listaUsuarios) {
				if(u2.getEmail().toLowerCase().contains(email.toLowerCase()))
					ids.add(u2.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	public List<Persona> findByPreferenciaEvaluadoresDisponibles(Integer id,String preferencia, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Propuesta p  = daoPropuesta.findByIdPropuesta(id);
			List<Evaluacion> evaluaciones = daoEvaluacion.findByPropuesta(p);
			List<Persona> evaluadores = new ArrayList<Persona>();
			for (Evaluacion e : evaluaciones) {
				evaluadores.add(dao.findByIdUsuario(e.getEvaluador().getIdUsuario()));
			}
			
			List<Integer> idsEvaluadores = new ArrayList<Integer>();
			for (Usuario u: evaluadores) {
				idsEvaluadores.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsEvaluadores,"ROLE_ADMIN",true);
			
			
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u2: listaUsuarios) {
				Preferencia pref = daoPreferencia.findByUsuarioAndPropuesta(u2, p);
				if(pref.getDescripcion().toLowerCase().contains(preferencia.toLowerCase()))
					ids.add(u2.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
//	@Override
//	@Transactional(readOnly=true)
//	public Boolean existsByDni(String dni) {
//		return this.dao.existsByDni(dni);
//	}

	@Override
	public List<Persona> findByNombreCompletoContainingAndEnabled(String nombre, boolean enabled, Pageable page) {
		Page<Persona> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByNombreCompletoContainingAndEnabled(nombre, enabled,page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}

	@Override
	public List<Persona> findByEmailContainingAndEnabled(String email, boolean enabled, Pageable page) {
		Page<Persona> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByEmailContainingAndEnabled(email, enabled,page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}

	@Override
	public List<Persona> findByUsernameContainingAndEnabled(String username, boolean enabled, Pageable page) {
		Page<Persona> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByUsernameContainingAndEnabled(username, enabled,page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}

}
