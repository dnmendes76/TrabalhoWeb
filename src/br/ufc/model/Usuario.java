package br.ufc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "id_usuario", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_usuario;
	private String nome;
	@NotNull
	private String login;
	@NotNull
	private String senha;
	@NotNull
	private String email;
	
//	private String pathImage;

	@OneToMany(mappedBy = "autor",
			targetEntity = Classificado.class,
			fetch = FetchType.EAGER)
	private List<Classificado> classificados;
	
	@OneToMany(mappedBy = "autor",
			targetEntity = Comentario.class,
			fetch = FetchType.EAGER)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy = "autor",
			targetEntity = Noticia.class,
			fetch = FetchType.EAGER)
	private List<Noticia> noticias;
	
	@ManyToMany (fetch = FetchType.EAGER)
	private List<Papel> papeis;

	//  ** GET'S and SET'S **	
	
	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Classificado> getClassificados() {
		return classificados;
	}

	public void setClassificados(List<Classificado> classificados) {
		this.classificados = classificados;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	
	

}
