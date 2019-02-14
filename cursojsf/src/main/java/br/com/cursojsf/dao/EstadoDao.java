package br.com.cursojsf.dao;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.cursojsf.model.Estado;

/**
 * DAO da entidade Estado.
 * 
 * @author Fabio Barros
 */
@ApplicationScoped
@ManagedBean(name = "estadoDao")
public class EstadoDao extends SimpleDaoGenerico<Estado> {

	public EstadoDao() {
		for (int i = 1; i <= 10; i++) {
			Estado estado = new Estado();
			estado.setNome("Nome do estado " + i);
			estado.setSigla("EST" + i);
			salvarEntidade(estado);
		}
	}

	/**
	 * Insere o estado na base de dados.
	 * 
	 * @param estado
	 *            Estado a ser persistida.
	 */
	public void salvarEstado(Estado estado) {
		super.salvarEntidade(estado);
	}

	/**
	 * Exclui o estado na base de dados.
	 * 
	 * @param estado
	 *            estado a ser excluido
	 */
	public void excluirEstado(Estado estado) {
		super.excluirEntidade(estado);
	}

	/**
	 * Seleciona todos os registros aramzenados de um estado {@link Estado}.
	 * 
	 * @return lista de {@link Estado}
	 */
	@Override
	public Estado selecionar(Estado estado) {
		return super.selecionar(estado);
	}

	/**
	 * Seleciona as estados que possuem atributos que correspondam aos atributos
	 * setados no estado exemplo.
	 * 
	 * @param estado
	 *            Estado contendo os parametros da consulta.
	 * @return a estado que corresponde ao parametro da consulta.
	 */
	@Override
	public List<Estado> selecionarTodos() {
		return super.selecionarTodos();
	}

}
