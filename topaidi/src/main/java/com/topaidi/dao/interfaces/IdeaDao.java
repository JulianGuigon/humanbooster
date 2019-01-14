package com.topaidi.dao.interfaces;

import java.util.List;

import com.topaidi.model.Idea;

public interface IdeaDao extends GenericDao<Idea,Integer>{
	List<Idea> findAllByCreateAt();
}
