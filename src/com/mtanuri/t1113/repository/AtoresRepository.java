package com.mtanuri.t1113.repository;

import java.util.List;

import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;

public interface AtoresRepository {

	  public Ator inserir(Ator ator);
	  
	  public Ator atualizar(int id, String nome, List<Filme> filmes);
	    
	  public void excluir(int id);
	  
	  public List<Ator> pesquisarPorNome(String nome);
	
}
