package br.com.jes.service;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.junit.jupiter.api.Test;

import br.com.jes.model.DenunciaEtica;
import br.com.jes.model.Denunciado;
import br.com.jes.model.Denunciante;
import br.com.jes.model.Instituicao;

class ModelServiceTest {

	@Test
	public void getValuesInParametersFormTest() {
		
		// Instancia objetos
		DenunciaEtica denuncia = new DenunciaEtica();
		denuncia.setInstituicao(new Instituicao());
		denuncia.setDenunciante(new Denunciante());
		denuncia.setDenunciado(new Denunciado());
		
		// Preenche dados da Instituição
		denuncia.getInstituicao().setNome("Hospital Santa Teresa");
		denuncia.getInstituicao().setEndereco("Rua Paulino Afonso, N] 477");
		denuncia.getInstituicao().setBairro("Bingen");
		denuncia.getInstituicao().setCidade("Petrópolis");
		denuncia.getInstituicao().setCep("25684-900");
		denuncia.getInstituicao().setTelefone("(24) 2233 - 4600");
		
		// Preenche dados do Denunciante
		denuncia.getDenunciante().setNome("Fulano Denunciante");
		denuncia.getDenunciante().setNacionalidade("Brasileiro");
		denuncia.getDenunciante().setProfissao("Enfermeiro");
		denuncia.getDenunciante().setCpf("111.222.333-44");
		denuncia.getDenunciante().setEndereco("Rua Qualquer, Nº 1");
		denuncia.getDenunciante().setBairro("Bairro da Caixa'd Água");
		denuncia.getDenunciante().setCidade("Horópolis");
		denuncia.getDenunciante().setCep("12345-678");
		denuncia.getDenunciante().setTelefone("(xx) yyyy - zzzz");
		
		// Preenche dados do Denunciado
		denuncia.getDenunciado().setNome("Fulano Denunciado");
		denuncia.getDenunciado().setNacionalidade("Argentino");
		denuncia.getDenunciado().setProfissao("Auxiliar de Enfermagem");
		denuncia.getDenunciado().setCpf("555.666.777-88");
		denuncia.getDenunciado().setEndereco("Rua Outra Qualquer, Nº 25");
		denuncia.getDenunciado().setBairro("Bairro Inexistente do Lado");
		denuncia.getDenunciado().setCidade("Argentileno");
		denuncia.getDenunciado().setCep("34567-891");
		denuncia.getDenunciado().setTelefone("(zz) xxxx - yyyy");
		denuncia.getDenunciado().setCategoria("Que categoria?");
		denuncia.getDenunciado().setCoren("12345");
		
		// Informa ocorrencia
		denuncia.setOcorrencia("Fizeram besteira!");
		
		Map<String, String> result = null;
		try {
			result = denuncia.getValuesInParameterForm();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		for (String key : result.keySet())
			System.out.println(key+" = "+result.get(key));
		
		assertNotNull(result);
	}

}
