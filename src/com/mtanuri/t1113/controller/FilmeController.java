package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.repository.FilmeRepository;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;

public class FilmeController {

	private FilmeRepository filmesRepository;

	public FilmeController(FilmeRepository repository) {
		this.filmesRepository = repository;
	}

	public void executar(String command, Filme filme) {
		if ("inserir".equals(command)) {
			filmesRepository.inserir(filme);
		}
	}

	public void executar(String command, int idFilme, Ator ator) {
		if("adicionarAtor".equals(command)){
			filmesRepository.adicionarAtor(idFilme, ator);
			return;
		}
	}

	public void executar(String command, int idFilme, Diretor diretor) {
		if("adicionarDiretor".equals(command)){
			filmesRepository.adicionarDiretor(idFilme, diretor);
			return;
		}
	}

	public void executar(String command, int idFilme, int idAtorOuDiretor){
		if("removerAtor".equals(command)){
			filmesRepository.removerAtor(idFilme, idAtorOuDiretor);
			return;
		}

		if("removerDiretor".equals(command)){
			filmesRepository.removerDiretor(idFilme, idAtorOuDiretor);
		}

	}

	public void executar(String command, int id, String nomeOuDescricao) {
		if("renomear".equals(command)) {
			filmesRepository.renomear(id, nomeOuDescricao);
			return;
		}

		if("atualizarDescricao".equals(command)) {
			filmesRepository.atualizarDescricao(id, nomeOuDescricao);
		}
	}

	public void executar(String command, int id) {
		if("excluir".equals(command)) {
			try {
				filmesRepository.excluir(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void executar(String command) {
		if("listarTodos".equals(command)) {
			filmesRepository.listarTodos().forEach((System.out::println));
		}
	}

	public void executar(String command, String nomeOuParteDoNome) {
		if("pesquisarPorNome".equals(command)) {
			filmesRepository.pesquisarPorNome(nomeOuParteDoNome).forEach(System.out::println);
		}
	}

}
