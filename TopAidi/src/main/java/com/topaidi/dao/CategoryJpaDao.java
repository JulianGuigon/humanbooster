package com.topaidi.dao;

import com.topaidi.model.Category;
import com.topaidi.model.roles.Admin;

import javassist.NotFoundException;

public class CategoryJpaDao extends GenericJpaDao<Category, Integer> {
	private AdminJpaDao adminJpaDao = new AdminJpaDao();
	
	@Override
	public void insert(Category obj) {
		Admin admin = obj.getAdminCreating();
		if(admin.getId()!=0) {
			try {
				admin = adminJpaDao.findByKey(admin.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			adminJpaDao.insert(admin);
		}
		super.insert(obj);
	}
	
	public Category update(Category entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}

	@Override
	public void delete(Integer key) throws NotFoundException {
		super.delete(key);
	}
	
	public void delete(Category entity) throws NotFoundException {
		delete(entity.getId());
	}
}
