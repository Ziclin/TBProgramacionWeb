package pe.progra.tb.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IUsuarioDao;
import pe.progra.tb.entity.Usuario;
import pe.progra.tb.service.IUsuarioService;

public class UsuarioServiceImpl implements IUsuarioService{
	
	@Inject
	private IUsuarioDao uDao;

	@Transactional
	public void RegistrarUsuario(Usuario usuario) {
		uDao.RegistrarUsuario(usuario);
	}

	@Transactional
	public void EliminarUsuario(int idUsuario) {
		uDao.EliminarUsuario(idUsuario);
	}

	@Transactional
	public void RegistrarAdministrador(Usuario usuario) {
		uDao.RegistrarAdministrador(usuario);
	}

	@Transactional
	public void EliminarAdministrador(int idAdministrador) {
		uDao.EliminarAdministrador(idAdministrador);
	}

	@Override
	public boolean AutenticarUsuario(Usuario usuario) {
		return uDao.AutenticarUsuario(usuario);
	}

	@Override
	public List<Usuario> ListarUsuarios() {
		return uDao.ListarUsuarios();
	}

	

}
