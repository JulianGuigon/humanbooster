package com.topaidi.service.interfaces;

import com.topaidi.model.roles.User;

public interface UserService extends GenericService<User,Integer>{
	User findByEmailAndPassword(String email, String password);
}
