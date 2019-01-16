package com.topaidi.dao.interfaces;

import java.util.List;

import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;

public interface UserDao extends GenericDao<User,Integer> {
	User findByEmailAndPassword(String email, String password);
	boolean findEmailExist(String email);
	List<User> findValidUser();
	List<User> findInvalidUser();
}
