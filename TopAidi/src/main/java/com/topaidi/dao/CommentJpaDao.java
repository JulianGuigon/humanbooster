package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class CommentJpaDao implements GenericDao<Comment, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();
	private IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
	private UserJpaDao userJpaDao = new UserJpaDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from Comment c";
		List<Comment> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public Comment findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Comment result = em.find(Comment.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}

	@Override
	public void insert(Comment obj) {
		Idea idea = obj.getIdeaCommented();
		if(idea.getId()!=0) {
			try {
				idea = ideaJpaDao.findByKey(idea.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			ideaJpaDao.insert(idea);
		}
		User user = obj.getUserCommenting();
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
	public Comment update(Comment obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Comment entityUpdated = em.find(Comment.class, obj.getId());
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
	public void delete(Comment obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Comment entityDeleted = em.find(Comment.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
