package com.topaidi.dao;

import com.topaidi.model.Address;
import javassist.NotFoundException;

public class AddressJpaDao extends GenericJpaDao<Address, Integer> {
	public Address update(Address entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}

	public void delete(Address entity) throws NotFoundException {
		super.delete(entity.getId());
	}
}
