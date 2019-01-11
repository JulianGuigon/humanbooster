package com.topaidi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.CommentDao;
import com.topaidi.model.Comment;
import com.topaidi.service.interfaces.CommentService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

@Service
public class CommentServiceJpa implements CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	IdeaService ideaService;
	
	@Override
	public void delete(Comment obj) {
		commentDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		commentDao.deleteByKey(key);
	}

	@Override
	public List<Comment> findAll() {
		return commentDao.findAll();
	}

	@Override
	public Comment findByKey(Integer key) {
		return commentDao.findByKey(key);
	}

	//TODO
	@Override
	public Comment insert(Comment obj) {
		if(obj.getUserCommenting().getId()==0) {
			userService.insert(obj.getUserCommenting());
		}else {
			obj.setUserCommenting(userService.findByKey(obj.getUserCommenting().getId()));
		}
		if(obj.getIdeaCommented().getId()==0) {
			ideaService.insert(obj.getIdeaCommented());
		}else {
			obj.setIdeaCommented(ideaService.findByKey(obj.getIdeaCommented().getId()));
		}
		return commentDao.insert(obj);
	}

	@Override
	public Comment update(Comment obj) {
		return commentDao.update(obj);
	}

}
