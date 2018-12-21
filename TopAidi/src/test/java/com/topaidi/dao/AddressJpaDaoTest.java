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
		Address v = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		AddressJpaDao genericDao1 = new AddressJpaDao();
		genericDao1.insert(v);
		v.setStreetNumber(4);
		try {
			genericDao1.findByKey(v.getId());
		} catch (NotFoundException e) {
			fail();
		}
		Assert.assertTrue(v.getStreetNumber()==4);
	}

	@Test
	public void testDeleteAddress() {
		Address v = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		AddressJpaDao genericDao1 = new AddressJpaDao();
		genericDao1.insert(v);
		try {
			genericDao1.delete(v);
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testFindAll() {
		Address h1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address h2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",9);
		Address h3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",10);
		AddressJpaDao genericDao1 = new AddressJpaDao();
		genericDao1.insert(h1);
		genericDao1.insert(h2);
		genericDao1.insert(h3);
		assertTrue(genericDao1.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Address v = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		AddressJpaDao genericDao1 = new AddressJpaDao();
		genericDao1.insert(v);
		try {
			genericDao1.findByKey(v.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}
}
