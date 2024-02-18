package com.mtanuri.t1113.controller;

import java.util.List;

import com.mtanuri.t1113.repository.impl.FilmesRepositoryInMemoryImpl;
import com.mtanuri.t1113.model.filme.Filme;

public class FilmeController {

	private FilmesRepositoryInMemoryImpl filmesRepository;
	
	public FilmeController() {
		this.filmesRepository = new FilmesRepositoryInMemoryImpl();
	}
	
	public Filme inserir(Filme filme) {
		return filmesRepository.inserir(filme);
	}
	
	public Filme atualizar(int id, String nome, String descricao) {
        return filmesRepository.atualizar(id, nome, descricao);
	}
	
	public boolean excluir(int id) {
		try {
			filmesRepository.excluir(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Filme> pesquisarPorNome(String nomeOuParteDoNome) {
		return filmesRepository.pesquisarPorNome(nomeOuParteDoNome);
	}
	
}
