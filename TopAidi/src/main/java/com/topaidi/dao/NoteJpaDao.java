package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.Idea;
import com.topaidi.model.Note;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class NoteJpaDao implements GenericDao<Note, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();
	private IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
	private UserJpaDao userJpaDao = new UserJpaDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from Note c";
		List<Note> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public Note findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Note result = em.find(Note.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}

	@Override
	public void insert(Note obj) {
		Idea idea = obj.getIdeaNoted();
		if(idea.getId()!=0) {
			try {
				idea = ideaJpaDao.findByKey(idea.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			ideaJpaDao.insert(idea);
		}
		User user = obj.getUserNoting();
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
	public Note update(Note obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Note entityUpdated = em.find(Note.class, obj.getId());
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
	public void delete(Note obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Note entityDeleted = em.find(Note.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
