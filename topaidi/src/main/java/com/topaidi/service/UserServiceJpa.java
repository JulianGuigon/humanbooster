package com.topaidi.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.UserDao;
import com.topaidi.enums.AlertType;
import com.topaidi.model.Alert;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.Note;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.AddressService;
import com.topaidi.service.interfaces.AlertService;
import com.topaidi.service.interfaces.CommentService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.NoteService;
import com.topaidi.service.interfaces.UserService;

@Service
public class UserServiceJpa implements UserService{

	@Autowired
	UserDao userDao;
	@Autowired
	AddressService addressService;
	@Autowired
	NoteService noteService;
	@Autowired
	IdeaService ideaService;
	@Autowired
	AlertService alertService;
	@Autowired
	CommentService commentService;
	
	@Override
	public void delete(User obj) {
		userDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		userDao.deleteByKey(key);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	@Override
	public List<User> findAllByName(String name) {
		return userDao.findAllByName(name);
	}

	@Override
	public User findByKey(Integer key) {
		return userDao.findByKey(key);
	}

	@Override
	public User insert(User obj) {
		if(obj.getAddress().getId()==null) {
			addressService.insert(obj.getAddress());
		}else {
			obj.setAddress(addressService.findByKey(obj.getAddress().getId()));
		}
		return userDao.insert(obj);
	}

	@Override
	public User update(User obj) {
		return userDao.update(obj);
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}

	@Override
	public boolean findEmailExist(String email) {
		return userDao.findEmailExist(email);
	}
	
	@Override
	public List<User> findValidUser() {
		return userDao.findValidUser();
	}
	
	@Override
	public List<User> findInvalidUser() {
		return userDao.findInvalidUser();
	}
	
	@Override
	public Idea createIdea(Idea idea) {
		return ideaService.insert(idea);
	}


	@Override
	public Note noteIdea(Note note) {
		return noteService.insert(note);
	}

	@Override
	public Idea alertIdea(Idea ideaAlerted, String message, AlertType alertType) {
		alertService.insert(new Alert(message, ideaAlerted, ideaAlerted.getUserSubmitting()));
		return ideaAlerted;
	}

	@Override
	public Comment alertComment(Comment commentAlerted, String message, AlertType alertType) {
		alertService.insert(new Alert(message, commentAlerted, commentAlerted.getUserCommenting()));
		return commentAlerted;
	}

	@Override
	public Comment addComment(Comment comment) {
		commentService.insert(comment);
		return comment;
	}
	

}
