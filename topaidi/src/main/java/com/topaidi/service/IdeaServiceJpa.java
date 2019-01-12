package com.topaidi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.IdeaDao;
import com.topaidi.model.Idea;
import com.topaidi.service.interfaces.CategoryService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

@Service
public class IdeaServiceJpa implements IdeaService {

	@Autowired
	IdeaDao ideaDao;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	
	@Override
	public void delete(Idea obj) {
		ideaDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		ideaDao.deleteByKey(key);
	}

	@Override
	public List<Idea> findAll() {
		return ideaDao.findAll();
	}

	@Override
	public Idea findByKey(Integer key) {
		return ideaDao.findByKey(key);
	}

	@Override
	public Idea insert(Idea obj) {
		if(obj.getCategory().getId()==null) {
			categoryService.insert(obj.getCategory());
		}else {
			obj.setCategory(categoryService.findByKey(obj.getCategory().getId()));
		}
		if(obj.getUserSubmitting().getId()==null) {
			userService.insert(obj.getUserSubmitting());
		}else {
			obj.setUserSubmitting(userService.findByKey(obj.getUserSubmitting().getId()));
		}
		return ideaDao.insert(obj);
	}

	@Override
	public Idea update(Idea obj) {
		return ideaDao.update(obj);
	}

}
