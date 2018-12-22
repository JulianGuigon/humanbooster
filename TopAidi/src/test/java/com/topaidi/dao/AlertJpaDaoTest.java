package com.topaidi.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.Alert;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class AlertJpaDaoTest {
	private User user = new User("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a",true,true);
	private Idea idea = new Idea("idea1","a","a",LocalDate.now(),new Category("cuisine",LocalDate.now(),new Admin("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a"),null),user);
	private Comment comment = new Comment("ahaha",user,idea);
	
	@Before
	public void init() {
		
	}

	@Test
	public void testUpdateAlert() {
		Alert alert = new Alert("Alert1",comment,user);
		AlertJpaDao alertJpaDao = new AlertJpaDao();
		alertJpaDao.insert(alert);
		alert.setMessage("Alert4");
		try {
			alert = alertJpaDao.update(alert);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(alertJpaDao.findByKey(alert.getId()).getMessage().equals("Alert4"));
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testDeleteAlert() {
		Alert alert = new Alert("Alert1",idea,user);
		AlertJpaDao alertJpaDao = new AlertJpaDao();
		alertJpaDao.insert(alert);
		try {
			alertJpaDao.delete(alert);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			alertJpaDao.findByKey(alert.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		Alert alert1 = new Alert("Alert1",comment,user);
		Alert alert2 = new Alert("Alert2",idea,user);
		Alert alert3 = new Alert("Alert3",comment,user);
		AlertJpaDao alertJpaDao = new AlertJpaDao();
		alertJpaDao.insert(alert1);
		alertJpaDao.insert(alert2);
		alertJpaDao.insert(alert3);
		assertTrue(alertJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Alert alert1 = new Alert("Alert1",comment,user);
		Alert alert2 = new Alert("Alert2",idea,user);
		AlertJpaDao alertJpaDao = new AlertJpaDao();
		alertJpaDao.insert(alert1);
		alertJpaDao.insert(alert2);
		try {
			alertJpaDao.findByKey(alert1.getId());
			alertJpaDao.findByKey(alert2.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	
	@After
	public void after() {
		Connection.stop();
	}
}
