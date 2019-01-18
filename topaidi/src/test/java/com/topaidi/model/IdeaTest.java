package com.topaidi.model;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.dao.interfaces.AddressDao;
import com.topaidi.dao.interfaces.AdminDao;
import com.topaidi.dao.interfaces.CategoryDao;
import com.topaidi.dao.interfaces.IdeaDao;
import com.topaidi.dao.interfaces.UserDao;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class IdeaTest {
	
	@Autowired
	IdeaDao ideaDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	AdminDao adminDao;
	@Autowired
	AddressDao addressDao;

	@Test
	public void testIsNotable() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		userDao.insert(user);
		Idea idea = new Idea("idea1","a","a",LocalDate.of(2019, 01, 02),category,user);
		ideaDao.insert(idea);
		
		Assert.assertTrue(!ideaDao.findAll().get(0).isNotable());
	}

}
