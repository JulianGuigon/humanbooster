//package com.topaidi.dao;
//
//import static org.junit.Assert.*;
//
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import javax.print.attribute.standard.DateTimeAtCompleted;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Test;
//
//import com.topaidi.model.Address;
//import com.topaidi.model.Category;
//import com.topaidi.model.Idea;
//import com.topaidi.model.roles.Admin;
//import com.topaidi.utility.Connection;
//
//import javassist.NotFoundException;
//
//public class CategoryJpaDaoTest {
//
//	List<Idea> ideas = new ArrayList<>();
//	Address a = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
//	Admin ad = new Admin("Jean Guy","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
//	
//	@Test
//	public void testUpdateCategory() {
//		Category v = new Category("cuisine",LocalDate.now(),ad,ideas);
//		CategoryJpaDao genericDao1 = new CategoryJpaDao();
//		genericDao1.insert(v);
//		v.setPassword("bbbb");
//		try {
//			genericDao1.findByKey(v.getId());
//		} catch (NotFoundException e) {
//			fail();
//		}
//		Assert.assertTrue(v.getPassword().equals("bbbb"));
//	}
//
//	@Test
//	public void testDeleteCategory() {
//		Category v = new Category("Jean Guy","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
//		CategoryJpaDao genericDao1 = new CategoryJpaDao();
//		genericDao1.insert(v);
//		try {
//			genericDao1.delete(v);
//		} catch (NotFoundException e) {
//			fail();
//		}
//	}
//
//	@Test
//	public void testFindAll() {
//		Category h1 = new Category("Jean Guy","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
//		Category h2 = new Category("Jean Robert","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
//		Category h3 = new Category("Jean Bernard","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
//		CategoryJpaDao genericDao1 = new CategoryJpaDao();
//		genericDao1.insert(h1);
//		genericDao1.insert(h2);
//		genericDao1.insert(h3);
//		assertTrue(genericDao1.findAll().size()==3);
//	}
//
//	@Test
//	public void testInsertAndFindByKey() {
//		Category v = new Category("Jean Guy","a.g@gmail.com","aaaa",a,"0477265898","a?","a");
//		CategoryJpaDao genericDao1 = new CategoryJpaDao();
//		genericDao1.insert(v);
//		try {
//			genericDao1.findByKey(v.getId());
//		} catch (NotFoundException e) {
//			fail();
//		}
//	}
//	
//	@After
//	public void after() {
//		Connection.stop();
//	}
//
//}
