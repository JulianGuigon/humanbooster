package com.topaidi.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.UserDao;
import com.topaidi.model.Idea;
import com.topaidi.model.Note;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.AddressService;
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
		User found;
		try {		
			 found = userDao.findByEmailAndPassword(email, password);
		}catch(NoResultException n) {
			found = null;
		}
		return found;
	}

	@Override
	public Idea createIdea(Idea idea) {
		return userDao.createIdea(idea);
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
	public Note noteIdea(Note note) {
		return noteService.insert(note);
	}
	

}
