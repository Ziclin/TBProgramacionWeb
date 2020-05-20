package pe.progra.tb.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.progra.tb.dao.ISerieDao;
import pe.progra.tb.entity.Actor;
import pe.progra.tb.entity.Serie;
import pe.progra.tb.service.ISerieService;

public class SerieServiceImpl implements ISerieService{
	
	@Inject
	private ISerieDao sDao;

	@Transactional
	public void RegistrarSerie(Serie serie) {
		sDao.RegistrarSerie(serie);
	}

	@Transactional
	public void EliminarSerie(int idSerie) {
		sDao.EliminarSerie(idSerie);
	}

	@Transactional
	public void ActualizarSerie(Serie serie) {
		sDao.ActualizarSerie(serie);
	}

	@Transactional
	public void InsertarActorSerie(int idSerie, Actor actor) {
		sDao.InsertarActorSerie(idSerie, actor);
	}

	@Transactional
	public void EliminarActorSerie(int idSerie, Actor actor) {
		sDao.EliminarActorSerie(idSerie, actor);
	}

	@Override
	public List<Serie> BuscarSerie(String nameSerie) {
		return sDao.BuscarSerie(nameSerie);
	}

	@Override
	public List<Actor> ListarActorSerie(int idSerie) {
		return sDao.ListarActorSerie(idSerie);
	}

	@Override
	public List<Serie> ListarSeries() {
		return sDao.ListarSeries();
	}



}
