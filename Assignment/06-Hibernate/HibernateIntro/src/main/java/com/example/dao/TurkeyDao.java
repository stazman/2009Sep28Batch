package com.example.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.model.Turkey;
import com.example.util.HibernateUtil;

/**
 *  Ways of making queries in hibernate
 *  
 *  	session methods
 *  		oop style crud operations (look at save)
 *  	native queries
 *  		sql syntax used in session methods (look at findAll)
 *  	Criteria API
 *  		an oop design for making complex queries. (look at findByName)
 *  
 *  	JPA: java api: how to standardize something . 
 *  	ORM: object relational mapping framework. They map the classes to the tables. 
 *  	HQL:
 *  		Hibernate Query Language, a mix of oop queries and sql queries. 
 *
 *		session methods
 *			save() and persist() 					results in a sql insert
 *			update() and merge()					results in a sql update
 *			delete()								results in a sql delete
 *			get() and load()						results in a sql select
 *			saveOrUpdate() 							results in a sql insert or update
 *
 *			the cache is where the sql objects/queries are gathered until they are sent to the db. 
 *		
 *			get()									will go to the db immediately
 *			load()									will use a proxy until you need the actual value
 *
 *			update()								Will not allow duplicate id's inside the cache
 *			merge()									will override the object in the cache if it's a duplicate id. 
 *
 *			save()									will stay in the cache until the session is flushed
 *			persist()								requires a transaction to be sent to the db
 *
 *
 *		states of a persistent entity
 *			transient: 								object that is not associated with the session or database
 *			persistent								an object associated with the session. 
 *			detached								an object that was previously associated with a session, could have been saved to db or otherwise. 
 *			
 */

public class TurkeyDao implements DaoContract<Turkey,Integer>{

	@Override
	public List<Turkey> findAll() {
		List<Turkey> list = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from turkey", Turkey.class).list();
		return list;
	}

	@Override
	public Turkey findById(Integer i) {
		return null;
	}

	@Override
	public Turkey update(Turkey t) {
		return null;
	}

	@Override
	public Turkey save(Turkey t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		sess.close();
		return t;
	}

	@Override
	public Turkey delete(Integer i) {
		return null;
	}

	public Turkey findByName(String name) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		//Criteria API
		//	Hibernate 4
//		Criteria criteria = sess.createCriteria(Turkey.class);
//		criteria.add(Restrictions.like(name, name));
//		return (Turkey) criteria.list().get(0);
		//Hibernate 5
//		CriteriaBuilder cb = sess.getCriteriaBuilder();
//		CriteriaQuery<Turkey> cq = cb.createQuery(Turkey.class);
//		Root<Turkey> rt = cq.from(Turkey.class);
//		cq.select(rt).where(cb.like(rt.get("name"), name));
//		Query<Turkey> q = sess.createQuery(cq);
//		return q.getResultList().get(0);
		
		//HQL
		return sess.createQuery("from Turkey where name = '"+name+"'", Turkey.class).list().get(0);
	}
}