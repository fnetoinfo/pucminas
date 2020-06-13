package tcc.gestaoambiental.barragem.messages;

import java.io.Serializable;

public class NotificacaoMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private int nivel;
	private String local;
	private String mensagem;
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
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

}
