package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.dto.CrudDTO;
import com.mtanuri.t1113.repository.CrudRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class CrudController<T> {

    private final CrudRepository<T> crudRepository;

    protected CrudController(CrudRepository<T> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<CrudDTO<T>> listarTodos(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object o = clazz.getDeclaredConstructor().newInstance();

        @SuppressWarnings("unchecked")
        CrudDTO<T> dto = (CrudDTO<T>) o;
        return crudRepository.todos().stream().map(dto::from).collect(Collectors.toList());
    }

    public CrudDTO<T> inserir(CrudDTO<T> entry) {
        T model = crudRepository.inserir(entry.to());
        return entry.from(model);
    }

    public CrudDTO<T> alterar(CrudDTO<T> entry) {
        T model = crudRepository.atualizar(entry.to());
        return entry.from(model);
    }

    public boolean excluir(CrudDTO<T> entry) {
        try {
            crudRepository.excluir(entry.to());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<CrudDTO<T>> pesquisar(FiltroBusca filtroBusca, CrudDTO<T> dto) {
        return crudRepository.pesquisar(null).stream().map(dto::from).collect(Collectors.toList());
    }
}
