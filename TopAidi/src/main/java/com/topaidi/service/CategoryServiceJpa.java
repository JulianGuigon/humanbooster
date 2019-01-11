package com.topaidi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.CategoryDao;
import com.topaidi.model.Category;
import com.topaidi.service.interfaces.AdminService;
import com.topaidi.service.interfaces.CategoryService;

@Service
public class CategoryServiceJpa implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	AdminService adminService;
	
	@Override
	public void delete(Category obj) {
		categoryDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		categoryDao.deleteByKey(key);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public Category findByKey(Integer key) {
		return categoryDao.findByKey(key);
	}

	@Override
	public Category insert(Category obj) {
		//TODO change id==0 to id==null after merge
		if(obj.getAdminCreating().getId()==0) {
			adminService.insert(obj.getAdminCreating());
		}else {
			obj.setAdminCreating(adminService.findByKey(obj.getAdminCreating().getId()));
		}
		return categoryDao.insert(obj);
	}

	@Override
	public Category update(Category obj) {
		return categoryDao.update(obj);
	}

}
