package org.trab.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.trab.dao.PessoaDao;
import org.trab.dao.ProdutoDao;
import org.trab.dao.VendaDao;
import org.trab.pojo.Pessoa;
import org.trab.pojo.Produto;
import org.trab.pojo.Venda;


public class SalvarVenda implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			if (request.getParameter("idvenda")==null) {
				return "idvenda obrigat�rio!";
			}
			if (request.getParameter("pessoa")==null) {
				return "Cliente obrigat�rio!";
			}
			if (request.getParameter("pessoa").equals("")) {
				return "Cliente obrigat�rio!";
			}
			if (request.getParameter("produto")==null) {
				return "Produto obrigat�rio!";
			}
			if (request.getParameter("produto").equals("")) {
				return "Produto obrigat�rio!";
			}
			if (request.getParameter("data")==null) {
				return "Data obrigat�rio!";
			}
			if (request.getParameter("data").equals("")) {
				return "Data obrigat�rio!";
			}
			if (request.getParameter("quantidade")==null) {
				return "Quantidade obrigat�rio!";
			}
			if (request.getParameter("quantidade").equals("")) {
				return "Quantidade obrigat�rio!";
			}
			if (request.getParameter("valorunitario")==null) {
				return "Valor unit�rio obrigat�rio!";
			}
			if (request.getParameter("valorunitario").equals("")) {
				return "Valor unit�rio obrigat�rio!";
			}
			
			Venda v = new Venda();
			
			PessoaDao pdao = new PessoaDao();
			Pessoa p = pdao.consultar(Integer.parseInt(request.getParameter("pessoa")));
			v.setPessoa(p);
			
			ProdutoDao ptdao = new ProdutoDao();
			Produto pt = ptdao.consultar(Integer.parseInt(request.getParameter("produto")));
			v.setProduto(pt);
			
			v.setData(request.getParameter("data"));
			v.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			v.setValorunitario(Double.parseDouble(request.getParameter("valorunitario")));
			v.setValortotal(Double.parseDouble(request.getParameter("valortotal")));
			
			VendaDao vdao = new VendaDao();
			vdao.salvar(v);
			
			return "Sucesso ao salvar dados!";
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}