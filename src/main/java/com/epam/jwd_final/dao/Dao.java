package com.epam.jwd_final.dao;

import java.util.Optional;

public interface Dao<T> {
    Optional<T> findById(int id);
    /**TO DO
     * add create
     *
    * */
    void create();
    void update(T entity);
    void delete(T entity);
}
