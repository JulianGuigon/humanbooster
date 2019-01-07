package com.topaidi.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class CategoryJpaDaoTest {

	private List<Idea> ideas = new ArrayList<>();
	private Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a");
	
	@Test
	public void testUpdateCategory() {
		Category category = new Category("cuisine",LocalDate.now(),admin,ideas);
		CategoryJpaDao categoryJpaDao = new CategoryJpaDao();
		categoryJpaDao.insert(category);
		category.setName("foot");
		try {
			categoryJpaDao.update(category);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(categoryJpaDao.findByKey(category.getId()).getName().equals("foot"));
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@Test
	public void testUpdateCategoryAdmin() {
		Category Category = new Category("cuisine",LocalDate.now(),admin,ideas);
		CategoryJpaDao CategoryJpaDao = new CategoryJpaDao();
		CategoryJpaDao.insert(Category);
		Category.setAdminCreating(new Admin("Jean Paul","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a"));
		try {
			CategoryJpaDao.update(Category);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(CategoryJpaDao.findByKey(Category.getId()).getAdminCreating().getName().equals("Jean Paul"));
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testDeleteCategory() {
		Category category = new Category("cuisine",LocalDate.now(),admin,ideas);
		CategoryJpaDao categoryJpaDao = new CategoryJpaDao();
		categoryJpaDao.insert(category);
		try {
			categoryJpaDao.delete(category);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			categoryJpaDao.findByKey(category.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		Category category1 = new Category("cuisine",LocalDate.now(),admin,ideas);
		Category category2 = new Category("botanique",LocalDate.now(),admin,ideas);
		Category category3 = new Category("echecs",LocalDate.now(),admin,ideas);
		CategoryJpaDao categoryJpaDao = new CategoryJpaDao();
		categoryJpaDao.insert(category1);
		categoryJpaDao.insert(category2);
		categoryJpaDao.insert(category3);
		assertTrue(categoryJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Category category = new Category("cuisine",LocalDate.now(),admin,ideas);
		CategoryJpaDao categoryJpaDao = new CategoryJpaDao();
		categoryJpaDao.insert(category);
		try {
			categoryJpaDao.findByKey(category.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}

}
