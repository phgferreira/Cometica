package br.com.jes.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import br.com.jes.model.Permetrizwell;

public class ModelService {

	public Map<String, String> parameterValues(Permetrizwell entity) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Map<String, String> parameters = new HashMap<String, String>();
		for (Field field : entity.getClass().getDeclaredFields())
			// Se o campo for uma variável primária então insere o parametro e valor
			if (	field.getType().toString().equals("class java.lang.String") ||
					field.getType().toString().equals("class java.lang.Double") ||
					field.getType().toString().equals("class java.lang.Integer") ||
					field.getType().toString().equals("double") ||
					field.getType().toString().equals("int"))
				parameters.put(":"+entity.getClass().getSimpleName()+"_"+field.getName(), getValueByMethod(entity, field));
		return parameters;
	}
	
	private String getValueByMethod(Permetrizwell entity, Field field) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// Monta o nome do método get
		String methodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
		// Invoka o método e converte o valor para String
		String result = null;
		try {
			result = entity.getClass().getMethod(methodName, null).invoke(entity, null).toString();
		} catch (NullPointerException e) {
			result = "";
		}
		return result;
	}

}
