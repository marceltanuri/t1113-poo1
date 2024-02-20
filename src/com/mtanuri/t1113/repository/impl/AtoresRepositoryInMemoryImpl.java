package com.mtanuri.t1113.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.repository.AtoresRepository;

public class AtoresRepositoryInMemoryImpl implements AtoresRepository {
	
	private List<Ator> atores = new ArrayList<Ator>();
    private static int contador = 0;
    
    public AtoresRepositoryInMemoryImpl() {
    	
    }

	@Override
	public Ator inserir(Ator ator) {
    	ator.setId(++contador);
        atores.add(ator);
		return ator;
	}

	@Override
	public Ator atualizar(int id, String nome, List<Filme> filmes) {
    	Ator ator = atores.stream().filter(a -> a.getId() == id).findFirst().get();
        ator.setNome(nome);
        ator.setFilmes(filmes);
        return ator;
	}

	@Override
	public void excluir(int id) {
		atores.removeIf(a -> a.getId() == id);
		
	}

	@Override
	public List<Ator> pesquisarPorNome(String nomeOuParteDoNome) {
		return atores.stream().filter(a->a.getNome().contains(nomeOuParteDoNome)).collect(Collectors.toList());
	}

}
