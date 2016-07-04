package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "papel")
public class Papel {
	
	@Id
	@Column(name = "id_papel", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_papel;
	@NotNull
	private String papel;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="USUARIO_PAPEL",
			   joinColumns = @JoinColumn(name="id_papel", referencedColumnName="id_papel")
			)

	//  ** GET'S and SET'S **
	
	public long getId_papel() {
		return id_papel;
	}

	public void setId_papel(long id_papel) {
		this.id_papel = id_papel;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}

	
	
}
