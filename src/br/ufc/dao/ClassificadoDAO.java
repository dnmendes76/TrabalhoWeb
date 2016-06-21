package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Classificado;

@Repository
@Transactional
public class ClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Classificado classific){
		manager.persist(classific);		
	}
	
	public void atualizar(Classificado classifc){
		manager.merge(classifc);		
	}
	
	public void deletar(long id){
		Classificado dum = this.buscar(id);
		manager.remove(dum);
	}
	
	public Classificado buscar(long id){
		return manager.find(Classificado.class, id);
	}
	
	public List<Classificado> listar(){
		String hql = "select a from classificado as a";
		return manager.createQuery(hql, Classificado.class).getResultList();
	}
	
	

}
