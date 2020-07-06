package org.trab.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trab.dao.PessoaDao;
import org.trab.pojo.Pessoa;

import com.google.gson.Gson;

public class ListarPessoas implements Modelo {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			PessoaDao pdao = new PessoaDao();
			List<Pessoa> lista = pdao.listar();
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

