package pe.progra.tb.dao;

import java.util.List;

import pe.progra.tb.entity.Actor;

public interface IActorDao {
	public void RegistrarActor(Actor actor);
	public List<Actor> ListarActores();
	public void EliminarActor(int idActor);
	public void ActualizarActor(Actor actor);
	public List<Actor> BuscarActor(String nameActor);
}
