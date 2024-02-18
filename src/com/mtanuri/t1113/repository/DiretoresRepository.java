package com.mtanuri.t1113.repository;

import java.util.List;

import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;

public interface DiretoresRepository {

	  public Diretor inserir(Diretor diretor);
	  
	  public Diretor atualizar(int id, String nome, List<Filme> filmes);
	    
	  public void excluir(int id);
	  
	  public List<Diretor> pesquisarPorNome(String nome);
	
}
