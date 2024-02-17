package com.mtanuri.t1113.repository;

import java.util.ArrayList;
import java.util.List;

import com.mtanuri.t1113.model.Ator;

public interface AtoresRepository {
	
	public List<Ator> atores = new ArrayList();

	  public Ator inserir(Ator ator);
	  
	  public Ator atualizar(Ator ator);
	    
	  public void excluir(Ator ator);
	  
	  public List<Ator> pesquisarPorNome(String nome);
	
}
