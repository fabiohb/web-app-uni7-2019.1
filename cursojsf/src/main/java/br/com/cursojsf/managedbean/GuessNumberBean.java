package br.com.cursojsf.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@SessionScoped
@ManagedBean(name = "guessBean")
public class GuessNumberBean {
	/** Numero a ser adivinado. */
	private Integer numero;

	/** Palpite do usuário. */
	private Integer palpite;

	/** Tentativas. */
	private Integer tentativas;

	/** Mensagem de erro. */
	private String mensagem;

	public Integer getPalpite() {
		return palpite;
	}

	public void setPalpite(Integer palpite) {
		this.palpite = palpite;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String init() {
		numero = (int) (1 + (Math.random() * 100));
		palpite = null;
		tentativas = 0;
		mensagem = "page.guess.label.branco";
		return "guess";
	}

	public String guess() {
		if (palpite.equals(numero)) {
			mensagem = "page.guess.acerto";
		} else if (numero.compareTo(palpite) < 0) {
			mensagem = "page.guess.menor";
		} else {
			mensagem = "page.guess.maior";
		}
		tentativas++;
		return "guess";
	}

	public void onChange(ValueChangeEvent event) {
		if (event.getNewValue() == null) {
			mensagem = "page.guess.digiteNumero";
		} else {
			mensagem = "page.guess.label.branco";
		}
	}
}