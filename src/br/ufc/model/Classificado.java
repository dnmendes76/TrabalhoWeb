package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity(name = "classificado")
public class Classificado {
	
	@Id
	@Column(name = "id_classificado", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_classificado;
	@NotNull
	private String titulo;
	@NotNull
	private String texto;
	private float preco;
	private String telefone;
	
	@OneToOne(optional = true)
	@JoinColumn(name = "id_melhorOferta", referencedColumnName = "id_oferta")
	private Oferta melhorOferta;
	
	@ManyToOne(fetch = FetchType.EAGER,
			optional = true)
	@JoinColumn ( name = "id_autor",
			referencedColumnName = "id_usuario")	
	private Usuario autor;

	//  ** GET'S and SET'S **

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Oferta getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(Oferta melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public long getId_classificado() {
		return id_classificado;
	}

	public void setId_classificado(long id_classificado) {
		this.id_classificado = id_classificado;
	}	
	
}
