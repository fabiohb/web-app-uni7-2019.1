package br.com.cursojsf.model;

import java.io.Serializable;
import java.util.List;

/**
 * Define um estado da federacao.
 * 
 * @author Fabio Barros
 */
public class Estado extends BaseModel implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1962391368025442461L;

	/**
	 * Nome do estado.
	 */
	private String nome;

	/**
	 * Sigla do estado.
	 */
	private String sigla;

	/**
	 * Cidades pertendcentes ao estado.
	 */
	private List<Cidade> cidades;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}
