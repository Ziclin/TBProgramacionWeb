package pe.progra.tb.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.progra.tb.dao.ISerieDao;
import pe.progra.tb.entity.Actor;
import pe.progra.tb.entity.Serie;

public class SerieDaoImpl implements ISerieDao, Serializable{

	@PersistenceContext(unitName = "TB")
	private EntityManager em;
	
	@Transactional
	@Override
	public void RegistrarSerie(Serie serie) {
		em.persist(serie);
	}
	
	@Transactional
	@Override
	public void EliminarSerie(int idSerie) {
		Serie serie = new Serie();
		serie = em.getReference(Serie.class, idSerie);
		em.remove(serie);
	}
	
	@Transactional
	@Override
	public void ActualizarSerie(Serie serie) {
		em.merge(serie);	
	}
	
	@Transactional
	@Override
	public void InsertarActorSerie(int idSerie, Actor actor) {
		Serie serie = em.find(Serie.class, idSerie);
		serie.getActores().add(actor);
		actor.getActor_Serie().add(serie);
	}
	
	@Transactional
	@Override
	public void EliminarActorSerie(int idSerie, Actor actor) {
		Serie serie = em.find(Serie.class, idSerie);
		serie.getActores().remove(actor);
		actor.getActor_Serie().remove(serie);
	}
	
	@Override
	public List<Serie> BuscarSerie(String nameSerie) {
		List<Serie> lista = new ArrayList<>();
		Query query = em.createQuery("select s from Serie s where s.nameSerie LIKE ?1");
		query.setParameter(1, nameSerie + "%");
		lista = (List<Serie>)query.getResultList();		
		return lista;
	}
	
	@Override
	public List<Actor> ListarActorSerie(int idSerie) {
		List<Actor> lista = new ArrayList<>();
		Query query = em.createQuery("select a from Actor_Serie a where a.idSerie = ?1");
		query.setParameter(1, idSerie);
		lista = (List<Actor>)query.getResultList();		
		return lista;
	}

	@Override
	public List<Serie> ListarSeries() {
		List<Serie> lista = new ArrayList<>();
		Query query = em.createQuery("select s from Serie s");
		      lista = (List<Serie>)query.getResultList();		
		return lista;
	}
}
