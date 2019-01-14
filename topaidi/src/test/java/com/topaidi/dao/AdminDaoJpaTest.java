package com.topaidi.dao;

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
import com.topaidi.dao.interfaces.AddressDao;
import com.topaidi.dao.interfaces.AdminDao;
import com.topaidi.model.Address;
import com.topaidi.model.roles.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AdminDaoJpaTest {
	@Autowired
	AdminDao adminDao;
	@Autowired
	AddressDao addressDao;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminDao.insert(admin);
		
		adminDao.delete(admin);
		assertNull(adminDao.findByKey(admin.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminDao.insert(admin);
		
		adminDao.deleteByKey(admin.getId());
		assertNull(adminDao.findByKey(admin.getId()));
	}
	
	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address1);
		addressDao.insert(address2);
		addressDao.insert(address3);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898");
		adminDao.insert(admin1);
		adminDao.insert(admin2);
		adminDao.insert(admin3);
		
		assertTrue(adminDao.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminDao.insert(admin);
		
		assertNotNull(admin.getId());
		assertTrue(adminDao.findByKey(admin.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = adminDao.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminDao.insert(admin);
		
		assertNotNull(admin.getId());
		assertTrue(adminDao.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898");
		adminDao.insert(admin);
		
		admin.setPassword("bbbb");
		adminDao.update(admin);
		Assert.assertTrue(adminDao.findByKey(admin.getId()).getPassword().equals("bbbb"));
	}
	
	@Test
	public void testFindByEmailAndPassword() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address,"0477265898","a?","a");
		adminDao.insert(admin);
		
		Assert.assertTrue(adminDao.findByEmailAndPassword("a.g@gmail.com", "aaaa") != null);
	}
}
