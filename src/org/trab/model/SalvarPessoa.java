package org.trab.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trab.dao.CidadeDao;
import org.trab.dao.PessoaDao;
import org.trab.pojo.Cidade;
import org.trab.pojo.Pessoa;

public class SalvarPessoa implements Modelo {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (request.getParameter("idpessoa")==null) {
				return "idpessoa é obrigatório!";
			}
			if (request.getParameter("nome")==null) {
				return "nome é obrigatório!";
			}
			if (request.getParameter("nome").equals("")) {
				return "nome é obrigatório!";
			}
			Pessoa p = new Pessoa();
			p.setIdpessoa(Integer.parseInt(request.getParameter("idpessoa")));
			p.setNome(request.getParameter("nome"));
			
			CidadeDao cdao = new CidadeDao();
			Cidade c = cdao.consultar(Integer.parseInt(request.getParameter("cidade")));
			p.setTelefone(request.getParameter("telefone"));
			p.setCidade(c);
			p.setBairro(request.getParameter("bairro"));
			p.setEndereço(request.getParameter("endereco"));
			PessoaDao pdao = new PessoaDao();
			pdao.salvar(p);
			if(p.getIdpessoa() > 0) {
				return "update";
			}else {
				return "insert";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
