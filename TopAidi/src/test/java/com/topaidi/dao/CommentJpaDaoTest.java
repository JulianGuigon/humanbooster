package com.topaidi.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.Comment;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class CommentJpaDaoTest {
	private User user = new User("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a",true,true);
	private Idea idea = new Idea("idea1","a","a",LocalDate.now(),new Category("cuisine",LocalDate.now(),new Admin("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a"),null),user);
	
	@Before
	public void init() {
		
	}

	@Test
	public void testUpdateComment() {
		Comment comment = new Comment("ahaha",user,idea);
		CommentJpaDao commentJpaDao = new CommentJpaDao();
		commentJpaDao.insert(comment);
		comment.setValue("Comment4");
		try {
			comment = commentJpaDao.update(comment);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(commentJpaDao.findByKey(comment.getId()).getValue().equals("Comment4"));
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testDeleteComment() {
		Comment comment = new Comment("ahaha",user,idea);
		CommentJpaDao commentJpaDao = new CommentJpaDao();
		commentJpaDao.insert(comment);
		try {
			commentJpaDao.delete(comment);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			commentJpaDao.findByKey(comment.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		Comment comment1 = new Comment("ahaha",user,idea);
		Comment comment2 = new Comment("ahaha2",user,idea);
		Comment comment3 = new Comment("ahaha3",user,idea);
		CommentJpaDao commentJpaDao = new CommentJpaDao();
		commentJpaDao.insert(comment1);
		commentJpaDao.insert(comment2);
		commentJpaDao.insert(comment3);
		assertTrue(commentJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Comment comment = new Comment("ahaha",user,idea);
		CommentJpaDao commentJpaDao = new CommentJpaDao();
		commentJpaDao.insert(comment);
		try {
			commentJpaDao.findByKey(comment.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}
}
