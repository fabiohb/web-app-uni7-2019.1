package br.com.cursorws.model;

import java.io.Serializable;
import java.util.Date;

import javax.json.bind.annotation.JsonbTypeAdapter;

import br.com.cursorws.model.adapter.DateAdapter;

public class Usuario extends BaseModel implements Serializable {

	private static final long serialVersionUID = -3064306490724801147L;

	private String cpf;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	@JsonbTypeAdapter(DateAdapter.class)
	private Date data;

	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		this();
		setId(id);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}