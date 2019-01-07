package com.topaidi.dao;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

import javassist.NotFoundException;

public class poubelle {
	/*
	Admin Admin = obj.getAdmin();
	Admin AdminFound = AdminJpaDao.findByAttributes(Admin.getCountry(), Admin.getCity(), Admin.getPostalCode(), Admin.getWording(), Admin.getStreetNumber());
	if(AdminFound!=null) {
		Admin = AdminFound;
	}
	obj.setAdmin(em.merge(Admin));//forcer la mise a jour de la nouvelle adresse
	
	//---
	
	public Admin findByAttributes(String country, String city, Integer postalCode, String wording, Integer streetNumber) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from Admin c where country = ? and city = ? and postalcode = ? and wording = ? and streetnumber = ?");
		query.setParameter(0, country);
		query.setParameter(1, city);
		query.setParameter(2, postalCode);
		query.setParameter(3, wording);
		query.setParameter(4, streetNumber);
		
		try {			
			return (Admin)query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	//---
	
	@Test
	public void testUpdateCategoryAdmin() {
		Category Category = new Category("Jean Guy","a.g@gmail.com","aaaa",Admin,"0477265898","a?","a",true,true);
		CategoryJpaDao CategoryJpaDao = new CategoryJpaDao();
		CategoryJpaDao.insert(Category);
		Category.setAdmin(new Admin("France","Lyon",69130,"chemin Louis Chirpaz",9));
		try {
			CategoryJpaDao.update(Category);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(CategoryJpaDao.findByKey(Category.getId()).getAdmin().getStreetNumber()==9);
		} catch (NotFoundException e) {
			fail();
		}
	}
	*/
}	
