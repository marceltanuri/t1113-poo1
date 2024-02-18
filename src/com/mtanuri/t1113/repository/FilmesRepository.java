package com.mtanuri.t1113.repository;

import java.util.List;

import com.mtanuri.t1113.model.filme.Filme;

public interface FilmesRepository {

	  public Filme inserir(Filme filme);
	  
	  public Filme atualizar(int id, String nome, String descricao);
	    
	  public void excluir(int id);
	  
	  public List<Filme> pesquisarPorNome(String nome);
	
}