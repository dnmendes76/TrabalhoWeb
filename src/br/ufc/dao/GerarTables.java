package br.ufc.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTables {

	public static void main(String[] args) {
		System.out.println("aqui :)");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste_aula_cc");
		System.out.println("dfghj");
		factory.close();
	}

}
