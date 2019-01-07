package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.topaidi.enums.AlertType;
import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.Alert;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class AlertJpaDao implements GenericDao<Alert, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();
	private UserJpaDao userJpaDao = new UserJpaDao();
	private IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
	private CommentJpaDao commentJpaDao = new CommentJpaDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Alert> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from Alert c";
		List<Alert> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public Alert findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Alert result = em.find(Alert.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}

	@Override
	public void insert(Alert obj) {
		if(obj.getAlertType()==AlertType.Comment) {
			Comment comment = obj.getCommentAlerted();
			if(comment.getId()!=0) {
				try {
					comment = commentJpaDao.findByKey(comment.getId());
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
			}else {
				commentJpaDao.insert(comment);
			}
		}else if(obj.getAlertType()==AlertType.Idea) {
			Idea idea = obj.getIdeaAlerted();
			if(idea.getId()!=0) {
				try {
					idea = ideaJpaDao.findByKey(idea.getId());
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
			}else {
				ideaJpaDao.insert(idea);
			}
		}
		User user = obj.getUserAlerting();
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
	public Alert update(Alert obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Alert entityUpdated = em.find(Alert.class, obj.getId());
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
	public void delete(Alert obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Alert entityDeleted = em.find(Alert.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
