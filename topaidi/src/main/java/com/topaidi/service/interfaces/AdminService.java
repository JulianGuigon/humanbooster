package com.topaidi.service.interfaces;

import com.topaidi.model.roles.Admin;

public interface AdminService extends GenericService<Admin,Integer> {
	Admin findByEmailAndPassword(String email, String password);
}
