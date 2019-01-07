package com.topaidi.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class IdeaJpaDao implements GenericDao<Idea, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();
	private CategoryJpaDao categoryJpaDao = new CategoryJpaDao();
	private UserJpaDao userJpaDao = new UserJpaDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Idea> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from Idea c";
		List<Idea> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public Idea findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Idea result = em.find(Idea.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}

	@Override
	public void insert(Idea obj) {
		Category category = obj.getCategory();
		if(category.getId()!=0) {
			try {
				category = categoryJpaDao.findByKey(category.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			categoryJpaDao.insert(category);
		}
		User user = obj.getUserSubmitting();
		if(user.getId()!=0) {
			try {
				user = userJpaDao.findByKey(user.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			userJpaDao.insert(user);
		}
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Idea update(Idea obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Idea entityUpdated = em.find(Idea.class, obj.getId());
		if(entityUpdated==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		entityUpdated = obj;
		em.merge(entityUpdated);
		em.getTransaction().commit();
		em.close();
		return entityUpdated;
	}

	@Override
	public void delete(Idea obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Idea entityDeleted = em.find(Idea.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
