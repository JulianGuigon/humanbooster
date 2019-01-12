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
import com.topaidi.model.roles.Admin;
import com.topaidi.service.interfaces.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AdminServiceJpaTest {

	@Autowired
	AdminService adminService;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminService.insert(admin);
		
		adminService.delete(admin);
		assertNull(adminService.findByKey(admin.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminService.insert(admin);
		
		adminService.deleteByKey(admin.getId());
		assertNull(adminService.findByKey(admin.getId()));
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","a?","a");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","a?","a");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","a?","a");
		adminService.insert(admin1);
		adminService.insert(admin2);
		adminService.insert(admin3);
		
		assertTrue(adminService.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminService.insert(admin);
		
		assertNotNull(admin.getId());
		assertTrue(adminService.findByKey(admin.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = adminService.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminService.insert(admin);
		
		assertNotNull(admin.getId());
		assertTrue(adminService.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminService.insert(admin);
		
		admin.setPassword("bbbb");
		adminService.update(admin);
		Assert.assertTrue(adminService.findByKey(admin.getId()).getPassword().equals("bbbb"));
	}
}
