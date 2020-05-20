package pe.progra.tb.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IPeliculaDao;
import pe.progra.tb.entity.Actor;
import pe.progra.tb.entity.Pelicula;
import pe.progra.tb.service.IPeliculaService;

@Named
@RequestScoped
public class PeliculaServiceImpl implements IPeliculaService{
	
	@Inject
	private IPeliculaDao pDao;

	@Transactional
	public void RegistrarPelicula(Pelicula Pelicula) {
		pDao.RegistrarPelicula(Pelicula);
	}

	@Transactional
	public void EliminarPelicula(int idPelicula) {
		pDao.EliminarPelicula(idPelicula);
	}

	@Transactional
	public void ActualizarPelicula(Pelicula pelicula) {
		pDao.ActualizarPelicula(pelicula);
	}

	@Transactional
	public void InsertarActorPelicula(int idPelicula, Actor actor) {
		pDao.InsertarActorPelicula(idPelicula, actor);
	}

	@Transactional
	public void EliminarActorPelicula(int idPelicula, Actor actor) {
		pDao.EliminarActorPelicula(idPelicula, actor);
	}

	@Override
	public List<Pelicula> BuscarPelicula(String namePelicula) {
		return pDao.BuscarPelicula(namePelicula);
	}

	@Override
	public List<Pelicula> ListarPeliculas() {
		return pDao.ListarPeliculas();
	}

	@Override
	public List<Actor> ListarActorPeliculas(int idPelicula) {
		return pDao.ListarActorPeliculas(idPelicula);
	}
	

}
