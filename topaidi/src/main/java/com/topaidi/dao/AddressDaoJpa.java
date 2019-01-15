package com.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.AddressDao;
import com.topaidi.model.Address;

@Repository
@Transactional
public class AddressDaoJpa implements AddressDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public void delete(Address obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	//this is comment
	@Override
	@SuppressWarnings("unchecked")
	public List<Address> findAll() {
		return em.createQuery("from Address e order by e.id").getResultList();
	}

	@Override
	public Address findByKey(Integer key) {
		return em.find(Address.class, key);
	}

	@Override
	public Address insert(Address obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Address update(Address obj) {
		return em.merge(obj);
	}
}