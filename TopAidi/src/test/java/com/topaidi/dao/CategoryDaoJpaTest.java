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

import com.topaidi.config.ContextConfig;
import com.topaidi.dao.interfaces.AddressDao;
import com.topaidi.dao.interfaces.AdminDao;
import com.topaidi.dao.interfaces.CategoryDao;
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.roles.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ContextConfig.class})
@Transactional
public class CategoryDaoJpaTest {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	AdminDao adminDao;
	@Autowired
	AddressDao addressDao;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		
		categoryDao.delete(category);
		assertNull(categoryDao.findByKey(category.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		
		categoryDao.deleteByKey(category.getId());
		assertNull(categoryDao.findByKey(category.getId()));
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
		
		assertTrue(categoryDao.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		
		assertNotNull(category.getId());
		assertTrue(categoryDao.findByKey(category.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = categoryDao.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		
		assertNotNull(category.getId());
		assertTrue(categoryDao.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminDao.insert(admin);
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryDao.insert(category);
		
		category.setName("foot");
		categoryDao.update(category);
		Assert.assertTrue(categoryDao.findByKey(category.getId()).getName().equals("foot"));
	}

}
