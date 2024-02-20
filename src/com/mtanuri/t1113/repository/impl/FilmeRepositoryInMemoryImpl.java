package com.mtanuri.t1113.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.repository.FilmeRepository;

public class FilmeRepositoryInMemoryImpl implements FilmeRepository {

	private List<Filme> filmes = new ArrayList<Filme>();
	private static int contador = 0;

	public FilmeRepositoryInMemoryImpl(){

	}

	@Override
	public Filme inserir(Filme filme) {
		filme.setId(++contador);
		filmes.add(filme);
		return filme;
	}

	@Override
	public Filme renomear(int id, String nome) {
		Filme filme = filmes.stream().filter(f -> f.getId() == id).findFirst().get();
		filme.setNome(nome);
		return filme;
	}

	@Override
	public Filme atualizarDescricao(int id, String descricao) {
		Filme filme = filmes.stream().filter(f -> f.getId() == id).findFirst().get();
		filme.setDescricao(descricao);
		return filme;
	}

	@Override
	public Filme adicionarAtor(int idFilme, Ator ator) {
		Filme filme = filmes.stream().filter(f -> f.getId() == idFilme).findFirst().get();
		filme.getAtores().add(ator);
		ator.getFilmes().add(filme);
		return filme;
	}

	@Override
	public Filme removerAtor(int idFilme, int idAtor) {
		Filme filme = filmes.stream().filter(f -> f.getId() == idFilme).findFirst().get();
		Ator ator = filme.getAtores().stream().filter(a -> a.getId() == idAtor).findFirst().get();
		filme.getAtores().remove(ator);
		ator.getFilmes().remove(filme);
		return filme;
	}

	@Override
	public Filme adicionarDiretor(int idFilme, Diretor diretor) {
		Filme filme = filmes.stream().filter(f -> f.getId() == idFilme).findFirst().get();
		filme.getDiretores().add(diretor);
		diretor.getFilmes().add(filme);
		return filme;
	}

	@Override
	public Filme removerDiretor(int idFilme, int idDiretor) {
		Filme filme = filmes.stream().filter(f -> f.getId() == idFilme).findFirst().get();
		Diretor diretor = filme.getDiretores().stream().filter(d -> d.getId() == idDiretor).findFirst().get();
		filme.getDiretores().remove(diretor);
		diretor.getFilmes().remove(filme);
		return filme;
	}

	@Override
	public void excluir(int id) {
		filmes.removeIf(f -> f.getId() == id);

	}

	@Override
	public List<Filme> listarTodos() {
		return filmes;
	}

	@Override
	public List<Filme> pesquisarPorNome(String nomeOuParteDoNome) {
		return filmes.stream().filter(f->f.getNome().contains(nomeOuParteDoNome)).collect(Collectors.toList());
	}

}
