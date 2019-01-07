package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.topaidi.interfaces.GenericDao;
import com.topaidi.model.Address;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class UserJpaDao implements GenericDao<User, Integer> {
	private EntityManagerFactory emf = Connection.getInstance().getEmf();
	private AddressJpaDao addressJpaDao = new AddressJpaDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "Select c from User c";
		List<User> result = em.createQuery(query).getResultList();
		em.close();
		return result;
	}

	@Override
	public User findByKey(Integer key) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		User result = em.find(User.class, key);
		if(result==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.close();
		return result;
	}

	@Override
	public void insert(User obj) {
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
	public User update(User obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Address address = obj.getAddress();
		Address addressFound = addressJpaDao.findByAttributes(address.getCountry(), address.getCity(), address.getPostalCode(), address.getWording(), address.getStreetNumber());
		if(addressFound!=null) {
			address = addressFound;
		}
		obj.setAddress(em.merge(address));//forcer la mise a jour de la nouvelle adresse
		User entityUpdated = em.find(User.class, obj.getId());
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
	public void delete(User obj) throws NotFoundException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User entityDeleted = em.find(User.class, obj.getId());
		if(entityDeleted==null) {
			throw new NotFoundException("The element don't exist in the database.");
		}
		em.remove(entityDeleted);
		em.getTransaction().commit();
		em.close();
	}
}
