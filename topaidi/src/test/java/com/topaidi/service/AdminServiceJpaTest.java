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
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.AdminService;
import com.topaidi.service.interfaces.CommentService;
import com.topaidi.service.interfaces.GenericService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AdminServiceJpaTest {

	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	@Autowired
	IdeaService ideaService;
	@Autowired
	CommentService commentService;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminService.insert(admin);
		
		adminService.delete(admin);
		assertNull(adminService.findByKey(admin.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminService.insert(admin);
		
		adminService.deleteByKey(admin.getId());
		assertNull(adminService.findByKey(admin.getId()));
	}
	
	@Test
	public void testDesactiveIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		ideaService.insert(idea);
		
		Assert.assertTrue(adminService.desactiveIdea(idea));
		Assert.assertTrue(ideaService.findByKey(idea.getId()).getDisabledAt() != null);
	}
	
	@Test
	public void testDesactiveUser() {
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		userService.insert(user);
		
		Assert.assertTrue(adminService.desactiveUser(user));
		Assert.assertTrue(!user.isActive());
	}
	
	@Test
	public void testDesactiveComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898",true,true);
		Comment comment = new Comment("ahaha",user2,idea);
		commentService.insert(comment);
		
		Assert.assertTrue(adminService.desactiveComment(comment));
		Assert.assertTrue(!comment.isActive());
	}
	
	@Test
	public void testValidateUser() {
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898",true,false);
		userService.insert(user);
		
		Assert.assertTrue(adminService.validateUser(user));
		Assert.assertTrue(user.isValid());
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898");
		adminService.insert(admin1);
		adminService.insert(admin2);
		adminService.insert(admin3);
		
		assertTrue(adminService.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminService.insert(admin);
		
		assertNotNull(admin.getId());
		assertTrue(adminService.findByKey(admin.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = adminService.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminService.insert(admin);
		
		assertNotNull(admin.getId());
		assertTrue(adminService.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminService.insert(admin);
		
		admin.setPassword("bbbb");
		adminService.update(admin);
		Assert.assertTrue(adminService.findByKey(admin.getId()).getPassword().equals("bbbb"));
	}
	
	@Test
	public void testFindByEmailAndPassword() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminService.insert(admin);
		
		Assert.assertTrue(adminService.findByEmailAndPassword("a.g@gmail.com", "aaaa") != null);
	}
}
