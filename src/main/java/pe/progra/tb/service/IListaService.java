package pe.progra.tb.service;

import java.util.List;

import pe.progra.tb.entity.Lista;
import pe.progra.tb.entity.Pelicula;
import pe.progra.tb.entity.Serie;

public interface IListaService {
	public void CrearLista(Lista lista);
	
	public void EliminarLista(int idLista);
	
	public void InsertarPeliculaLista(int idLista, Pelicula pelicula);
	
	public void InsertarSerieLista(int idLista, Serie serie);
	
	public void EliminarPeliculaLista(int idLista, Pelicula pelicula);
	
	public void EliminarSerieLista(int idLista, Serie serie);
	
	public List<Lista> ListarListasUsuario(int idUsuario);
}
