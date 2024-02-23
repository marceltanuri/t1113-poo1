package com.mtanuri.t1113.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.repository.AtorRepository;

public class AtorRepositoryInMemoryImpl implements AtorRepository {

	private List<Ator> atores = new ArrayList<Ator>();

	private static final AtorRepositoryInMemoryImpl instance = new AtorRepositoryInMemoryImpl();

	private AtorRepositoryInMemoryImpl() {

	}

	public static AtorRepositoryInMemoryImpl getInstance(){
		return instance;
	}

	@Override
	public Ator inserir(Ator ator) {
		atores.add(ator);
		return ator;
	}

	@Override
	public Ator renomear(int id, String nome) {
		Ator ator = atores.stream().filter(a -> a.getId() == id).findFirst().get();
		ator.setNome(nome);
		return ator;
	}

	@Override
	public Ator adicionarFilme(int idAtor, Filme filme) {
		Ator ator = atores.stream().filter(a -> a.getId() == idAtor).findFirst().get();
		ator.getFilmes().add(filme);
		filme.getAtores().add(ator);
		return ator;
	}

	@Override
	public Ator removerFilme(int idAtor, int idFilme) {
		Ator ator = atores.stream().filter(a -> a.getId() == idAtor).findFirst().get();
		Filme filme = ator.getFilmes().stream().filter(f -> f.getId() == idFilme).findFirst().get();
		ator.getFilmes().remove(filme);
		filme.getAtores().remove(ator);
		return ator;
	}

	@Override
	public void excluir(int id) {
		Ator ator = atores.stream().filter(a -> a.getId() == id).findFirst().get();
		
		for (Filme filme : ator.getFilmes()) {
				filme.getAtores().remove(ator);
		}
		
		atores.remove(ator);
	}

	@Override
	public List<Ator> listarTodos() {
		return atores;
	}

	@Override
	public List<Ator> pesquisarPorNome(String nomeOuParteDoNome) {
		return atores.stream().filter(a->a.getNome().contains(nomeOuParteDoNome)).collect(Collectors.toList());
	}

}
