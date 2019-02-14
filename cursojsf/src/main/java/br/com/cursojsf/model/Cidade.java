package br.com.cursojsf.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Define uma cidade de umestado da federacao.
 * 
 * @author Fabio Barros
 */
public class Cidade extends BaseModel implements Serializable {
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 310541246653623635L;

	/**
	 * Nome da cidade.
	 */
	private String nome;

	/**
	 * Quantidade de habitantes
	 */
	private Long populacao;

	/**
	 * Data da constituicao da cidade.
	 */
	private Date dataConstituicao;

	/**
	 * PIB da cidade;
	 */
	private Double pib;

	/**
	 * Estado ao qual a cidade pertence.
	 */
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}

	public Date getDataConstituicao() {
		return dataConstituicao;
	}

	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}

	public Double getPib() {
		return pib;
	}

	public void setPib(Double pib) {
		this.pib = pib;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
