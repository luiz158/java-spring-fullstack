package com.fabianogoes.jsfs.service;

public interface CrudService<T> {

    T create(T entity);
    Iterable<T> getAll();
    T getById(String id);
    T update(String id, T entity);
    void delete(String id);

}

