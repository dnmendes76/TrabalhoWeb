package br.ufc.model;

import java.util.Date;
import java.util.List;

public class Noticia {
	
	private long id;
	private String titulo;
	private String subtitulo;
	private String texto;
	private Date dataNoticia;
	
	private long id_secao;
	// private String pathImage;
	
	private Usuario autor;
	private Secao secao;
	private List<Comentario> comentarios;
	
	

}
