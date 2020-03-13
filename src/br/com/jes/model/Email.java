package br.com.jes.model;

public class Email {

	private String titulo;
	
	private String enderecos;
	
	private String conteudo;
	
	public Email(String titulo, String enderecos, String conteudo) {
		this.titulo = titulo;
		this.enderecos = enderecos;
		this.conteudo = conteudo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(String enderecos) {
		this.enderecos = enderecos;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
