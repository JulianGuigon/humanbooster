package com.topaidi.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.ContextConfig;
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
@ContextConfiguration(classes= {ContextConfig.class})
@Transactional
public class CommentDaoJpaTest {
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
	public void testDelete() {
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
		
		commentDao.delete(comment);
		assertNull(commentDao.findByKey(comment.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
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
		
		commentDao.deleteByKey(comment.getId());
		assertNull(commentDao.findByKey(comment.getId()));
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
		
		assertTrue(commentDao.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
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
		
		assertNotNull(comment);
		assertTrue(commentDao.findByKey(comment.getId())!=null);
	}
	
	@Test
	public void testInsert() {
		int size = commentDao.findAll().size();
		
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
		
		assertNotNull(comment.getId());
		assertTrue(commentDao.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
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
		
		comment.setValue("Comment4");
		comment = commentDao.update(comment);
		assertTrue(commentDao.findByKey(comment.getId()).getValue().equals("Comment4"));
	}
}
