package com.topaidi.dao;

import com.topaidi.model.Category;
import com.topaidi.model.roles.Admin;

import javassist.NotFoundException;

//TODO
public class CategoryJpaDao extends GenericJpaDao<Category, Integer> {
	private AdminJpaDao genericDao1;
	
	public CategoryJpaDao() {
		genericDao1 = new AdminJpaDao();
	}
	
	@Override
	public void insert(Category obj) {
		genericDao1.insert(obj.getAdmin());
		super.insert(obj);
	}
	
	public Category update(Category entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}

	@Override
	public void delete(Integer key) throws NotFoundException {
		Admin a = findByKey(key).getAdmin();
		super.delete(key);
		genericDao1.delete(a);
	}
	
	public void delete(Category entity) throws NotFoundException {
		delete(entity.getId());
	}
}
