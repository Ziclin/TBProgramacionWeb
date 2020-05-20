package pe.progra.tb.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IResenaSerieDao;
import pe.progra.tb.entity.ResenaSerie;
import pe.progra.tb.entity.Serie;
import pe.progra.tb.entity.Usuario;

public class ResenaSerieDaoImpl implements IResenaSerieDao, Serializable{

	@PersistenceContext(unitName = "TB") 
	private EntityManager em;

	@Transactional
	@Override
	public void CrearResenaSerie(int idSerie, int idUsuario, ResenaSerie resenaserie) {
		Serie serie = em.find(Serie.class, idSerie);
		Usuario usuario = em.find(Usuario.class, idUsuario);
		serie.getSeries().add(resenaserie);
		resenaserie.setUsuarioserie(usuario);
	}

	@Transactional
	@Override
	public void EliminarResenaSerie(int idSerie, int idUsuario, ResenaSerie resenaserie) {
		Serie serie = em.find(Serie.class, idSerie);
		Usuario usuario = em.find(Usuario.class, idUsuario);
		serie.getSeries().remove(resenaserie);
		resenaserie.setUsuarioserie(usuario);
	}

	@Transactional
	@Override
	public void ActualizarResenaSerie(ResenaSerie resenaserie) {
		em.merge(resenaserie);
	}

	@Override
	public List<ResenaSerie> ListarResenasSerie(int idSerie) {
		List<ResenaSerie> lista = new ArrayList<>();
		Query query = em.createQuery("select r from ResenaSerie r where r.idSerie = ?1");
		query.setParameter(1, idSerie);
		lista = (List<ResenaSerie>)query.getResultList();		
		return lista;
	}

	
	

}
