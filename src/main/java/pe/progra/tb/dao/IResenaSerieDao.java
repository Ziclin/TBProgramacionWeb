package pe.progra.tb.dao;

import java.util.List;

import pe.progra.tb.entity.ResenaSerie;

public interface IResenaSerieDao {
	public void CrearResenaSerie(int idSerie, int idUsuario, ResenaSerie resenaserie);
	public void EliminarResenaSerie(int idSerie, int idUsuario, ResenaSerie resenaserie);
	public void ActualizarResenaSerie(ResenaSerie resenaserie);
	public List<ResenaSerie> ListarResenasSerie(int idSerie);
}
