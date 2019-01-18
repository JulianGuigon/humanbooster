package com.topaidi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.NoteDao;
import com.topaidi.model.Note;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.NoteService;
import com.topaidi.service.interfaces.UserService;

@Service
public class NoteServiceJpa implements NoteService{

	@Autowired
	NoteDao noteDao;
	@Autowired
	IdeaService ideaService;
	@Autowired
	UserService userService;
	
	@Override
	public void delete(Note obj) {
		noteDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		noteDao.deleteByKey(key);
	}

	@Override
	public List<Note> findAll() {
		return noteDao.findAll();
	}

	@Override
	public Note findByKey(Integer key) {
		return noteDao.findByKey(key);
	}

	@Override
	public Note insert(Note obj) {
		if(obj.getIdeaNoted().getId()==null) {
			ideaService.insert(obj.getIdeaNoted());
		}else {
			obj.setIdeaNoted(ideaService.findByKey(obj.getIdeaNoted().getId()));
		}
		if(obj.getUserNoting().getId()==null) {
			userService.insert(obj.getUserNoting());
		}else {
			obj.setUserNoting(userService.findByKey(obj.getUserNoting().getId()));
		}
		return noteDao.insert(obj);
	}

	@Override
	public Note update(Note obj) {
		return noteDao.update(obj);
	}

	@Override
	public List<Note> findAllTopByIdea(int idIdea) {
		return noteDao.findAllTopByIdea(idIdea);
	}

	@Override
	public List<Note> findAllFlopByIdea(int idIdea) {
		return noteDao.findAllFlopByIdea(idIdea);
	}

}
