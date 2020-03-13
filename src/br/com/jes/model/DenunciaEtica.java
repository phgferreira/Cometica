package br.com.jes.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;

import br.com.jes.service.ModelService;

public class DenunciaEtica implements Permetrizwell {

	private Instituicao instituicao;
	
	private Denunciante denunciante;
	
	private Denunciado denunciado;
	
	private String ocorrencia;
	
	private String entregador;

	@Override
	public Map<String, String> getValuesInParameterForm() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ModelService mf = new ModelService();
		Map<String, String> parameters = new TreeMap<String, String>();
		parameters.putAll(mf.parameterValues(this));
		parameters.putAll(mf.parameterValues(instituicao));
		parameters.putAll(mf.parameterValues(denunciante));
		parameters.putAll(mf.parameterValues(denunciado));
		return parameters;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Denunciante getDenunciante() {
		return denunciante;
	}

	public void setDenunciante(Denunciante denunciante) {
		this.denunciante = denunciante;
	}

	public Denunciado getDenunciado() {
		return denunciado;
	}

	public void setDenunciado(Denunciado denunciado) {
		this.denunciado = denunciado;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}
	
}
