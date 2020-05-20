package pe.progra.tb.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IResenaPeliculaDao;
import pe.progra.tb.entity.ResenaPelicula;
import pe.progra.tb.service.IResenaPeliculaService;

public class ResenaPeliculaServiceImpl implements IResenaPeliculaService{
	
	@Inject
	private IResenaPeliculaDao rpDao;

	@Transactional
	public void CrearResenaPelicula(int idPelicula, int idUsuario, ResenaPelicula resenapelicula) {
		rpDao.CrearResenaPelicula(idPelicula, idUsuario, resenapelicula);
	}

	@Transactional
	public void EliminarResenaPelicula(int idPelicula, int idUsuario, ResenaPelicula resenapelicula) {
		rpDao.EliminarResenaPelicula(idPelicula, idUsuario, resenapelicula);
	}

	@Transactional
	public void ActualizarResenaPelicula(ResenaPelicula resenapelicula) {
		rpDao.ActualizarResenaPelicula(resenapelicula);
	}

	@Override
	public List<ResenaPelicula> ListarResenasPelicula(int idPelicula) {
		return rpDao.ListarResenasPelicula(idPelicula);
	}

	

}
