package com.mtanuri.t1113.repository;

import java.util.ArrayList;
import java.util.List;

import com.mtanuri.t1113.model.Diretor;
import com.mtanuri.t1113.model.Filme;

public interface DiretoresRepository {
	
	  public static List<Diretor> diretores = new ArrayList<>();

	  public Diretor inserir(Diretor diretor);
	  
	  public Diretor atualizar(Diretor diretor);
	    
	  public void excluir(Diretor diretor);
	  
	  public List<Diretor> pesquisarPorNome(String nome);
	
}
