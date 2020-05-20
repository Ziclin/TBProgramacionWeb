package pe.progra.tb.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IActorDao;
import pe.progra.tb.entity.Actor;

public class ActorDaoImpl implements IActorDao, Serializable{

	@PersistenceContext(unitName = "TB")
	private EntityManager em;
	
	@Transactional
	@Override
	public void RegistrarActor(Actor actor) {
		em.persist(actor);	
	}

	@Override
	public List<Actor> ListarActores() {
		List<Actor> lista = new ArrayList<>();
		Query query = em.createQuery("select a from Actor a");
		      lista = (List<Actor>)query.getResultList();		
		return lista;
	}

	@Transactional
	@Override
	public void EliminarActor(int idActor) {
		Actor actor = new Actor();
		actor = em.getReference(Actor.class, idActor);
		em.remove(actor);		
	}

	@Transactional
	@Override
	public void ActualizarActor(Actor actor) {
		em.merge(actor);
	}
	
	@Override
	public List<Actor> BuscarActor(String nameActor) {
		List<Actor> lista = new ArrayList<>();
		Query query = em.createQuery("select a from Actor a where a.nameActor LIKE ?1");
		query.setParameter(1, nameActor + "%");
		lista = (List<Actor>)query.getResultList();		
		return lista;
	}

}
