package com.topaidi.dao.interfaces;

import com.topaidi.model.roles.Admin;

public interface AdminDao extends GenericDao<Admin,Integer>{
	Admin findByEmailAndPassword(String email, String password);
}
