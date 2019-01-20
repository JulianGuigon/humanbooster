package com.topaidi.dao.interfaces;

import java.util.List;

import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;

public interface IdeaDao extends GenericDao<Idea,Integer>{
	List<Idea> findAllByCreateAt();
	List<Idea> findAllWithUser(User user);
}
