package com.topaidi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.model.Address;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class UserServiceJpaTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898",true,true);
		userService.insert(user);
		
		userService.delete(user);
		assertNull(userService.findByKey(user.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898",true,true);
		userService.insert(user);
		
		userService.deleteByKey(user.getId());
		assertNull(userService.findByKey(user.getId()));
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898",true,true);
		userService.insert(user1);
		userService.insert(user2);
		userService.insert(user3);
		
		assertTrue(userService.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898",true,true);
		userService.insert(user);
		
		assertNotNull(user.getId());
		assertTrue(userService.findByKey(user.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = userService.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898",true,true);
		userService.insert(user);
		
		assertNotNull(user.getId());
		assertTrue(userService.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898",true,true);
		userService.insert(user);
		
		user.setPassword("bbbb");
		userService.update(user);
		Assert.assertTrue(userService.findByKey(user.getId()).getPassword().equals("bbbb"));
	}
	
	@Test
	public void testFindByEmailAndPassword() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898",true,true);
		userService.insert(user);
		
		Assert.assertNotNull(userService.findByEmailAndPassword("a.g@gmail.com", "aaaa"));
	}
	
	@Test
	public void testFindByEmailAndPasswordError() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898",true,true);
		userService.insert(user);
		
		Assert.assertNull(userService.findByEmailAndPassword("a.g@gmail.com", "aaab"));
	}
}
