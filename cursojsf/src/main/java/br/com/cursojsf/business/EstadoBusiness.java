package br.com.cursojsf.business;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.cursojsf.dao.CidadeDao;
import br.com.cursojsf.dao.EstadoDao;
import br.com.cursojsf.model.Cidade;
import br.com.cursojsf.model.Estado;

/**
 * Classe de regra de negocio para a entidade Estado.
 * 
 * @author Fabio Barros
 */
@ApplicationScoped
@ManagedBean(name = "estadoBusiness")
public class EstadoBusiness {

	@ManagedProperty("#{estadoDao}")
	private EstadoDao estadoDao;

	@ManagedProperty("#{cidadeDao}")
	private CidadeDao cidadeDao;

	public void setEstadoDao(EstadoDao estadoDao) {
		this.estadoDao = estadoDao;
	}

	public void setCidadeDao(CidadeDao cidadeDao) {
		this.cidadeDao = cidadeDao;
	}

	/**
	 * Insere o estado na base de dados.
	 * 
	 * @param estado
	 *            Estado a ser persistido.
	 * @throws PibInalidoException
	 *             Caso o valor do PIB de uma cidade seja menor que a populacao
	 */
	public void salvarEstado(Estado estado) throws PibInalidoException {
		validarCidades(estado);
		cidadeDao.salvarCidades(estado.getCidades());
		estadoDao.salvarEstado(estado);
	}

	private void validarCidades(Estado estado) throws PibInalidoException {
		if (estado.getCidades() != null) {
			for (Cidade cidade : estado.getCidades()) {
				Double populacao = cidade.getPopulacao().doubleValue();
				if (populacao.compareTo(cidade.getPib()) > 0) {
					throw new PibInalidoException();
				} else {
					cidade.setEstado(estado);
				}
			}
		}
	}

	/**
	 * Exclui o estado na base de dados.
	 * 
	 * @param estado
	 *            estado a ser excluido
	 */
	public void excluirEstado(Estado estado) {
		estadoDao.excluirEstado(estado);
	}

	/**
	 * Seleciona todos os registros aramzenados de um estado {@link Estado}.
	 * 
	 * @return lista de {@link Estado}
	 */
	public Estado selecionar(Estado estado) {
		return estadoDao.selecionar(estado);
	}

	/**
	 * Seleciona os estados que possuem atributos que correspondam aos atributos
	 * setados no estado exemplo.
	 * 
	 * @param estado
	 *            Estado contendo os parametros da consulta.
	 * @return a estado que corresponde ao parametro da consulta.
	 */
	public List<Estado> selecionarTodos() {
		return estadoDao.selecionarTodos();
	}
}
