package com.topaidi.dao;

import com.topaidi.model.Idea;
import com.topaidi.model.Note;
import com.topaidi.model.roles.User;

import javassist.NotFoundException;

public class NoteJpaDao extends GenericJpaDao<Note, Integer> {
	private IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
	private UserJpaDao userJpaDao = new UserJpaDao();
	
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
		
		super.insert(obj);
	}
	
	public Note update(Note entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}

	@Override
	public void delete(Integer key) throws NotFoundException {
		super.delete(key);
	}
	
	public void delete(Note entity) throws NotFoundException {
		delete(entity.getId());
	}
}
