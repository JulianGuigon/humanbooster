package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.CategoryDao;
import com.topaidi.model.Category;

@Repository
@Transactional
public class CategoryDaoJpa implements CategoryDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(Category obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		return em.createQuery("from Category e order by e.id").getResultList();
	}

	@Override
	public Category findByKey(Integer key) {
		return em.find(Category.class, key);
	}

	@Override
	public Category insert(Category obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Category update(Category obj) {
		return em.merge(obj);
	}

}