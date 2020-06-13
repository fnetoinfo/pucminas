package tcc.gestaoambiental.barragem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;

@Entity
public class Local implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String nome;
	
	private	double latitude;
	
	private	double longitude;
	
	@OneToOne
    @JoinColumn(name = "notificacao_id")
	@Null
	private Notificacao notificacao;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}
	
}
