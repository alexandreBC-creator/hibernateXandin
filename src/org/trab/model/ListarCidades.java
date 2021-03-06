package org.trab.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trab.dao.CidadeDao;
import org.trab.pojo.Cidade;

import com.google.gson.Gson;

public class ListarCidades implements Modelo {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response){
		try {
			CidadeDao cdao = new CidadeDao();
			List<Cidade> cidades = cdao.listar();
			Gson gson = new Gson();
			String json = gson.toJson(cidades);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
