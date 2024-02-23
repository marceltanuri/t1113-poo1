package com.mtanuri.t1113.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.repository.DiretorRepository;

public class DiretorRepositoryInMemoryImpl implements DiretorRepository {

	private List<Diretor> diretores = new ArrayList<Diretor>();

	private static final DiretorRepositoryInMemoryImpl instance = new DiretorRepositoryInMemoryImpl();

	private DiretorRepositoryInMemoryImpl() {

	}

	public static DiretorRepositoryInMemoryImpl getInstance(){
		return instance;
	}

	@Override
	public Diretor inserir(Diretor Diretor) {
		diretores.add(Diretor);
		return Diretor;
	}

	@Override
	public Diretor renomear(int id, String nome) {
		Diretor Diretor = diretores.stream().filter(d -> d.getId() == id).findFirst().get();
		Diretor.setNome(nome);
		return Diretor;
	}

	@Override
	public Diretor adicionarFilme(int idDiretor, Filme filme) {
		Diretor Diretor = diretores.stream().filter(d -> d.getId() == idDiretor).findFirst().get();
		Diretor.getFilmes().add(filme);
		filme.getDiretores().add(Diretor);
		return Diretor;
	}

	@Override
	public Diretor removerFilme(int idDiretor, int idFilme) {
		Diretor Diretor = diretores.stream().filter(d -> d.getId() == idDiretor).findFirst().get();
		Filme filme = Diretor.getFilmes().stream().filter(f -> f.getId() == idFilme).findFirst().get();
		Diretor.getFilmes().remove(filme);
		filme.getDiretores().remove(Diretor);
		return Diretor;
	}

	@Override
	public void excluir(int id) {
		Diretor diretor = diretores.stream().filter(d -> d.getId() == id).findFirst().get();
		
		for (Filme filme : diretor.getFilmes()) {
				filme.getDiretores().remove(diretor);
		}
		
		diretores.remove(diretor);
	}

	@Override
	public List<Diretor> listarTodos() {
		return diretores;
	}

	@Override
	public List<Diretor> pesquisarPorNome(String nomeOuParteDoNome) {
		return diretores.stream().filter(a->a.getNome().contains(nomeOuParteDoNome)).collect(Collectors.toList());
	}

}
