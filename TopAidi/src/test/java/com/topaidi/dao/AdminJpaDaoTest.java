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
	private Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
	
	@Test
	public void testUpdateAdmin() {
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		AdminJpaDao adminJpaDao = new AdminJpaDao();
		adminJpaDao.insert(admin);
		admin.setPassword("bbbb");
		try {
			adminJpaDao.update(admin);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(adminJpaDao.findByKey(admin.getId()).getPassword().equals("bbbb"));
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testDeleteAdmin() {
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		AdminJpaDao adminJpaDao = new AdminJpaDao();
		adminJpaDao.insert(admin);
		try {
			adminJpaDao.delete(admin);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			adminJpaDao.findByKey(admin.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		AdminJpaDao adminJpaDao = new AdminJpaDao();
		adminJpaDao.insert(admin1);
		adminJpaDao.insert(admin2);
		adminJpaDao.insert(admin3);
		assertTrue(adminJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		AdminJpaDao adminJpaDao = new AdminJpaDao();
		adminJpaDao.insert(admin);
		try {
			adminJpaDao.findByKey(admin.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}
}
