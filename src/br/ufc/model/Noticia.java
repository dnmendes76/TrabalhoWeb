package br.ufc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity (name = "noticia")
public class Noticia {
	
	@Id
	@Column(name = "id_noticia", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_noticia;
	@NotNull
	private String titulo;
	private String subtitulo;
	@NotNull
	private String texto;
	private Date dataNoticia;
	
	//private long id_secao;
	// @Column(name = "path", nullable=false)
	// private String pathImage;
	
	@ManyToOne(fetch = FetchType.EAGER,
			optional = false)
	@JoinColumn ( name = "id_autor",
			referencedColumnName = "id_usuario")
	private Usuario autor;
	
	@ManyToOne(fetch = FetchType.EAGER,
			optional = false)
	@JoinColumn ( name = "id_secao",
			referencedColumnName = "id_secao")
	private Secao secao;
	
	@OneToMany(mappedBy = "noticia",
			targetEntity = Comentario.class,
			cascade = CascadeType.ALL)
	private List<Comentario> comentarios;

	//   ** GET'S and SET'S **	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public long getId_noticia() {
		return id_noticia;
	}

	public void setId_noticia(long id_noticia) {
		this.id_noticia = id_noticia;
	}
	

}
