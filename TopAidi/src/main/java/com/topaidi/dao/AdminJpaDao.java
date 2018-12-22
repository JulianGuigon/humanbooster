package com.topaidi.dao;

import com.topaidi.model.Address;
import com.topaidi.model.roles.Admin;

import javassist.NotFoundException;

public class AdminJpaDao extends GenericJpaDao<Admin, Integer> {
	private AddressJpaDao addressJpaDao = new AddressJpaDao();
	
	@Override
	public void insert(Admin obj) {
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
	
	public Admin update(Admin entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}

	@Override
	public void delete(Integer key) throws NotFoundException {
		super.delete(key);
	}
	
	public void delete(Admin entity) throws NotFoundException {
		delete(entity.getId());
	}
}
