package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Comentario;

@Repository
@Transactional
public class ComentarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Comentario coment){
		manager.persist(coment);		
	}
	
	public void atualizar(Comentario coment){
		manager.merge(coment);		
	}
	
	public void deletar(long id){
		Comentario dum = this.buscar(id);
		manager.remove(dum);
	}
	
	public Comentario buscar(long id){
		return manager.find(Comentario.class, id);
	}
	
	public List<Comentario> listar(){
		String hql = "select a from comentario as a";
		return manager.createQuery(hql, Comentario.class).getResultList();
	}
	
	public Comentario recuperar(long idNoticia){
		String hql = "select a from comentario as a where a.id_noticia = :paramLogin";
		Query query = manager.createQuery(hql);
		List<Comentario> comentarios = query.setParameter("paramLogin", idNoticia).getResultList();
		
		if(comentarios.size() != 0){
			return comentarios.get(0);
		}
		return null;
	}

}
