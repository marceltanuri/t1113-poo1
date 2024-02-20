package com.mtanuri.t1113.repository;

import java.util.List;

import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;

public interface AtorRepository {

	public Ator inserir(Ator ator);

	public Ator renomear(int id, String nome);

	public Ator adicionarFilme(int idAtor, Filme filme);

	public Ator removerFilme(int idAtor, int idFilme);

	public void excluir(int id);
	
	public List<Ator> listarTodos();

	public List<Ator> pesquisarPorNome(String nome);

}
