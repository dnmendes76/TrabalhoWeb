package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="oferta")
public class Oferta {
	
	@Id
	@Column(name="id_oferta", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_oferta;
	private float preco;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOferta;
	
	@OneToOne(optional=false)
	@JoinColumn(name="id_usuario")
	private Usuario autorOferta;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "id_classificado", referencedColumnName = "id_classificado")
	private Classificado classificado;

	//    ** GET's and SET's
	
	public long getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(long id_oferta) {
		this.id_oferta = id_oferta;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Usuario getAutorOferta() {
		return autorOferta;
	}

	public void setAutorOferta(Usuario autorOferta) {
		this.autorOferta = autorOferta;
	}

	public Classificado getClassificado() {
		return classificado;
	}

	public void setClassificado(Classificado classificado) {
		this.classificado = classificado;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta() {
		this.dataOferta = new Date();
	}
	
	

}