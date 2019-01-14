package com.topaidi.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class IdeaDaoJpaTest {
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
	public void testDelete() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		userDao.insert(user);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		ideaDao.insert(idea);
		
		ideaDao.delete(idea);
		assertNull(ideaDao.findByKey(idea.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		userDao.insert(user);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		ideaDao.insert(idea);
		
		ideaDao.deleteByKey(idea.getId());
		assertNull(ideaDao.findByKey(idea.getId()));
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		addressDao.insert(address2);
		addressDao.insert(address3);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898");
		adminDao.insert(admin1);
		adminDao.insert(admin2);
		adminDao.insert(admin3);
		Category category1 = new Category("cuisine",LocalDate.now(),admin1);
		Category category2 = new Category("botanique",LocalDate.now(),admin2);
		Category category3 = new Category("echecs",LocalDate.now(),admin3);
		categoryDao.insert(category1);
		categoryDao.insert(category2);
		categoryDao.insert(category3);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address5 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address6 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address4);
		addressDao.insert(address5);
		addressDao.insert(address6);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address6,"0477265898",true,true);
		userDao.insert(user1);
		userDao.insert(user2);
		userDao.insert(user3);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Idea idea3 = new Idea("idea3","a","a",LocalDate.now(),category3,user3);
		ideaDao.insert(idea1);
		ideaDao.insert(idea2);
		ideaDao.insert(idea3);
		
		assertTrue(ideaDao.findAll().size()==3);
	}

	@Test
	public void testFindByKey() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		userDao.insert(user);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		ideaDao.insert(idea);
		
		assertNotNull(idea.getId());
		assertTrue(ideaDao.findByKey(idea.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = ideaDao.findAll().size();
		
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		userDao.insert(user);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		ideaDao.insert(idea);
		
		assertNotNull(idea.getId());
		assertTrue(ideaDao.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		userDao.insert(user);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		ideaDao.insert(idea);
		
		idea.setTitle("idea4");
		idea = ideaDao.update(idea);
		Assert.assertTrue(ideaDao.findByKey(idea.getId()).getTitle().equals("idea4"));
	}

}
