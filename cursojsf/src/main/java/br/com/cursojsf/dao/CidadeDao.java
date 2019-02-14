package br.com.cursojsf.dao;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.cursojsf.model.Cidade;

/**
 * DAO da entidade Cidade.
 * @author Fabio Barros
 */
@ApplicationScoped
@ManagedBean(name = "cidadeDao")
public class CidadeDao extends SimpleDaoGenerico<Cidade> {

	/**
	 * Insere a cidade na base de dados.
	 * 
	 * @param cidade
	 *            Cidade a ser persistida.
	 */
	public void salvarCidade(Cidade cidade) {
		super.salvarEntidade(cidade);
	}

	/**
	 * Exclui a cidade na base de dados.
	 * 
	 * @param cidade
	 *            cidade a ser excluido
	 */
	public void excluirCidade(Cidade cidade) {
		super.excluirEntidade(cidade);
	}

	/**
	 * Seleciona as cidades que possuem atributos que correspondam aos atributos
	 * setados na cidade exemplo.
	 * 
	 * @param cidade
	 *            Cidade contendo os parametros da consulta.
	 * @return a cidade que corresponde ao parametro da consulta.
	 */
	public Cidade selecionar(Cidade cidade) {
		return super.selecionar(cidade);
	}

	/**
	 * Seleciona todos os registros aramzenados de um cidade {@link Cidade}.
	 * 
	 * @return lista de {@link Cidade}
	 */
	public List<Cidade> selecionarTodos() {
		return super.selecionarTodos();
	}

	/**
	 * Insere uma lista de cidades na base de dados.
	 * 
	 * @param cidades
	 *            Lista de cidades a serem persistida
	 */
	public void salvarCidades(List<Cidade> cidades) {
		if (cidades != null) {
			for (Cidade cidade : cidades) {
				salvarCidade(cidade);
			}
		}
	}
}
