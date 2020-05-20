package pe.progra.tb.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IResenaPeliculaDao;
import pe.progra.tb.entity.ResenaPelicula;
import pe.progra.tb.entity.Usuario;
import pe.progra.tb.entity.Actor;
import pe.progra.tb.entity.Lista;
import pe.progra.tb.entity.Pelicula;

public class ResenaPeliculaDaoImpl implements IResenaPeliculaDao, Serializable{

	@PersistenceContext(unitName = "TB") 
	private EntityManager em;

	@Transactional
	@Override
	public void CrearResenaPelicula(int idPelicula, int idUsuario, ResenaPelicula resenapelicula) {
		Pelicula peli = em.find(Pelicula.class, idPelicula);
		Usuario usuario = em.find(Usuario.class, idUsuario);
		peli.getPeliculas().add(resenapelicula);
		resenapelicula.setUsuario(usuario);		
	}

	@Transactional
	@Override
	public void EliminarResenaPelicula(int idPelicula, int idUsuario, ResenaPelicula resenapelicula) {
		Pelicula peli = em.find(Pelicula.class, idPelicula);
		Usuario usuario = em.find(Usuario.class, idUsuario);
		peli.getPeliculas().remove(resenapelicula);
		resenapelicula.setUsuario(usuario);		
	}

	@Transactional
	@Override
	public void ActualizarResenaPelicula(ResenaPelicula resenapelicula) {
		em.merge(resenapelicula);
		
	}

	@Override
	public List<ResenaPelicula> ListarResenasPelicula(int idPelicula) {
		List<ResenaPelicula> lista = new ArrayList<>();
		Query query = em.createQuery("select r from ResenaPelicula r where r.idPelicula = ?1");
		query.setParameter(1, idPelicula);
		lista = (List<ResenaPelicula>)query.getResultList();		
		return lista;
	}
	
	

}
