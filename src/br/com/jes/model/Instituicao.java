package br.com.jes.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import br.com.jes.service.ModelService;

public class Instituicao implements Permetrizwell{

	private String nome;
	
	private String endereco;
	
	private String bairro;
	
	private String cidade;
	
	private String cep;
	
	private String telefone;

	@Override
	public Map<String, String> getValuesInParameterForm() throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		return new ModelService().parameterValues(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
