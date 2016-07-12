package br.ufc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity (name = "comentario")
public class Comentario {
	
	@Id
	@Column(name = "id_comentario", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_comentario;
	@NotNull
	private String texto;
	
	@ManyToOne(fetch = FetchType.EAGER,
			optional = false)
	@JoinColumn ( name = "id_autor",
			referencedColumnName = "id_usuario")
	private Usuario autor;
	
	@ManyToOne(fetch = FetchType.EAGER,
			optional = false)
	@JoinColumn ( name = "id_noticia",
			referencedColumnName = "id_noticia")
	private Noticia noticia;

	//   ** GET'S and SET'S **
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(long id_comentario) {
		this.id_comentario = id_comentario;
	}
	
	
	
}
