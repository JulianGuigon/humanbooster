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
import com.topaidi.model.roles.Admin;
import com.topaidi.service.interfaces.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class CategoryServiceJpaTest {

	@Autowired
	CategoryService categoryService;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryService.insert(category);
		
		categoryService.delete(category);
		assertNull(categoryService.findByKey(category.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryService.insert(category);
		
		categoryService.deleteByKey(category.getId());
		assertNull(categoryService.findByKey(category.getId()));
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100");
		Category category1 = new Category("cuisine",LocalDate.now(),admin1);
		Category category2 = new Category("botanique",LocalDate.now(),admin2);
		Category category3 = new Category("echecs",LocalDate.now(),admin3);
		categoryService.insert(category1);
		categoryService.insert(category2);
		categoryService.insert(category3);
		
		assertTrue(categoryService.findAll().size()==3);
	}
	
	@Test
	public void testFindAllError() {
		assertTrue(categoryService.findAll().size()==0);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryService.insert(category);
		
		assertNotNull(category.getId());
		assertTrue(categoryService.findByKey(category.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = categoryService.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryService.insert(category);
		
		assertNotNull(category.getId());
		assertTrue(categoryService.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		categoryService.insert(category);
		
		category.setName("foot");
		categoryService.update(category);
		Assert.assertTrue(categoryService.findByKey(category.getId()).getName().equals("foot"));
	}

}
