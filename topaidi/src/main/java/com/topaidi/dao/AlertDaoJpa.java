package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.AlertDao;
import com.topaidi.model.Alert;

@Repository
@Transactional
public class AlertDaoJpa implements AlertDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(Alert obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Alert> findAll() {
		return em.createQuery("from Alert e order by e.id").getResultList();
	}
	
	@Override
	public Alert findByKey(Integer key) {
		return em.find(Alert.class, key);
	}

	@Override
	public Alert insert(Alert obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Alert update(Alert obj) {
		return em.merge(obj);
	}

}
