package com.topaidi.dao;

import com.topaidi.model.Address;
import com.topaidi.model.roles.User;

import javassist.NotFoundException;

public class UserJpaDao extends GenericJpaDao<User, Integer> {
	private AddressJpaDao addressJpaDao = new AddressJpaDao();
	
	@Override
	public void insert(User obj) {
		Address address = obj.getAddress();
		if(address.getId()!=null) {
			try {
				address = addressJpaDao.findByKey(address.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			addressJpaDao.insert(address);
		}
		
		super.insert(obj);
	}
	
	public User update(User entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}
	
	@Override
	public void delete(Integer key) throws NotFoundException {
		super.delete(key);
	}
	
	public void delete(User entity) throws NotFoundException {
		delete(entity.getId());
	}
}
