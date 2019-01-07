package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.Address;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class AddressJpaDao implements GenericDao<Address, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from Address c";
		List<Address> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public Address findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Address result = em.find(Address.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}
	
	public Address findByAttributes(String country, String city, Integer postalCode, String wording, Integer streetNumber) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from Address c where country = ? and city = ? and postalcode = ? and wording = ? and streetnumber = ?");
		query.setParameter(0, country);
		query.setParameter(1, city);
		query.setParameter(2, postalCode);
		query.setParameter(3, wording);
		query.setParameter(4, streetNumber);
		
		try {			
			return (Address)query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public void insert(Address obj) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Address update(Address obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Address entityUpdated = em.find(Address.class, obj.getId());
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
	public void delete(Address obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Address entityDeleted = em.find(Address.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
