package com.topaidi.dao;

import com.topaidi.model.Address;
import com.topaidi.model.roles.Admin;

import javassist.NotFoundException;

public class AdminJpaDao extends GenericJpaDao<Admin, Integer> {
	private AddressJpaDao genericDao1;
	
	public AdminJpaDao() {
		genericDao1 = new AddressJpaDao();
	}
	
	@Override
	public void insert(Admin obj) {
		Address a = obj.getAddress();
		if(a.getId()!=null) {
			try {
				a = genericDao1.findByKey(a.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			genericDao1.insert(a);
		}
		super.insert(obj);
	}
	
	public Admin update(Admin entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}

	@Override
	public void delete(Integer key) throws NotFoundException {
		Address a = findByKey(key).getAddress();
		super.delete(key);
		genericDao1.delete(a);
	}
	
	public void delete(Admin entity) throws NotFoundException {
		delete(entity.getId());
	}
}
