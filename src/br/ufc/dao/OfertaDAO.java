package br.ufc.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Oferta;

@Repository
@Transactional
public class OfertaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Oferta oferta){
		this.manager.persist(oferta);
	}
	
	public void atualizar(Oferta oferta){
		this.manager.merge(oferta);
	}
	
	
}