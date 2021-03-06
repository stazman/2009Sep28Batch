package com.orm.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orm.model.CandyTaco;

@Repository
@Transactional
public class CandyTacoDao {

	private SessionFactory sessfact;

	@Autowired
	public CandyTacoDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public CandyTacoDao() {
	}
	
//	@Transactional
	public void insert(CandyTaco ct) {
//		Session sess = sessfact.openSession();
//		Transaction tx = sess.beginTransaction();
//		sess.save(ct);
//		tx.commit();
		sessfact.openSession().save(ct);
	}
	
	public CandyTaco findById(int id) {
		return sessfact.openSession().get(CandyTaco.class, id);
	}
	
	public List<CandyTaco> findAll(){
		return sessfact.openSession().createQuery("from CandyTaco", CandyTaco.class).list();
	}
	
	public CandyTaco findBySauce(String sauce) {
		return sessfact.getCurrentSession().createQuery("from CandyTaco where sauce = '"+sauce+"'", CandyTaco.class).list().get(0);
	}

}
