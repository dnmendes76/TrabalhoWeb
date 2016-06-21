package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Noticia;

@Repository
@Transactional
public class NoticiaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Noticia noticia){
		manager.persist(noticia);		
	}
	
	public void atualizar(Noticia noticia){
		manager.merge(noticia);		
	}
	
	public void deletar(long id){
		Noticia dum = this.buscar(id);
		manager.remove(dum);
	}
	
	public Noticia buscar(long id){
		return manager.find(Noticia.class, id);
	}
	
	public List<Noticia> listar(){
		String hql = "select a from noticia as a";
		return manager.createQuery(hql, Noticia.class).getResultList();
	}
	
	public Noticia recuperarSecao(long idSecao){
		String hql = "select a from noticia as a where a.id_secao = :paramLogin";
		Query query = manager.createQuery(hql);
		List<Noticia> comentarios = query.setParameter("paramLogin", idSecao).getResultList();
		
		if(comentarios.size() != 0){
			return comentarios.get(0);
		}
		return null;
	}

}
