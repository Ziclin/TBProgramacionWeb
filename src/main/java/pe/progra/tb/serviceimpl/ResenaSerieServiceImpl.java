package pe.progra.tb.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IResenaSerieDao;
import pe.progra.tb.entity.ResenaSerie;
import pe.progra.tb.service.IResenaSerieService;

public class ResenaSerieServiceImpl implements IResenaSerieService{
	
	@Inject
	private IResenaSerieDao rsDao;

	@Transactional
	public void CrearResenaSerie(int idSerie, int idUsuario, ResenaSerie resenaserie) {
		rsDao.CrearResenaSerie(idSerie, idUsuario, resenaserie);
		
	}

	@Transactional
	public void EliminarResenaSerie(int idSerie, int idUsuario, ResenaSerie resenaserie) {
		rsDao.EliminarResenaSerie(idSerie, idUsuario, resenaserie);
	}

	@Transactional
	public void ActualizarResenaSerie(ResenaSerie resenaserie) {
		rsDao.ActualizarResenaSerie(resenaserie);
	}

	@Override
	public List<ResenaSerie> ListarResenasSerie(int idSerie) {
		return rsDao.ListarResenasSerie(idSerie);
	}

	

}
