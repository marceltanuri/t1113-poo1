package com.mtanuri.ada.t1113.repository.impl;

import com.mtanuri.ada.t1113.repository.CrudRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CrudRepositoryFactory {

    private static final Map<Class<?>, CrudRepository<?>> repositories = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> CrudRepository<T> getInstance(Class<T> impl, Class<T> type) throws IOException {

        if (!repositories.containsKey(type)) {
            repositories.put(type, new CrudRepositoryAsJsonImpl<T>());
        }

        return (CrudRepository<T>) repositories.get(type);
    }
}
