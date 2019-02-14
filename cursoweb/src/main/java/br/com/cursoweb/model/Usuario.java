package br.com.cursoweb.model;

public class Usuario {

	private String nome;

	private String email;
	
	private String sexo;

	public Usuario() {
		super();
	}

	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public Usuario(String nome, String email, String sexo) {
		super();
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
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
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
