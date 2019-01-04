package com.topaidi.dao;

import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;
import com.topaidi.model.Category;

import javassist.NotFoundException;

public class IdeaJpaDao extends GenericJpaDao<Idea, Integer>{
	private CategoryJpaDao categoryJpaDao = new CategoryJpaDao();
	private UserJpaDao userJpaDao = new UserJpaDao();
	
	@Override
	public void insert(Idea obj) {
		Category category = obj.getCategory();
		if(category.getId()!=0) {
			try {
				category = categoryJpaDao.findByKey(category.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			categoryJpaDao.insert(category);
		}
		User user = obj.getUserSubmitting();
		if(user.getId()!=0) {
			try {
				user = userJpaDao.findByKey(user.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			userJpaDao.insert(user);
		}
		super.insert(obj);
	}
	
	public Idea update(Idea entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}

	@Override
	public void delete(Integer key) throws NotFoundException {
		super.delete(key);
	}
	
	public void delete(Idea entity) throws NotFoundException {
		delete(entity.getId());
	}
}
