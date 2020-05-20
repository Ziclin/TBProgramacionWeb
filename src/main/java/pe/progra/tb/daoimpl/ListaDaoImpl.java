package pe.progra.tb.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IListaDao;
import pe.progra.tb.entity.Lista;
import pe.progra.tb.entity.Pelicula;
import pe.progra.tb.entity.Serie;

public class ListaDaoImpl implements IListaDao, Serializable{

	@PersistenceContext(unitName = "TB")
	private EntityManager em;
	
	@Transactional
	@Override
	public void CrearLista(Lista lista) {
		em.persist(lista);
	}
	
	@Transactional
	@Override
	public void EliminarLista(int idLista) {
		Lista lista = new Lista();
		lista = em.getReference(Lista.class, idLista);
		em.remove(lista);
	}
	
	@Transactional
	@Override
	public void InsertarPeliculaLista(int idLista, Pelicula pelicula) {
		Lista lista = em.find(Lista.class, idLista);
		lista.getLista_Pelicula().add(pelicula);
		pelicula.getListas().add(lista);
	}
	
	@Transactional
	@Override
	public void InsertarSerieLista(int idLista, Serie serie) {
		Lista lista = em.find(Lista.class, idLista);
		lista.getLista_Serie().add(serie);
		serie.getListas().add(lista);
	}
	
	@Transactional
	@Override
	public void EliminarPeliculaLista(int idLista, Pelicula pelicula) {
		Lista lista = em.find(Lista.class, idLista);
		lista.getLista_Pelicula().remove(pelicula);
		pelicula.getListas().add(lista);
	}
	
	@Transactional
	@Override
	public void EliminarSerieLista(int idLista, Serie serie) {
		Lista lista = em.find(Lista.class, idLista);
		lista.getLista_Serie().remove(serie);
		serie.getListas().add(lista);
	}
	
	@Override
	public List<Lista> ListarListasUsuario(int idUsuario){
		List<Lista> lista = new ArrayList<>();
		Query query = em.createQuery("select l from lista l where l.idUsuario = ?1");
		query.setParameter(1, idUsuario);
		lista = (List<Lista>)query.getResultList();		
		return lista;
	}
}
