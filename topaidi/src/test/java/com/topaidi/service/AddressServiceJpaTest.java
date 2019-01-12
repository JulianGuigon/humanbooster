package com.topaidi.service;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.model.Address;
import com.topaidi.service.interfaces.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AddressServiceJpaTest {

	@Autowired
	AddressService addressService;

	@Test
	public void testDelete() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressService.insert(address);
		
		addressService.delete(address);
		assertNull(addressService.findByKey(address.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressService.insert(address);
		
		addressService.deleteByKey(address.getId());
		assertNull(addressService.findByKey(address.getId()));
	}

	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",9);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",10);
		addressService.insert(address1);
		addressService.insert(address2);
		addressService.insert(address3);
		
		assertTrue(addressService.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressService.insert(address);
		
		assertNotNull(address.getId());
		assertTrue(addressService.findByKey(address.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = addressService.findAll().size();
		
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressService.insert(address);
		
		assertNotNull(address.getId());
		assertTrue(addressService.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		addressService.insert(address);
		
		address.setStreetNumber(4);
		addressService.update(address);
		assertTrue(addressService.findByKey(address.getId()).getStreetNumber()==4);
	}
}
