package pe.progra.tb.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IPeliculaDao;
import pe.progra.tb.entity.Actor;
import pe.progra.tb.entity.Pelicula;

public class PeliculaDaoImpl implements IPeliculaDao, Serializable{

	@PersistenceContext(unitName = "TB")
	private EntityManager em;
	
	@Transactional
	@Override
	public void RegistrarPelicula(Pelicula pelicula) {
		em.persist(pelicula);
	}
	
	@Transactional
	@Override
	public void EliminarPelicula(int idPelicula) {
		Pelicula pelicula = new Pelicula();
		pelicula = em.getReference(Pelicula.class, idPelicula);
		em.remove(pelicula);
	}
	
	@Transactional
	@Override
	public void ActualizarPelicula(Pelicula pelicula) {
		em.merge(pelicula);	
	}
	
	@Transactional
	@Override
	public void InsertarActorPelicula(int idPelicula, Actor actor) {
		Pelicula pelicula = em.find(Pelicula.class, idPelicula);
		pelicula.getActores().add(actor);
		actor.getActor_Pelicula().add(pelicula);
	}

	
	@Transactional
	@Override
	public void EliminarActorPelicula(int idPelicula, Actor actor) {
		Pelicula pelicula = em.find(Pelicula.class, idPelicula);
		pelicula.getActores().remove(actor);
		actor.getActor_Pelicula().remove(pelicula);
	}

	
	@Override
	public List<Pelicula> BuscarPelicula(String namePelicula) {
		List<Pelicula> lista = new ArrayList<>();
		Query query = em.createQuery("select p from Pelicula p where p.namePelicula LIKE ?1");
		query.setParameter(1, namePelicula + "%");
		lista = (List<Pelicula>)query.getResultList();		
		return lista;
	}
	
	@Override
	public List<Actor> ListarActorPeliculas(int idPelicula) {
		List<Actor> lista = new ArrayList<>();
		Query query = em.createQuery("select a from Actor_Pelicula a where a.idPelicula = ?1");
		query.setParameter(1, idPelicula);
		lista = (List<Actor>)query.getResultList();		
		return lista;
	}

	@Override
	public List<Pelicula> ListarPeliculas() {
		List<Pelicula> lista = new ArrayList<>();
		Query query = em.createQuery("select p from Pelicula p");
		      lista = (List<Pelicula>)query.getResultList();		
		return lista;
	}
}
