package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.Category;
import com.topaidi.model.roles.Admin;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class CategoryJpaDao implements GenericDao<Category, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();
	private AdminJpaDao adminJpaDao = new AdminJpaDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from Category c";
		List<Category> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public Category findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Category result = em.find(Category.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}
	
	public Category findByAttributes(String country, String city, Integer postalCode, String wording, Integer streetNumber) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from Category c where country = ? and city = ? and postalcode = ? and wording = ? and streetnumber = ?");
		query.setParameter(0, country);
		query.setParameter(1, city);
		query.setParameter(2, postalCode);
		query.setParameter(3, wording);
		query.setParameter(4, streetNumber);
		
		try {			
			return (Category)query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public void insert(Category obj) {
		Admin admin = obj.getAdminCreating();
		if(admin.getId()!=0) {
			try {
				admin = adminJpaDao.findByKey(admin.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			adminJpaDao.insert(admin);
		}
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	//Pas de cascade avec admin
	@Override
	public Category update(Category obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Admin Admin = obj.getAdminCreating();
		//TODO bug here
		Admin AdminFound = adminJpaDao.findByAttributes(Admin.getName(), Admin.getEmail(), Admin.getPassword(), Admin.getAddress(), Admin.getPhoneNumber(), Admin.getSecretQuestion(), Admin.getSecretAnswer());
		if(AdminFound!=null) {
			Admin = AdminFound;
		}
		obj.setAdminCreating(em.merge(Admin));//forcer la mise a jour de la nouvelle adresse
		Category entityUpdated = em.find(Category.class, obj.getId());
		if(entityUpdated==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		entityUpdated = obj;
		em.merge(entityUpdated);
		em.getTransaction().commit();
		em.close();
		return entityUpdated;
	}

	@Override
	public void delete(Category obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Category entityDeleted = em.find(Category.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
