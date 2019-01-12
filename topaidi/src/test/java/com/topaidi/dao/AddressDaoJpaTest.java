package com.topaidi.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.dao.interfaces.AddressDao;
import com.topaidi.model.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AddressDaoJpaTest {

	@Autowired
	AddressDao addressDao;
	
	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		
		addressDao.delete(address);
		assertNull(addressDao.findByKey(address.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		
		addressDao.deleteByKey(address.getId());
		assertNull(addressDao.findByKey(address.getId()));
	}

	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",9);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",10);
		addressDao.insert(address1);
		addressDao.insert(address2);
		addressDao.insert(address3);
		
		assertTrue(addressDao.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		
		assertNotNull(address.getId());
		assertTrue(addressDao.findByKey(address.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = addressDao.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		
		assertNotNull(address.getId());
		assertTrue(addressDao.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressDao.insert(address);
		
		address.setStreetNumber(4);
		addressDao.update(address);
		assertTrue(addressDao.findByKey(address.getId()).getStreetNumber()==4);
	}
}
