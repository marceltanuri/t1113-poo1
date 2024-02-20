package com.mtanuri.t1113.repository;

import java.util.List;

import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;

public interface FilmeRepository {

	public Filme inserir(Filme filme);

	public Filme renomear(int id, String nome);

	public Filme atualizarDescricao(int id, String descricao);

	public Filme adicionarAtor(int idFilme, Ator ator);

	public Filme removerAtor(int idFilme, int idAtor);

	public Filme adicionarDiretor(int idFilme, Diretor diretor);

	public Filme removerDiretor(int idFilme, int idDiretor);

	public void excluir(int id);

	public List<Filme> listarTodos();

	public List<Filme> pesquisarPorNome(String nome);

}