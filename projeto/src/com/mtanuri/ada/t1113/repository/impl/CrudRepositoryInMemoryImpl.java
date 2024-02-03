package com.mtanuri.ada.t1113.repository.impl;

import com.mtanuri.ada.t1113.exception.EntryNotFoundException;
import com.mtanuri.ada.t1113.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CrudRepositoryInMemoryImpl<T> implements CrudRepository<T> {

    private final List<T> data = new ArrayList<>(10);

    protected CrudRepositoryInMemoryImpl() {

    }

    @Override
    public T inserir(T entry) {
        data.add(entry);
        return entry;
    }

    @Override
    public T atualizar(T entry) {
        Optional<T> optionalEntry = getEntry(entry);
        if (optionalEntry.isEmpty()) {
            throw new EntryNotFoundException(entry);
        }
        data.remove(optionalEntry.get());
        data.add(entry);
        return entry;
    }

    private Optional<T> getEntry(T entry) {
        return data.stream().filter(e -> e.equals(entry)).findFirst();
    }

    @Override
    public List<T> pesquisar(Predicate<T> predicate) {
        return data.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<T> todos() {
        return data;
    }

    @Override
    public void excluir(T entry) {
        Optional<T> optionalEntry = getEntry(entry);
        if (optionalEntry.isEmpty()) {
            throw new EntryNotFoundException(entry);
        }
        data.remove(optionalEntry.get());
    }
}
