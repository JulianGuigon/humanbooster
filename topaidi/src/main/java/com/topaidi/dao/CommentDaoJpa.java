package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.CommentDao;
import com.topaidi.model.Comment;

@Repository
@Transactional
public class CommentDaoJpa implements CommentDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(Comment obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> findAll() {
		return em.createQuery("from Comment e order by e.id").getResultList();
	}

	@Override
	public Comment findByKey(Integer key) {
		return em.find(Comment.class, key);
	}

	@Override
	public Comment insert(Comment obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Comment update(Comment obj) {
		return em.merge(obj);
	}

}
