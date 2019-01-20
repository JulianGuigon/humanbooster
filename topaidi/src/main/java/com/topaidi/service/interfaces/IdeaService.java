package com.topaidi.service.interfaces;

import java.util.List;

import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;

public interface IdeaService extends GenericService<Idea,Integer>{
	List<Idea> findAllByCreateAt();
	List<Idea> findAllWithUser(User user);
}
