package com.topaidi.service;

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
import com.topaidi.enums.AlertType;
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.AlertService;
import com.topaidi.service.interfaces.CommentService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class UserServiceJpaTest {

	@Autowired
	UserService userService;
	@Autowired
	AlertService alertService;
	@Autowired
	IdeaService ideaService;
	@Autowired
	CommentService commentService;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		userService.delete(user);
		assertNull(userService.findByKey(user.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		userService.deleteByKey(user.getId());
		assertNull(userService.findByKey(user.getId()));
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user1);
		userService.insert(user2);
		userService.insert(user3);
		
		assertTrue(userService.findAll().size()==3);
	}
	
	@Test
	public void testFindAllByName() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user1);
		userService.insert(user2);
		userService.insert(user3);
		
		assertTrue(userService.findAllByName("Jean Guy").size()==2);
	}
	
	@Test
	public void testFindInvalidUser() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,false);
		userService.insert(user1);
		userService.insert(user2);
		userService.insert(user3);
		
		assertTrue(userService.findInvalidUser().size() == 1);
	}
	
	@Test
	public void testFindValidUser() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,false);
		userService.insert(user1);
		userService.insert(user2);
		userService.insert(user3);
		
		assertTrue(userService.findValidUser().size() == 2);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		assertNotNull(user.getId());
		assertTrue(userService.findByKey(user.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = userService.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		assertNotNull(user.getId());
		assertTrue(userService.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		user.setPassword("bbbb");
		userService.update(user);
		Assert.assertTrue(userService.findByKey(user.getId()).getPassword().equals("bbbb"));
	}
	
	@Test
	public void testFindByEmailAndPassword() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		Assert.assertNotNull(userService.findByEmailAndPassword("a.g@gmail.com", "aaaa"));
	}
	
	@Test
	public void testFindByEmailAndPasswordError() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		Assert.assertNull(userService.findByEmailAndPassword("a.g@gmail.com", "aaab"));
	}
	
	@Test
	public void testFindEmailExist() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		Assert.assertTrue(userService.findEmailExist("a.g@gmail.com"));
	}
	
	@Test
	public void testFindEmailNotExist() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userService.insert(user);
		
		Assert.assertFalse(userService.findEmailExist("a.g@gm.com"));
	}
	
	@Test
	public void testAlertIdea() {
		int size = alertService.findAll().size();
		
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		ideaService.insert(idea);
		
		userService.alertIdea(idea, "bof bof", AlertType.Idea);
		
		Assert.assertTrue(alertService.findAll().size() == size+1);
	}
	
	@Test
	public void testAlertComment() {
		int size = commentService.findAll().size();
		
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment = new Comment("ahaha",user2,idea);
		commentService.insert(comment);
		
		userService.alertComment(comment, "il est méchant", AlertType.Comment);
		Assert.assertTrue(alertService.findAll().size() == size+1);
	}
}
