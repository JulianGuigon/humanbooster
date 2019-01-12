package com.topaidi.dao.interfaces;

import java.util.List;

public interface GenericDao<T,K> {
	void delete(T obj);
	void deleteByKey(K key);
	List<T> findAll();
    T findByKey(K key);
    T insert(T obj);
    T update(T obj);
}
