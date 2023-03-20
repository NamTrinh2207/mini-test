package com.example.module3.service;

import java.sql.SQLException;
import java.util.List;

public interface IEmployee<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    void update(int id, T t) throws SQLException;

    void delete(int id);

}