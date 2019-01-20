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
import com.topaidi.dao.interfaces.CommentDao;
import com.topaidi.dao.interfaces.IdeaDao;
import com.topaidi.dao.interfaces.UserDao;
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AdminDaoJpaTest {
	@Autowired
	AdminDao adminDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	IdeaDao ideaDao;
	@Autowired
	CommentDao commentDao;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		
		adminDao.delete(admin);
		assertNull(adminDao.findByKey(admin.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		
		adminDao.deleteByKey(admin.getId());
		assertNull(adminDao.findByKey(admin.getId()));
	}
	
	@Test
	public void testDesactiveIdea() {
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
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user);
		ideaDao.insert(idea);
		
		Assert.assertTrue(adminDao.desactiveIdea(idea));
		Assert.assertTrue(ideaDao.findByKey(idea.getId()).getDisabledAt() != null);
		Assert.assertTrue(!idea.isActive());
	}
	
	@Test
	public void testDesactiveUser() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userDao.insert(user);
		
		Assert.assertTrue(adminDao.desactiveUser(user));
		Assert.assertTrue(!user.isActive());
	}
	
	@Test
	public void testActivateUser() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,true);
		userDao.insert(user);
		
		Assert.assertTrue(adminDao.activateUser(user));
		Assert.assertTrue(user.isActive());
	}
	
	@Test
	public void testDesactiveComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address2);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		userDao.insert(user1);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		ideaDao.insert(idea);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address3);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		userDao.insert(user2);
		Comment comment = new Comment("ahaha",user2,idea);
		commentDao.insert(comment);
		
		Assert.assertTrue(adminDao.desactiveComment(comment));
		Assert.assertTrue(!comment.isActive());
	}
	
	@Test
	public void testValidateUser() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		User user = new User("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100",true,false);
		userDao.insert(user);
		
		Assert.assertTrue(adminDao.validateUser(user));
		Assert.assertTrue(user.isValid());
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		addressDao.insert(address2);
		addressDao.insert(address3);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin1);
		adminDao.insert(admin2);
		adminDao.insert(admin3);
		
		assertTrue(adminDao.findAll().size()==3);
	}
	
	@Test
	public void testFindAllError() {
		assertTrue(adminDao.findAll().size()==0);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		
		assertNotNull(admin.getId());
		assertTrue(adminDao.findByKey(admin.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = adminDao.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		
		assertNotNull(admin.getId());
		assertTrue(adminDao.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		
		admin.setPassword("bbbb");
		adminDao.update(admin);
		Assert.assertTrue(adminDao.findByKey(admin.getId()).getPassword().equals("bbbb"));
	}
	
	@Test
	public void testFindByEmailAndPassword() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		
		Assert.assertTrue(adminDao.findByEmailAndPassword("a.g@gmail.com", "aaaa") != null);
	}
	
	@Test
	public void testFindEmailExist() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		
		Assert.assertTrue(adminDao.findEmailExist("a.g@gmail.com"));
	}
	
	@Test
	public void testFindEmailNotExist() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		adminDao.insert(admin);
		
		Assert.assertFalse(adminDao.findEmailExist("a.g@gail.com"));
	}
}
