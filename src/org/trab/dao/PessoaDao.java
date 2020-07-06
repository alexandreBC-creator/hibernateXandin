package org.trab.dao;


import java.util.List;
import org.hibernate.Transaction;
import org.trab.pojo.Pessoa;
import org.hibernate.Session;
import org.trab.hibernate.HibernateUtil;

public class PessoaDao {

	public void salvar(Pessoa p) {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.saveOrUpdate(p);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Pessoa> listar() {
		List<Pessoa> lista = null; 
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			lista = session.createQuery("from Pessoa").getResultList();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Pessoa consultar(int id) {
		Pessoa p = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			p = (Pessoa) session.createQuery("from Pessoa WHERE idpessoa = " + id).getSingleResult();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public void excluir(int id) {
		Pessoa p = consultar(id);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.delete(p);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
