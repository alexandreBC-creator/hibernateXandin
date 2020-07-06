package org.trab.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trab.dao.VendaDao;
import org.trab.pojo.Venda;

import com.google.gson.Gson;

public class ConsultarVenda implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		int idvenda = Integer.parseInt(request.getParameter("idvenda"));
		
		VendaDao vdao = new VendaDao();
		Venda v = vdao.consultar(idvenda);
		Gson gson = new Gson();
		
		return gson.toJson(v);
	}

}
