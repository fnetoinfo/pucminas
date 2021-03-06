package tcc.gestaoambiental.barragem.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;

	public String getNome() {
		return nome;
	}

	public void setNomeRole(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nome;
	}

}