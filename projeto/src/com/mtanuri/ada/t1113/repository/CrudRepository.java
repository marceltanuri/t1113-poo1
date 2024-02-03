package com.mtanuri.ada.t1113.repository;

import java.util.List;
import java.util.function.Predicate;

public interface CrudRepository<T> {

    public T inserir(T entry);

    public T atualizar(T entry);

    public List<T> pesquisar(Predicate<T> predicate);

    public List<T> todos();



    public void excluir(T entry);

}
