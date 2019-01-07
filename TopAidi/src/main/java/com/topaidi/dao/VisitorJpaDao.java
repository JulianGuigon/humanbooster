package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.roles.Visitor;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class VisitorJpaDao implements GenericDao<Visitor, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();

	@SuppressWarnings("unchecked")
	@Override
	public List<Visitor> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from Visitor c";
		List<Visitor> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public Visitor findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Visitor result = em.find(Visitor.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}

	@Override
	public void insert(Visitor obj) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Visitor update(Visitor obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Visitor entityUpdated = em.find(Visitor.class, obj.getId());
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
	public void delete(Visitor obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Visitor entityDeleted = em.find(Visitor.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
