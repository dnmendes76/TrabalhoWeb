package br.ufc.controller;

import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		u.setNome("Fulano");
		u.setLogin("login");
		u.setSenha("senha");
		u.setEmail("email");
		
		UsuarioDAO udao = new UsuarioDAO();
		
		udao.inserir(u);
//		System.out.println("deu certo :)");
		System.out.println(udao.buscar(0L).getLogin());
		
		
	}

}
