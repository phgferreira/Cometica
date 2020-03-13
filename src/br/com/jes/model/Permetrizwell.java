package br.com.jes.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface Permetrizwell {

	public Map<String, String> getValuesInParameterForm() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException ;
}
