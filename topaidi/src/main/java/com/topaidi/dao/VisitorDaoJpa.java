package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.VisitorDao;
import com.topaidi.model.roles.Visitor;

@Repository
@Transactional
public class VisitorDaoJpa implements VisitorDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(Visitor obj) {
		em.remove(findByKey(obj.getId()));
	}

	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Visitor> findAll() {
		return em.createQuery("from Visitor e order by e.id").getResultList();
	}

	@Override
	public Visitor findByKey(Integer key) {
		return em.find(Visitor.class, key);
	}

	@Override
	public Visitor insert(Visitor obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Visitor update(Visitor obj) {
		return em.merge(obj);
	}
}
