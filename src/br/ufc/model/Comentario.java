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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "comentario")
public class Comentario {
	
	@Id
	@Column(name = "id_comentario", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String texto;
	
	@ManyToOne(fetch = FetchType.LAZY,
			optional = false, 
			cascade = CascadeType.ALL)
	@JoinColumn ( name = "id_autor",
			referencedColumnName = "id_usuario")
	private Usuario autor;
	
	@ManyToOne(fetch = FetchType.LAZY,
			optional = false, 
			cascade = CascadeType.ALL)
	@JoinColumn ( name = "id_noticia",
			referencedColumnName = "id_noticia")
	private Noticia noticia;

	//   ** GET'S and SET'S **
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
	
	
}
