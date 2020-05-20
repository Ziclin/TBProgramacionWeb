package pe.progra.tb.dao;

import java.util.List;

import pe.progra.tb.entity.Actor;
import pe.progra.tb.entity.Serie;

public interface ISerieDao {
	public void RegistrarSerie(Serie serie);
	public void EliminarSerie(int idSerie);
	public void ActualizarSerie(Serie serie);
	public void InsertarActorSerie(int idSerie, Actor actor);
	public void EliminarActorSerie(int idSerie, Actor actor);
	public List<Serie> BuscarSerie(String nameSerie);
	public List<Actor> ListarActorSerie(int idSerie);
	public List<Serie> ListarSeries();
	
	
}
