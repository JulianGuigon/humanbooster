package com.topaidi.interfaces;

import java.util.List;

import javassist.NotFoundException;

public interface GenericDao<T, K> {
    List<T> findAll();
    T findByKey(K key) throws NotFoundException;
    void insert(T obj);
    T update(T obj, K key) throws NotFoundException;
    void delete(K key) throws NotFoundException;
}
