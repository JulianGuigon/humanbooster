package com.topaidi.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.topaidi.model.Address;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class AddressJpaDaoTest {

	@Test
	public void testUpdateAddress() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		AddressJpaDao adressJpaDao = new AddressJpaDao();
		adressJpaDao.insert(address);
		address.setStreetNumber(4);
		try {
			adressJpaDao.update(address);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(adressJpaDao.findByKey(address.getId()).getStreetNumber()==4);
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testDeleteAddress() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		AddressJpaDao adressJpaDao = new AddressJpaDao();
		adressJpaDao.insert(address);
		try {
			adressJpaDao.delete(address);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			adressJpaDao.findByKey(address.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",9);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",10);
		AddressJpaDao addressJpaDao = new AddressJpaDao();
		addressJpaDao.insert(address1);
		addressJpaDao.insert(address2);
		addressJpaDao.insert(address3);
		assertTrue(addressJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Address address = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		AddressJpaDao addressJpaDao = new AddressJpaDao();
		addressJpaDao.insert(address);
		try {
			addressJpaDao.findByKey(address.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}
}
