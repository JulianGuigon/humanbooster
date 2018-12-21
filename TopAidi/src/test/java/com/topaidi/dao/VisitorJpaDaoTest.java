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
		Visitor v = new Visitor();
		VisitorJpaDao genericDao1 = new VisitorJpaDao();
		genericDao1.insert(v);
		try {
			genericDao1.delete(v);
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testFindAll() {
		Visitor h1 = new Visitor();
		Visitor h2 = new Visitor();
		Visitor h3 = new Visitor();
		VisitorJpaDao genericDao1 = new VisitorJpaDao();
		genericDao1.insert(h1);
		genericDao1.insert(h2);
		genericDao1.insert(h3);
		assertTrue(genericDao1.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Visitor v = new Visitor();
		VisitorJpaDao genericDao1 = new VisitorJpaDao();
		genericDao1.insert(v);
		try {
			genericDao1.findByKey(v.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}
}
