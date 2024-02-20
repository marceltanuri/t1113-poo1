package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.repository.AtorRepository;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;

public class AtorController {

	private AtorRepository atoresRepository;

	public AtorController(AtorRepository repository) {
		this.atoresRepository = repository;
	}

	public void executar(String command, Ator ator) {
		if ("inserir".equals(command)) {
			atoresRepository.inserir(ator);
		}
	}

	public void executar(String command, int idAtor, Filme filme){
		if("adicionarFilme".equals(command)){
			atoresRepository.adicionarFilme(idAtor, filme);
		}
	}

	public void executar(String command, int idAtor, int idFilme){
		if("removerFilme".equals(command)){
			atoresRepository.removerFilme(idAtor, idFilme);
		}
	}

	public void executar(String command, int id, String nome) {
		if("renomear".equals(command)) {
			atoresRepository.renomear(id, nome);
		}
	}

	public void executar(String command, int id) {
		if("excluir".equals(command)) {
			try {
				atoresRepository.excluir(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void executar(String command) {
		if("listarTodos".equals(command)) {
			atoresRepository.listarTodos().forEach((System.out::println));
		}
	}

	public void executar(String command, String nomeOuParteDoNome) {
		if("pesquisarPorNome".equals(command)) {
			atoresRepository.pesquisarPorNome(nomeOuParteDoNome).forEach(System.out::println);
		}
	}

}
