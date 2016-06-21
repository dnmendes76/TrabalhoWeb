package br.ufc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table (name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "id_usuario", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
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
			fetch = FetchType.LAZY)
	private List<Classificado> classificados;
	
	@OneToMany(mappedBy = "autor",
			targetEntity = Comentario.class,
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy = "autor",
			targetEntity = Noticia.class,
			fetch = FetchType.LAZY)
	private List<Noticia> noticias;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "papel",
			joinColumns = @JoinColumn(name="id_usuario" ,
								referencedColumnName = "id_usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_papel",
										referencedColumnName = "id_papel")
	)
	private List<Papel> papeis;
	

}
