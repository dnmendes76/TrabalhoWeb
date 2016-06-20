package br.ufc.model;

import java.util.List;

public class Usuario {
	
	private long id;
	private String nome;
	private String login;
	private String senha;
	private String email;
	
//	private String pathImage;
	
	private List<Classificado> classificados;
	private List<Comentario> comentarios;
	private List<Noticia> noticias;
	private List<Papel> papeis;
	

}
