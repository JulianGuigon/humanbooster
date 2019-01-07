package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.topaidi.abstracts.Connected;
import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.Address;
import com.topaidi.model.roles.Admin;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class AdminJpaDao implements GenericDao<Admin, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();
	private AddressJpaDao addressJpaDao = new AddressJpaDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from Admin c";
		List<Admin> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public Admin findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Admin result = em.find(Admin.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}
	
	public Admin findByAttributes(String name, String email, String password, Address address, String phoneNumber,
			String secretQuestion, String secretAnswer) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from Admin a where name = :name and email = :email and password = :password and phoneNumber = :phoneNumber and secretQuestion = :secretQuestion and secretAnswer = :secretAnswer and address_adressid = :address_adressid");
		//Query query = em.createQuery("from Admin a, Connected c where c.name = ? and c.email = ? and c.password = ? and c.phoneNumber = ? and c.secretQuestion = ? and c.secretAnswer = ? and c.roleid=a.roleid and c.address_adressid = ?");
		query.setParameter("name", name);
		query.setParameter("email", email);
		query.setParameter("password", password);
		query.setParameter("phoneNumber", phoneNumber);
		query.setParameter("secretQuestion", secretQuestion);
		query.setParameter("secretAnswer", secretAnswer);
		query.setParameter("address_adressid", address.getId()); //LA
		
		try {			
			return (Admin)query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public void insert(Admin obj) {
		Address address = obj.getAddress();
		if(address.getId()!=null) {
			try {
				address = addressJpaDao.findByKey(address.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			addressJpaDao.insert(address);
		}
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Admin update(Admin obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Address address = obj.getAddress();
		Address addressFound = addressJpaDao.findByAttributes(address.getCountry(), address.getCity(), address.getPostalCode(), address.getWording(), address.getStreetNumber());
		if(addressFound!=null) {
			address = addressFound;
		}
		obj.setAddress(em.merge(address));//forcer la mise a jour de la nouvelle adresse
		Admin entityUpdated = em.find(Admin.class, obj.getId());
		if(entityUpdated==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		entityUpdated = obj;
		em.merge(entityUpdated);
		em.getTransaction().commit();
		em.close();
		return entityUpdated;
	}

	//TODO si on s'ennuis on peut rechercher d'autres peronnes qui utilisent l'adresse. si non, on supprime l'adresse (et gare à toi.)
	@Override
	public void delete(Admin obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Admin entityDeleted = em.find(Admin.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
