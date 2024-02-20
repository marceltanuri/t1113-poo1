package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.repository.DiretorRepository;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;

public class DiretorController {

	private DiretorRepository diretoresRepository;

	public DiretorController(DiretorRepository repository) {
		this.diretoresRepository = repository;
	}

	public void executar(String command, Diretor diretor) {
		if ("inserir".equals(command)) {
			diretoresRepository.inserir(diretor);
		}
	}

	public void executar(String command, int idDiretor, Filme filme){
		if("adicionarFilme".equals(command)){
			diretoresRepository.adicionarFilme(idDiretor, filme);
		}
	}

	public void executar(String command, int idDiretor, int idFilme){
		if("removerFilme".equals(command)){
			diretoresRepository.removerFilme(idDiretor, idFilme);
		}

	}

	public void executar(String command, int id, String nome) {
		if("renomear".equals(command)) {
			diretoresRepository.renomear(id, nome);
		}
	}

	public void executar(String command, int id) {
		if("excluir".equals(command)) {
			try {
				diretoresRepository.excluir(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void executar(String command) {
		if("listarTodos".equals(command)) {
			diretoresRepository.listarTodos().forEach((System.out::println));
		}
	}

	public void executar(String command, String nomeOuParteDoNome) {
		if("pesquisarPorNome".equals(command)) {
			diretoresRepository.pesquisarPorNome(nomeOuParteDoNome).forEach(System.out::println);
		}
	}

}
