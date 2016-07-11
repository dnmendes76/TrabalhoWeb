package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import criptografia.Criptografia;
import br.ufc.model.Usuario;

@Repository
@Transactional
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Usuario user){
		Criptografia cript = new Criptografia();
		user.setSenha(cript.codifica(user.getSenha()));
		manager.persist(user);		
	}
	
	public void atualizar(Usuario user){
		manager.merge(user);		
	}
	
	public void deletar(long id){
		Usuario dum = this.buscar(id);
		manager.remove(dum);
	}
	
	public Usuario buscar(long id){
		Usuario aux = manager.find(Usuario.class, id);
		return aux;
	}
	
	public List<Usuario> listar(){
		String hql = "select u from usuario as u";
		return manager.createQuery(hql, Usuario.class).getResultList();
	}
	
	public Usuario recuperar(String login){
		String hql = "select u from usuario as u where u.login = :paramLogin";
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = query.setParameter("paramLogin", login).getResultList();
		
		if(usuarios.size() != 0){
			Usuario aux = usuarios.get(0);
			return aux;
		}
		return null;
	}

}
