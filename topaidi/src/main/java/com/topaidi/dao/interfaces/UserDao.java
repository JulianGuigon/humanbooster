package com.topaidi.dao.interfaces;

import com.topaidi.model.roles.User;

public interface UserDao extends GenericDao<User,Integer> {
	User findByEmailAndPassword(String email, String password);
}
