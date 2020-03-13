package br.com.jes.model;

public class ContaEmail {

	private String servidor;
	
	private String porta;

	private String endereco;

	private String usuario;
	
	private String senha;

	public ContaEmail(String servidor, String porta, String endereco, String usuario, String senha) {
		this.servidor = servidor;
		this.porta = porta;
		this.endereco = endereco;
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
