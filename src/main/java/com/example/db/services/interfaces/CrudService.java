package com.example.db.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudService <T>{
    void delete(T elem);

    void save(T elem);

    Optional<T> findById(long id);

    List<T> findAll();
}
