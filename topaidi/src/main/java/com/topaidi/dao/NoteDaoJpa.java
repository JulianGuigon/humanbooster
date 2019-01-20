package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.NoteDao;
import com.topaidi.model.Note;

@Repository
@Transactional
public class NoteDaoJpa implements NoteDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(Note obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Note> findAll() {
		return em.createQuery("from Note e order by e.id").getResultList();
	}

	@Override
	public Note findByKey(Integer key) {
		return em.find(Note.class, key);
	}

	@Override
	public Note insert(Note obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Note update(Note obj) {
		return em.merge(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> findAllTopByIdea(int idIdea) {
		return em.createQuery("from Note e where istop = true AND ideanoted_ideaid = :idIdea").setParameter("idIdea", idIdea).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> findAllFlopByIdea(int idIdea) {
		return em.createQuery("from Note e where istop = false AND ideanoted_ideaid = :idIdea").setParameter("idIdea", idIdea).getResultList();
	}

}
