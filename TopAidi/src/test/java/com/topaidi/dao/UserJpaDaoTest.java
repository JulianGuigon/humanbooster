package com.topaidi.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.topaidi.model.Address;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class UserJpaDaoTest {

	private Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
	
	@Test
	public void testUpdateUser() {
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		UserJpaDao userJpaDao = new UserJpaDao();
		userJpaDao.insert(user);
		user.setPassword("bbbb");
		try {
			userJpaDao.update(user);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(userJpaDao.findByKey(user.getId()).getPassword().equals("bbbb"));
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@Test
	public void testUpdateUserAddress() {
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		UserJpaDao userJpaDao = new UserJpaDao();
		userJpaDao.insert(user);
		user.setAddress(new Address("France","Lyon",69130,"chemin Louis Chirpaz",9));
		try {
			userJpaDao.update(user);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(userJpaDao.findByKey(user.getId()).getAddress().getStreetNumber()==9);
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testDeleteUser() {
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		UserJpaDao userJpaDao = new UserJpaDao();
		userJpaDao.insert(user);
		try {
			userJpaDao.delete(user);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			userJpaDao.findByKey(user.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		UserJpaDao userJpaDao = new UserJpaDao();
		userJpaDao.insert(user1);
		userJpaDao.insert(user2);
		userJpaDao.insert(user3);
		assertTrue(userJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		UserJpaDao userJpaDao = new UserJpaDao();
		userJpaDao.insert(user);
		try {
			userJpaDao.findByKey(user.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}

}
