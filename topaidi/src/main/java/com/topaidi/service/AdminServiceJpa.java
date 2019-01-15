package com.topaidi.service;

import java.util.List;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.AdminDao;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.AddressService;
import com.topaidi.service.interfaces.AdminService;

@Service
public class AdminServiceJpa implements AdminService {

	@Autowired
	AdminDao adminDao;
	@Autowired
	AddressService addressService;
	
	@Override
	public void delete(Admin obj) {
		adminDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		adminDao.deleteByKey(key);
	}

	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	@Override
	public Admin findByKey(Integer key) {
		return adminDao.findByKey(key);
	}

	@Override
	public Admin insert(Admin obj) {
		if(obj.getAddress().getId()==null) {
			addressService.insert(obj.getAddress());
		}else {
			obj.setAddress(addressService.findByKey(obj.getAddress().getId()));
		}
		return adminDao.insert(obj);
	}

	@Override
	public Admin update(Admin obj) {
		return adminDao.update(obj);
	}

	@Override
	public Admin findByEmailAndPassword(String email, String password) {
		return adminDao.findByEmailAndPassword(email, password);
	}

	@Override
	public boolean banUser(User user) {	
		return adminDao.banUser(user);
	}

	@Override
	public boolean findEmailExist(String email) {
		return adminDao.findEmailExist(email);
	}

	@Override
	public boolean desactiveIdea(Idea idea) {
		return adminDao.desactiveIdea(idea);
	}

	@Override
	public boolean desactiveUser(User user) {
		return adminDao.desactiveUser(user);
	}

	@Override
	public boolean desactiveComment(Comment comment) {
		return adminDao.desactiveComment(comment);
	}

	@Override
	public boolean validateUser(User user) {
		return adminDao.validateUser(user);
	}

}
