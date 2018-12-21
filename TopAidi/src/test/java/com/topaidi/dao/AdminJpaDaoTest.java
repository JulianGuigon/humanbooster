package com.topaidi.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.topaidi.model.Address;
import com.topaidi.model.roles.Admin;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class AdminJpaDaoTest {
	Address a = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
	
	@Test
	public void testUpdateAdmin() {
		Admin v = new Admin("Jean Guy","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
		AdminJpaDao genericDao1 = new AdminJpaDao();
		genericDao1.insert(v);
		v.setPassword("bbbb");
		try {
			genericDao1.findByKey(v.getId());
		} catch (NotFoundException e) {
			fail();
		}
		Assert.assertTrue(v.getPassword().equals("bbbb"));
	}

	@Test
	public void testDeleteAdmin() {
		Admin v = new Admin("Jean Guy","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
		AdminJpaDao genericDao1 = new AdminJpaDao();
		genericDao1.insert(v);
		try {
			genericDao1.delete(v);
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testFindAll() {
		Admin h1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
		Admin h2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
		Admin h3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
		AdminJpaDao genericDao1 = new AdminJpaDao();
		genericDao1.insert(h1);
		genericDao1.insert(h2);
		genericDao1.insert(h3);
		assertTrue(genericDao1.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Admin v = new Admin("Jean Guy","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
		AdminJpaDao genericDao1 = new AdminJpaDao();
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
