package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "papel")
public class Papel {
	
	@Id
	@Column(name = "id_papel", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String papel;
	
	@ManyToMany(mappedBy = "papeis",
			fetch= FetchType.LAZY)
	private List<Usuario> usuarios;

	//  ** GET'S and SET'S **
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	
}
