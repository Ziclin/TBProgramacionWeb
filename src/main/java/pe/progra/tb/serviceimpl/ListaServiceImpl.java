package pe.progra.tb.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IListaDao;
import pe.progra.tb.entity.Lista;
import pe.progra.tb.entity.Pelicula;
import pe.progra.tb.entity.Serie;
import pe.progra.tb.service.IListaService;

public class ListaServiceImpl implements IListaService{
	
	@Inject
	private IListaDao lDao;

	@Transactional
	public void CrearLista(Lista lista) {
		lDao.CrearLista(lista);
	}

	@Transactional
	public void EliminarLista(int idLista) {
		lDao.EliminarLista(idLista);
	}

	@Transactional
	public void InsertarPeliculaLista(int idLista, Pelicula pelicula) {
		lDao.InsertarPeliculaLista(idLista,pelicula);
	}

	@Transactional
	public void InsertarSerieLista(int idLista, Serie serie) {
		lDao.InsertarSerieLista(idLista, serie);
	}

	@Transactional
	public void EliminarPeliculaLista(int idLista, Pelicula pelicula) {
		lDao.EliminarPeliculaLista(idLista, pelicula);
	}

	@Transactional
	public void EliminarSerieLista(int idLista, Serie serie) {
		lDao.EliminarSerieLista(idLista, serie);
	}

	@Override
	public List<Lista> ListarListasUsuario(int idUsuario) {
		return lDao.ListarListasUsuario(idUsuario);
	}

}
