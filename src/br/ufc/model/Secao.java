package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity (name = "secao")
public class Secao {
	
	@Id
	@Column(name = "id_secao", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_secao;
	@NotNull
	private String titulo;
	private String descricao;
	
	@OneToMany(mappedBy="secao",
			targetEntity = Noticia.class,
			fetch = FetchType.EAGER)
	private List<Noticia> noticias;

	//  ** GET'S and SET'S **

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public long getId_secao() {
		return id_secao;
	}

	public void setId_secao(long id_secao) {
		this.id_secao = id_secao;
	}
	
	

}
