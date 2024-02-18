package com.mtanuri.t1113.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.repository.DiretoresRepository;

public class DiretoresRepositoryInMemoryImpl implements DiretoresRepository {

	private List<Diretor> diretores = new ArrayList<Diretor>();
    private static int contador = 0;
    
    public DiretoresRepositoryInMemoryImpl() {
    	
    }
	
	@Override
	public Diretor inserir(Diretor diretor) {
	   	diretor.setId(++contador);
        diretores.add(diretor);
		return diretor;
	}

	@Override
	public Diretor atualizar(int id, String nome, List<Filme> filmes) {
	   	Diretor diretor = diretores.stream().filter(f -> f.getId() == id).findFirst().get();
        diretor.setNome(nome);
        diretor.setFilmes(filmes);
        return diretor;
	}

	@Override
	public void excluir(int id) {
		diretores.removeIf(f -> f.getId() == id);
		
	}

	@Override
	public List<Diretor> pesquisarPorNome(String nomeOuParteDoNome) {
		return diretores.stream().filter(f->f.getNome().contains(nomeOuParteDoNome)).collect(Collectors.toList());
	}

}
