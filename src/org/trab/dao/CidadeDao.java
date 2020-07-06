package org.trab.dao;

import java.util.List;

import org.trab.pojo.Cidade;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.trab.hibernate.HibernateUtil;
public class CidadeDao {
	public void salvar(Cidade c) {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.saveOrUpdate(c);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Cidade> listar() {
		List<Cidade> lista = null; 
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			lista = session.createQuery("from Cidade").getResultList();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Cidade consultar(int id) {
		Cidade c = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			c = (Cidade) session.createQuery("from Cidade WHERE idcidade = " + id).getSingleResult();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public void excluir(int id) {
		Cidade c = consultar(id);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.delete(c);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
