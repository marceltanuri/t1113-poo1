package com.mtanuri.t1113.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mtanuri.t1113.model.Filme;
import com.mtanuri.t1113.repository.FilmesRepository;

public class FilmesRepositoryImpl implements FilmesRepository {

	private static List<Filme> filmes = new ArrayList<Filme>();
    private static int contador = 0;
    
    private FilmesRepositoryImpl(){

    }
	
	@Override
	public Filme inserir(Filme filme) {
    	filme.setId(++contador);
        filmes.add(filme);
		return filme;
	}

	@Override
	public Filme atualizar(int id, String nome, String descricao) {
        	Filme filme = filmes.stream().filter(f -> f.getId() == id).findFirst().get();
	        filme.setNome(nome);
	        filme.setDescricao(descricao);
	        return filme;
	}

	@Override
	public void excluir(int id) {
		filmes.removeIf(f -> f.getId() == id);
		
	}

	@Override
	public List<Filme> pesquisarPorNome(String nomeOuParteDoNome) {
		return filmes.stream().filter(f->f.getNome().contains(nomeOuParteDoNome)).collect(Collectors.toList());
	}

}
