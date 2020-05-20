package pe.progra.tb.service;

import java.util.List;

import pe.progra.tb.entity.Usuario;

public interface IUsuarioService {
	public void RegistrarUsuario(Usuario usuario);
	
	public void EliminarUsuario(int idUsuario);
	
	public void RegistrarAdministrador(Usuario usuario);
	
	public void EliminarAdministrador(int idAdministrador);
	
	public boolean AutenticarUsuario(Usuario usuario);
	
	public List<Usuario> ListarUsuarios();
}
