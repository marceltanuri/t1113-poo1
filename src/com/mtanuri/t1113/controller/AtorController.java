package com.mtanuri.t1113.controller;

import java.util.List;

import com.mtanuri.t1113.repository.impl.AtoresRepositoryInMemoryImpl;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;

public class AtorController {
	
	private AtoresRepositoryInMemoryImpl atoresRepository;
	
	public AtorController() {
		this.atoresRepository = new AtoresRepositoryInMemoryImpl();
	}
	
	public Ator inserir(Ator ator) {
		return atoresRepository.inserir(ator);
	}
	
	public Ator atualizar(int id, String nome, List<Filme> filmes) {
        return atoresRepository.atualizar(id, nome, filmes);
	}
	
	public boolean excluir(int id) {
		try {
			atoresRepository.excluir(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Ator> pesquisarPorNome(String nomeOuParteDoNome) {
		return atoresRepository.pesquisarPorNome(nomeOuParteDoNome);
	}

}
