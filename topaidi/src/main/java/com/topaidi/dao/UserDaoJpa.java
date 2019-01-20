package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	@SuppressWarnings("unchecked")
	public List<User> findAllByName(String name) {
		return em.createQuery("from User e where e.name = :name order by e.id")
				.setParameter("name", name)
				.getResultList();
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

	@Override
	public User findByEmailAndPassword(String email, String password) {
		User found;
		try {
			found = (User)em.createQuery("from User where email = :email AND password = :password")
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
		}catch(NoResultException n) {
			found = null;
		}
		return found;
	}

	@Override
	public boolean findEmailExist(String email) {
		boolean retour = true;
		try {
			Query query = em.createQuery("from User where email = :email");
			query.setParameter("email", email);
			query.getSingleResult();
		} catch (NoResultException e) {
			retour = false;
		}
		
		return retour;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findValidUser() {
		return em.createQuery("from User where isValid = true").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findInvalidUser() {
		return em.createQuery("from User where isValid = false").getResultList();
	}
}