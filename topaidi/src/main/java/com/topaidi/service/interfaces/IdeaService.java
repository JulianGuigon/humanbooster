package com.topaidi.service.interfaces;

import java.util.List;

import com.topaidi.model.Idea;

public interface IdeaService extends GenericService<Idea,Integer>{
	List<Idea> findAllByCreateAt();
}
