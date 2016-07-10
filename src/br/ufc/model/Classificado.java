package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity(name = "classificado")
public class Classificado {
	
	@Id
	@Column(name = "id_classificado", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String titulo;
	@NotNull
	private String texto;
	private float preco;
	private String telefone;
	private float melhorOferta;
	private Date dataOferta;
	
	@ManyToOne(fetch = FetchType.EAGER,
			optional = true)
	@JoinColumn ( name = "id_autor",
			referencedColumnName = "id_usuario")	
	private Usuario autor;

	//  ** GET'S and SET'S **
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public float getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(float melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	
	
}
