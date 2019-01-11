package com.topaidi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.AdminDao;
import com.topaidi.model.roles.Admin;
import com.topaidi.service.interfaces.AddressService;
import com.topaidi.service.interfaces.AdminService;

@Service
public class AdminServiceJpa implements AdminService {

	@Autowired
	AdminDao adminDao;
	@Autowired
	AddressService addressService;
	
	@Override
	public void delete(Admin obj) {
		adminDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		adminDao.deleteByKey(key);
	}

	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	@Override
	public Admin findByKey(Integer key) {
		return adminDao.findByKey(key);
	}

	@Override
	public Admin insert(Admin obj) {
		if(obj.getAddress().getId()==null) {
			addressService.insert(obj.getAddress());
		}else {
			obj.setAddress(addressService.findByKey(obj.getAddress().getId()));
		}
		return adminDao.insert(obj);
	}

	@Override
	public Admin update(Admin obj) {
		return adminDao.update(obj);
	}

}
