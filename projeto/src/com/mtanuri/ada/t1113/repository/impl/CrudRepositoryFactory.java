package com.mtanuri.ada.t1113.repository.impl;

import com.mtanuri.ada.t1113.model.Filme;
import com.mtanuri.ada.t1113.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;

public class CrudRepositoryFactory {

    private static final Map<Class<?>, CrudRepository<?>> repositories = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> CrudRepository<T> getInstance(Class<T> type) {

        if (!repositories.containsKey(type)) {
            repositories.put(type, new CrudRepositoryInMemoryImpl<T>());
        }

        return (CrudRepository<T>) repositories.get(type);
    }
}
