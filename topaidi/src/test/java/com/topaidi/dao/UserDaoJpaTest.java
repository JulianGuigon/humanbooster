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
public class UserDaoJpaTest {

	@Autowired
	UserDao userDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	AdminDao adminDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	IdeaDao ideaDao;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		userDao.insert(user);
		
		userDao.delete(user);
		assertNull(userDao.findByKey(user.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		userDao.insert(user);
		
		userDao.deleteByKey(user.getId());
		assertNull(userDao.findByKey(user.getId()));
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		addressDao.insert(address2);
		addressDao.insert(address3);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		userDao.insert(user2);
		userDao.insert(user3);
		
		assertTrue(userDao.findAll().size()==3);
	}
	
	@Test
	public void testFindInvalidUser() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		addressDao.insert(address2);
		addressDao.insert(address3);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a",true,false);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,false);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		userDao.insert(user2);
		userDao.insert(user3);
		
		Assert.assertTrue(userDao.findInvalidUser().size() == 2);
	}
	
	@Test
	public void testFindValidUser() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		addressDao.insert(address2);
		addressDao.insert(address3);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a",true,false);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,false);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		userDao.insert(user2);
		userDao.insert(user3);
		
		Assert.assertTrue(userDao.findValidUser().size() == 1);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		userDao.insert(user);
		
		assertNotNull(user.getId());
		assertTrue(userDao.findByKey(user.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = userDao.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		userDao.insert(user);
		
		assertNotNull(user.getId());
		assertTrue(userDao.findAll().size() == size+1);
	}
	
	@Test
	public void testCreateIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		
		Assert.assertTrue(userDao.createIdea(idea) != null);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		userDao.insert(user);
		
		user.setPassword("bbbb");
		userDao.update(user);
		Assert.assertTrue(userDao.findByKey(user.getId()).getPassword().equals("bbbb"));
	}
	
	@Test
	public void testFindByEmailAndPassword() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		userDao.insert(user);
		
		Assert.assertTrue(userDao.findByEmailAndPassword("a.g@gmail.com", "aaaa") != null);
	}
	
	@Test
	public void testFindEmailExist() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		userDao.insert(user);
		
		Assert.assertTrue(userDao.findEmailExist("a.g@gmail.com"));
	}
	
	@Test
	public void testFindEmailNotExist() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a",true,true);
		userDao.insert(user);
		
		Assert.assertFalse(userDao.findEmailExist("a.g@gm.com"));
	}
}
