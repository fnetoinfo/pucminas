package tcc.gestaoambiental.barragem.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Notificacao() {
		this.momento = LocalDate.now();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int nivel;		

	private String local;
	
	private String mensagem;
	
	private LocalDate momento;

	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public LocalDate getMomento() {
		return momento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
