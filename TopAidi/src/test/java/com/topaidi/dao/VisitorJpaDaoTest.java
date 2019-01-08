package com.topaidi.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import com.topaidi.model.roles.Visitor;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class VisitorJpaDaoTest {
	
	@Test
	public void testDeleteVisitor() {
		Visitor visitor = new Visitor();
		VisitorJpaDao visitorJpaDao = new VisitorJpaDao();
		visitorJpaDao.insert(visitor);
		try {
			visitorJpaDao.delete(visitor);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			visitorJpaDao.findByKey(visitor.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		Visitor visitor1 = new Visitor();
		Visitor visitor2 = new Visitor();
		Visitor visitor3 = new Visitor();
		VisitorJpaDao visitorJpaDao = new VisitorJpaDao();
		visitorJpaDao.insert(visitor1);
		visitorJpaDao.insert(visitor2);
		visitorJpaDao.insert(visitor3);
		assertTrue(visitorJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Visitor visitor = new Visitor();
		VisitorJpaDao visitorJpaDao = new VisitorJpaDao();
		visitorJpaDao.insert(visitor);
		try {
			visitorJpaDao.findByKey(visitor.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}
}
