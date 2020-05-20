package pe.progra.tb.dao;

import java.util.List;

import pe.progra.tb.entity.ResenaPelicula;

public interface IResenaPeliculaDao {
	public void CrearResenaPelicula(int idPelicula, int idUsuario, ResenaPelicula resenapelicula);
	public void EliminarResenaPelicula(int idPelicula, int idUsuario, ResenaPelicula resenapelicula);
	public void ActualizarResenaPelicula(ResenaPelicula resenapelicula);
	public List<ResenaPelicula> ListarResenasPelicula(int idPelicula);
}
