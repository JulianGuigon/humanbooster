//package com.topaidi.dao;
//
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import com.topaidi.interfaces.GenericDao;
//import com.topaidi.utility.Connection;
//
//import javassist.NotFoundException;
//
//public abstract class GenericJpaDao<T,K> implements GenericDao<T,K> {
//	private EntityManagerFactory emf = Connection.getInstance().getEmf();
//	private Class<T> type;
//	
//	@SuppressWarnings("unchecked")
//	public GenericJpaDao() {
//		super();
//		this.type = ((Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<T> findAll() {
//		EntityManager em = emf.createEntityManager();
//		String query = "Select t from "+type.getSimpleName()+" t";
//		List<T> result = em.createQuery(query).getResultList();
//		em.close();
//		return result;
//	}
//
//	@Override
//	public T findByKey(K key) throws NotFoundException {
//		EntityManager em = emf.createEntityManager();
//		T result = em.find(type, key);
//		if(result==null) {
//			throw new NotFoundException("The element don't exist in the database.");
//		}
//		em.close();
//		return result;
//	}
//
//	@Override
//	public void insert(T obj) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(obj);
//		em.getTransaction().commit();
//		em.close();
//	}
//
//	@Override
//	public T update(T obj, K key) throws NotFoundException {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		T entityUpdated = em.find(type, key);
//		if(entityUpdated==null) {
//			throw new NotFoundException("The element don't exist in the database.");
//		}
//		entityUpdated = obj;
//		em.merge(entityUpdated);
//		em.getTransaction().commit();
//		em.close();
//		return entityUpdated;
//	}
//
//	@Override
//	public void delete(K key) throws NotFoundException {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		T entityDeleted = em.find(type, key);
//		if(entityDeleted==null) {
//			throw new NotFoundException("The element don't exist in the database.");
//		}
//		em.remove(entityDeleted);
//		em.getTransaction().commit();
//		em.close();
//	}
//}
