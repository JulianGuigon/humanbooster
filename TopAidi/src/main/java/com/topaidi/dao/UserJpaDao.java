package com.topaidi.dao;

import com.topaidi.model.Address;
import com.topaidi.model.roles.User;

import javassist.NotFoundException;

public class UserJpaDao extends GenericJpaDao<User, Integer> {
	private AddressJpaDao genericDao1;
	
	public UserJpaDao() {
		genericDao1 = new AddressJpaDao();
	}
	
	@Override
	public void insert(User obj) {
		genericDao1.insert(obj.getAddress());
		super.insert(obj);
	}
	
	public User update(User entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}
	
	@Override
	public void delete(Integer key) throws NotFoundException {
		Address a = findByKey(key).getAddress();
		super.delete(key);
		genericDao1.delete(a);
	}
	
	public void delete(User entity) throws NotFoundException {
		delete(entity.getId());
	}
}
