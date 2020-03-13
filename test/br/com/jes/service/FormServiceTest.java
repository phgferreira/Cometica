package br.com.jes.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class FormServiceTest {
	
	private String path = "http://10.7.0.15/intranet/default_forms/form_test.html";

	@Test
	public void loadFileTest() {
		try {
			String result = new FormService().loadFile(path);
			System.out.println("Resultado:\n"+result);
			assertNotNull(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void replaceParametersTest() {
		String content = "açlkasmlçksdf:param1|sascs:param2lknsdf";
		Map<String, String> parameters = new TreeMap<String, String>();
		parameters.put(":param1", "|Teste1|");
		parameters.put(":param2", "|Teste2|");
		
		String result = new FormService().replaceParameters(content, parameters);
		
		assertTrue(result.contains("|Teste1|") && result.contains("|Teste2|"));
	}

}
