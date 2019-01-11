package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.UserDao;
import com.topaidi.model.roles.User;

@Repository
@Transactional
public class UserDaoJpa implements UserDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(User obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createQuery("from User e order by e.id").getResultList();
	}

	@Override
	public User findByKey(Integer key) {
		return em.find(User.class, key);
	}

	@Override
	public User insert(User obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public User update(User obj) {
		return em.merge(obj);
	}
}