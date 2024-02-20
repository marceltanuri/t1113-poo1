package com.mtanuri.t1113.repository;

import java.util.List;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;

public interface DiretorRepository {

	public Diretor inserir(Diretor diretor);

	public Diretor renomear(int id, String nome);

	public Diretor adicionarFilme(int idDiretor, Filme filme);

	public Diretor removerFilme(int idDiretor, int idFilme);

	public void excluir(int id);
	
	public List<Diretor> listarTodos();

	public List<Diretor> pesquisarPorNome(String nome);

}