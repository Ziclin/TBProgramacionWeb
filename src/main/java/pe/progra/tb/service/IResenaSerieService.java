package pe.progra.tb.service;

import java.util.List;

import pe.progra.tb.entity.ResenaSerie;

public interface IResenaSerieService {
	public void CrearResenaSerie(int idSerie, int idUsuario, ResenaSerie resenaserie);
	
	public void EliminarResenaSerie(int idSerie, int idUsuario, ResenaSerie resenaserie);
	
	public void ActualizarResenaSerie(ResenaSerie resenaserie);
	
	public List<ResenaSerie> ListarResenasSerie(int idSerie);
}
