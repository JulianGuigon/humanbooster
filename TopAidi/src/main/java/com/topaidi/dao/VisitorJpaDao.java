package com.topaidi.dao;

import com.topaidi.model.roles.Visitor;

import javassist.NotFoundException;

public class VisitorJpaDao extends GenericJpaDao<Visitor, Integer> {
	public Visitor update(Visitor entity) throws NotFoundException {
		return super.update(entity.getId());
	}

	public void delete(Visitor entity) throws NotFoundException {
		super.delete(entity.getId());
	}
}
