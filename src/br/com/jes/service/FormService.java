package br.com.jes.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class FormService {

	public String loadFile(String path) throws IOException {
		// Carregar arquivo em WEB-INF/classes
//		ClassLoader clazz = Thread.currentThread().getContextClassLoader();
//		InputStream stream = clazz.getResourceAsStream(path);
		
		URL url = new URL(path);
		URLConnection connection = url.openConnection();
		InputStream stream = connection.getInputStream();
		return readFromInputStream(stream);
	}
	
	public String replaceParameters(String content, Map<String, String> parameters) {
		String newContent = content;
		for (String parameter : parameters.keySet())
			newContent = newContent.replace(parameter, parameters.get(parameter));
		return newContent;
	}
	
	// Método auxiliar do loadFile(String path)
	private String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}
}
