package com.topaidi.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class IdeaJpaDaoTest {
	private User user = new User("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a",true,true);
	private Category category = new Category("cuisine",LocalDate.now(),new Admin("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a"),null);
	
	@Before
	public void init() {
		
	}

	@Test
	public void testUpdateIdea() {
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
		ideaJpaDao.insert(idea);
		idea.setTitle("idea4");
		try {
			idea = ideaJpaDao.update(idea);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(ideaJpaDao.findByKey(idea.getId()).getTitle().equals("idea4"));
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testDeleteIdea() {
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
		ideaJpaDao.insert(idea);
		try {
			ideaJpaDao.delete(idea);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			ideaJpaDao.findByKey(idea.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category,user);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category,user);
		Idea idea3 = new Idea("idea3","a","a",LocalDate.now(),category,user);
		IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
		ideaJpaDao.insert(idea1);
		ideaJpaDao.insert(idea2);
		ideaJpaDao.insert(idea3);
		assertTrue(ideaJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
		ideaJpaDao.insert(idea);
		try {
			ideaJpaDao.findByKey(idea.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}
}
