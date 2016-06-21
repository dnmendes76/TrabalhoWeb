package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Secao;

@Repository
@Transactional
public class SecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Secao secao){
		manager.persist(secao);		
	}
	
	public void atualizar(Secao secao){
		manager.merge(secao);		
	}
	
	public void deletar(long id){
		Secao dum = this.buscar(id);
		manager.remove(dum);
	}
	
	public Secao buscar(long id){
		return manager.find(Secao.class, id);
	}
	
	public List<Secao> listar(){
		String hql = "select a from secao as a";
		return manager.createQuery(hql, Secao.class).getResultList();
	}

}
