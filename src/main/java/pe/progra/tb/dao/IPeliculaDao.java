package pe.progra.tb.dao;

import java.util.List;

import pe.progra.tb.entity.Actor;
import pe.progra.tb.entity.Pelicula;

public interface IPeliculaDao {
	public void RegistrarPelicula(Pelicula pelicula);
	public void EliminarPelicula(int idPelicula);
	public void ActualizarPelicula(Pelicula pelicula);
	public void InsertarActorPelicula(int idPelicula, Actor actor);
	public void EliminarActorPelicula(int idPelicula, Actor actor);
	public List<Pelicula> BuscarPelicula(String namePelicula);
	public List<Actor> ListarActorPeliculas(int idPelicula);
	public List<Pelicula> ListarPeliculas();
}
