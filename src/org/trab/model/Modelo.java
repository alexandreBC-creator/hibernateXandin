package org.trab.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Modelo {
	public String executa(HttpServletRequest request, 
			HttpServletResponse response);
}
