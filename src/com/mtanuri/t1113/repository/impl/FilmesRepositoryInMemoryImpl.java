package com.mtanuri.t1113.repository.impl;

import com.mtanuri.t1113.exception.FilmeNotFoundException;
import com.mtanuri.t1113.model.Filme;
import com.mtanuri.t1113.repository.FilmesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilmesRepositoryInMemoryImpl implements FilmesRepository {

    private final List<Filme> filmes =  new ArrayList<>(10);

    protected FilmesRepositoryInMemoryImpl() {

    }

    @Override
    public Filme inserir(Filme filme) {
        filmes.add(filme);
        return filme;
    }

    @Override
    public Filme atualizar(Filme filme) {
        Optional<Filme> optionalFilme = getFilme(filme);
        if (optionalFilme.isEmpty()) {
            throw new FilmeNotFoundException(filme.getId());
        }
        filmes.remove(optionalFilme.get());
        filmes.add(filme);
        return filme;
    }

    private Optional<Filme> getFilme(Filme filme) {
        return filmes.stream().filter(f -> f.equals(filme)).findFirst();
    }
    @Override
    public List<Filme> pesquisar(Predicate<Filme> predicate) {
        return filmes.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Filme> todos() {
        return filmes;
    }

    @Override
    public void excluir(Filme filme) {
        Optional<Filme> optionalFilme = getFilme(filme);
        if (optionalFilme.isEmpty()) {
            throw new FilmeNotFoundException(filme.getId());
        }
        filmes.remove(optionalFilme.get());
    }
}
