package com.mtanuri.ada.t1113.controller;

import com.mtanuri.ada.t1113.repository.CrudRepository;
import com.mtanuri.ada.t1113.repository.impl.CrudRepositoryFactory;

import java.util.HashMap;
import java.util.Map;

public class CrudControllerFactory {

    private static final Map<Class<?>, CrudController<?>> controllers = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> CrudController<T> getInstance(Class<T> type) {

        if (!controllers.containsKey(type)) {
            CrudRepository<T> repository = CrudRepositoryFactory.getInstance(type);
            CrudController<T> controller = new CrudController<>(repository);
            controllers.put(type, controller);
        }
        return (CrudController<T>) controllers.get(type);
    }

}
