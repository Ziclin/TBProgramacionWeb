package pe.progra.tb.daoimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.progra.tb.dao.IUsuarioDao;
import pe.progra.tb.entity.Actor;
import pe.progra.tb.entity.ResenaSerie;
import pe.progra.tb.entity.Serie;
import pe.progra.tb.entity.Usuario;

public class UsuarioDaoImpl implements IUsuarioDao, Serializable{

	@PersistenceContext(unitName = "TB")
	private EntityManager em;

	@Transactional
	@Override
	public void RegistrarUsuario(Usuario usuario) {
		em.persist(usuario);	
	}

	@Transactional
	@Override
	public void EliminarUsuario(int idUsuario) {
		Usuario usuario = new Usuario();
		usuario = em.getReference(Usuario.class, idUsuario);
		em.remove(usuario);
		
	}

	@Transactional
	@Override
	public void RegistrarAdministrador(Usuario administrador) {
		em.persist(administrador);	
	}

	@Transactional
	@Override
	public void EliminarAdministrador(int idAdministrador) {	
		Usuario administrador = new Usuario();
		administrador = em.getReference(Usuario.class, idAdministrador);
		em.remove(administrador);	
	}

	@Transactional
	@Override
	public boolean AutenticarUsuario(Usuario usuario) {		
		TypedQuery<Usuario> query = em.createQuery("select l from Usuario l where l.emailUsuario = :emailUsuario AND l.passwordUsuario = :passwordUsuario", Usuario.class );
		query.setParameter("emailUsuario", usuario.getEmailUsuario());
		query.setParameter("emailPassword", usuario.getPasswordUsuario());
		try {
			Usuario u = query.getSingleResult();
			return true;
		}
		catch(javax.persistence.NoResultException e) {
			return false;
		}
	}

	@Override
	public List<Usuario> ListarUsuarios() {
		List<Usuario> lista = new ArrayList<>();
		Query query = em.createQuery("select u from Usuario u");
		      lista = (List<Usuario>)query.getResultList();		
		return lista;
	}
	
	
}
