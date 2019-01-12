package com.topaidi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.VisitorDao;
import com.topaidi.model.roles.Visitor;
import com.topaidi.service.interfaces.VisitorService;

@Service
public class VisitorServiceJpa implements VisitorService{

	@Autowired
	VisitorDao visitorDao;
	
	@Override
	public void delete(Visitor obj) {
		visitorDao.delete(obj);
	}
	
	@Override
	public void deleteByKey(Integer key) {
		visitorDao.deleteByKey(key);
	}
	
	@Override
	public List<Visitor> findAll() {
		return visitorDao.findAll();
	}

	@Override
	public Visitor findByKey(Integer key) {
		return visitorDao.findByKey(key);
	}

	@Override
	public Visitor insert(Visitor obj) {
		return visitorDao.insert(obj);
	}

	@Override
	public Visitor update(Visitor obj) {
		return visitorDao.update(obj);
	}

}
