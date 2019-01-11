package com.topaidi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.AddressDao;
import com.topaidi.model.Address;
import com.topaidi.service.interfaces.AddressService;

@Service
public class AddressServiceJpa implements AddressService{

	@Autowired
	AddressDao addressDao;
	
	@Override
	public void delete(Address obj) {
		addressDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		addressDao.deleteByKey(key);
	}

	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}

	@Override
	public Address findByKey(Integer key) {
		return addressDao.findByKey(key);
	}

	@Override
	public Address insert(Address obj) {
		return addressDao.insert(obj);
	}

	@Override
	public Address update(Address obj) {
		return addressDao.update(obj);
	}
	

}
