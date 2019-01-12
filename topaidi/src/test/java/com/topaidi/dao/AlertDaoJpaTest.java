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
import com.topaidi.dao.interfaces.AlertDao;
import com.topaidi.dao.interfaces.CategoryDao;
import com.topaidi.dao.interfaces.CommentDao;
import com.topaidi.dao.interfaces.IdeaDao;
import com.topaidi.dao.interfaces.UserDao;
import com.topaidi.model.Address;
import com.topaidi.model.Alert;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AlertDaoJpaTest {
	@Autowired
	AlertDao alertDao;
	@Autowired
	CommentDao commentDao;
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
	public void testDeleteWithIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Alert alert = new Alert("Alert1",idea,user2);
		alertDao.insert(alert);
		
		alertDao.delete(alert);
		assertNull(alertDao.findByKey(alert.getId()));
	}
	
	@Test
	public void testDeleteWithComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Comment comment = new Comment("ahaha",user2,idea);
		commentDao.insert(comment);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address4);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","a?","a",true,true);
		userDao.insert(user3);
		Alert alert = new Alert("Alert1",comment,user3);
		alertDao.insert(alert);
		
		alertDao.delete(alert);
		assertNull(alertDao.findByKey(alert.getId()));
	}
	
	@Test
	public void testDeleteByKeyWithIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Alert alert = new Alert("Alert1",idea,user2);
		alertDao.insert(alert);
		
		alertDao.deleteByKey(alert.getId());
		assertNull(alertDao.findByKey(alert.getId()));
	}
	
	@Test
	public void testDeleteByKeyWithComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Comment comment = new Comment("ahaha",user2,idea);
		commentDao.insert(comment);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address4);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","a?","a",true,true);
		userDao.insert(user3);
		Alert alert = new Alert("Alert1",comment,user3);
		alertDao.insert(alert);
		
		alertDao.deleteByKey(alert.getId());
		assertNull(alertDao.findByKey(alert.getId()));
	}

	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		addressDao.insert(address2);
		addressDao.insert(address3);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","a?","a");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","a?","a");
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
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","a?","a",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","a?","a",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address6,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		userDao.insert(user2);
		userDao.insert(user3);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Idea idea3 = new Idea("idea3","a","a",LocalDate.now(),category3,user3);
		ideaDao.insert(idea1);
		ideaDao.insert(idea2);
		ideaDao.insert(idea3);
		Address address7 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address8 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address9 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address7);
		addressDao.insert(address8);
		addressDao.insert(address9);
		User user4 = new User("Jean Guy","a.g@gmail.com","aaaa",address7,"0477265898","a?","a",true,true);
		User user5 = new User("Jean Robert","a.g@gmail.com","aaaa",address8,"0477265898","a?","a",true,true);
		User user6 = new User("Jean Bernard","a.g@gmail.com","aaaa",address9,"0477265898","a?","a",true,true);
		userDao.insert(user4);
		userDao.insert(user5);
		userDao.insert(user6);
		Comment comment1 = new Comment("ahaha",user4,idea1);
		Comment comment2 = new Comment("ahaha2",user5,idea2);
		Comment comment3 = new Comment("ahaha3",user6,idea3);
		commentDao.insert(comment1);
		commentDao.insert(comment2);
		commentDao.insert(comment3);
		Address address10 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address11 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address12 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address10);
		addressDao.insert(address11);
		addressDao.insert(address12);
		User user7 = new User("Jean Guy","a.g@gmail.com","aaaa",address10,"0477265898","a?","a",true,true);
		User user8 = new User("Jean Robert","a.g@gmail.com","aaaa",address11,"0477265898","a?","a",true,true);
		User user9 = new User("Jean Bernard","a.g@gmail.com","aaaa",address12,"0477265898","a?","a",true,true);
		userDao.insert(user7);
		userDao.insert(user8);
		userDao.insert(user9);
		Alert alert1 = new Alert("Alert1",comment1,user7);
		Alert alert2 = new Alert("Alert2",comment2,user8);
		Alert alert3 = new Alert("Alert3",comment3,user9);
		alertDao.insert(alert1);
		alertDao.insert(alert2);
		alertDao.insert(alert3);
		
		Address address13 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address14 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address15 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address13);
		addressDao.insert(address14);
		addressDao.insert(address15);
		Admin admin4 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address13,"0477265898","a?","a");
		Admin admin5 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address14,"0477265898","a?","a");
		Admin admin6 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address15,"0477265898","a?","a");
		adminDao.insert(admin4);
		adminDao.insert(admin5);
		adminDao.insert(admin6);
		Category category4 = new Category("cuisine",LocalDate.now(),admin4);
		Category category5 = new Category("botanique",LocalDate.now(),admin5);
		Category category6 = new Category("echecs",LocalDate.now(),admin6);
		categoryDao.insert(category4);
		categoryDao.insert(category5);
		categoryDao.insert(category6);
		Address address16 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address17 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address18 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address16);
		addressDao.insert(address17);
		addressDao.insert(address18);
		User user10 = new User("Jean Guy","a.g@gmail.com","aaaa",address16,"0477265898","a?","a",true,true);
		User user11 = new User("Jean Robert","a.g@gmail.com","aaaa",address17,"0477265898","a?","a",true,true);
		User user12 = new User("Jean Bernard","a.g@gmail.com","aaaa",address18,"0477265898","a?","a",true,true);
		userDao.insert(user10);
		userDao.insert(user11);
		userDao.insert(user12);
		Idea idea4 = new Idea("idea1","a","a",LocalDate.now(),category4,user10);
		Idea idea5 = new Idea("idea2","a","a",LocalDate.now(),category5,user11);
		Idea idea6 = new Idea("idea3","a","a",LocalDate.now(),category6,user12);
		ideaDao.insert(idea4);
		ideaDao.insert(idea5);
		ideaDao.insert(idea6);
		Alert alert4 = new Alert("Alert1",idea4,user10);
		Alert alert5 = new Alert("Alert2",idea5,user11);
		Alert alert6 = new Alert("Alert3",idea6,user12);
		alertDao.insert(alert4);
		alertDao.insert(alert5);
		alertDao.insert(alert6);
		
		assertTrue(alertDao.findAll().size()==6);
	}
	
	@Test
	public void testFindByKeyWithIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Alert alert = new Alert("Alert1",idea,user2);
		alertDao.insert(alert);
		
		assertNotNull(alert);
		assertTrue(alertDao.findByKey(alert.getId())!=null);
	}
	
	@Test
	public void testFindByKeyWithComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Comment comment = new Comment("ahaha",user2,idea);
		commentDao.insert(comment);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address4);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","a?","a",true,true);
		userDao.insert(user3);
		Alert alert = new Alert("Alert1",comment,user3);
		alertDao.insert(alert);
		
		assertNotNull(alert);
		assertTrue(alertDao.findByKey(alert.getId())!=null);
	}
	
	@Test
	public void testInsertWithInsert() {
		int size = alertDao.findAll().size();
		
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Alert alert = new Alert("Alert1",idea,user2);
		alertDao.insert(alert);
		
		assertNotNull(alert.getId());
		assertTrue(alertDao.findAll().size() == size+1);
	}
	
	@Test
	public void testInsertWithComment() {
		int size = alertDao.findAll().size();
		
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Comment comment = new Comment("ahaha",user2,idea);
		commentDao.insert(comment);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address4);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","a?","a",true,true);
		userDao.insert(user3);
		Alert alert = new Alert("Alert1",comment,user3);
		alertDao.insert(alert);
		
		assertNotNull(alert.getId());
		assertTrue(alertDao.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdateWithIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Alert alert = new Alert("Alert1",idea,user2);
		alertDao.insert(alert);
		
		alert.setMessage("Alert4");
		alert = alertDao.update(alert);
		Assert.assertTrue(alertDao.findByKey(alert.getId()).getMessage().equals("Alert4"));
	}
	
	@Test
	public void testUpdateWithComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","a?","a",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","a?","a",true,true);
		userDao.insert(user2);
		Comment comment = new Comment("ahaha",user2,idea);
		commentDao.insert(comment);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address4);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","a?","a",true,true);
		userDao.insert(user3);
		Alert alert = new Alert("Alert1",comment,user3);
		alertDao.insert(alert);
		
		alert.setMessage("Alert4");
		alert = alertDao.update(alert);
		Assert.assertTrue(alertDao.findByKey(alert.getId()).getMessage().equals("Alert4"));
	}
}
