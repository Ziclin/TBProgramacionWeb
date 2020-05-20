package pe.progra.tb.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IActorDao;
import pe.progra.tb.entity.Actor;
import pe.progra.tb.service.IActorService;

public class ActorServiceImpl implements IActorService{

	@Inject
	private IActorDao aDao;
	
	@Transactional
	public void RegistrarActor(Actor actor) {
		aDao.RegistrarActor(actor);		
	}

	@Override
	public List<Actor> ListarActores() {
		return aDao.ListarActores();
	}

	@Transactional
	public void EliminarActor(int idActor) {
		aDao.EliminarActor(idActor);
	}

	@Transactional
	public void ActualizarActor(Actor actor) {
		aDao.ActualizarActor(actor);
	}

	@Override
	public List<Actor> BuscarActor(String nameActor) {
		return aDao.BuscarActor(nameActor);
	}

}
