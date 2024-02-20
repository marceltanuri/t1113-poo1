package com.mtanuri.t1113.controller;

import java.util.List;

import com.mtanuri.t1113.repository.DiretoresRepository;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;

public class DiretorController {

	private DiretoresRepository diretoresRepository;
	
	public DiretorController(DiretoresRepository repository) {
		this.diretoresRepository = repository;
	}
	
	public Diretor inserir(Diretor diretor) {
		return diretoresRepository.inserir(diretor);
	}
	
	public Diretor atualizar(int id, String nome, List<Filme> filmes) {
        return diretoresRepository.atualizar(id, nome, filmes);
	}
	
	public boolean excluir(int id) {
		try {
			diretoresRepository.excluir(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Diretor> pesquisarPorNome(String nomeOuParteDoNome) {
		return diretoresRepository.pesquisarPorNome(nomeOuParteDoNome);
	}
	
}