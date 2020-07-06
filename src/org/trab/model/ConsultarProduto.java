package org.trab.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trab.dao.ProdutoDao;
import org.trab.pojo.Produto;

import com.google.gson.Gson;

public class ConsultarProduto implements Modelo {

@Override
public String executa(HttpServletRequest request, HttpServletResponse response) {
	int idproduto = Integer.parseInt(request.getParameter("idproduto"));
	
	ProdutoDao pdao = new ProdutoDao();
	Produto p = pdao.consultar(idproduto);
	Gson gson = new Gson();
	
	return gson.toJson(p);
}

}