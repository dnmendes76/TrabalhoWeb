package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Papel;

@Repository
@Transactional
public class PapelDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Papel paper){
		manager.persist(paper);		
	}
	
	public void atualizar(Papel paper){
		manager.merge(paper);		
	}
	
	public void deletar(long id){
		Papel dum = this.buscar(id);
		manager.remove(dum);
	}
	
	public Papel buscar(long id){
		return manager.find(Papel.class, id);
	}
	
	public List<Papel> listar(){
		String hql = "select a from papel as a";
		return manager.createQuery(hql, Papel.class).getResultList();
	}

}
