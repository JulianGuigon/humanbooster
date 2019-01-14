package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.AdminDao;
import com.topaidi.model.roles.Admin;

@Repository
@Transactional
public class AdminDaoJpa implements AdminDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(Admin obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Admin> findAll() {
		return em.createQuery("from Admin e order by e.id").getResultList();
	}

	@Override
	public Admin findByKey(Integer key) {
		return em.find(Admin.class, key);
	}

	@Override
	public Admin insert(Admin obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Admin update(Admin obj) {
		return em.merge(obj);
	}

	@Override
	public Admin findByEmailAndPassword(String email, String password) {
		return (Admin) em.createQuery("from Admin where email = ? AND password = ?")
				.setParameter(0, email)
				.setParameter(1, password)
				.getSingleResult();
	}

}