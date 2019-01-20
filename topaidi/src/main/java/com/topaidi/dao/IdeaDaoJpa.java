package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.IdeaDao;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;

@Repository
@Transactional
public class IdeaDaoJpa implements IdeaDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(Idea obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Idea> findAll() {
		return em.createQuery("from Idea e order by e.id").getResultList();
	}

	@Override
	public Idea findByKey(Integer key) {
		return em.find(Idea.class, key);
	}
	
	@Override
	public Idea insert(Idea obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Idea update(Idea obj) {
		return em.merge(obj);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Idea> findAllByCreateAt() {
		return em.createQuery("from Idea i order by i.createdAt DESC").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Idea> findAllWithUser(User user) {
		return em.createQuery("from Idea i where usersubmitting_roleid = :id order by i.id")
				.setParameter("id", user.getId())
				.getResultList();
	}

}
