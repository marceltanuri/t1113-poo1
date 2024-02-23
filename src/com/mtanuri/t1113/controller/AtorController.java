package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.repository.AtorRepository;
import com.mtanuri.t1113.controller.command.opcoes.OperacoesDiretor;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;

public class AtorController {

	private AtorRepository atoresRepository;

	public AtorController(AtorRepository repository) {
		this.atoresRepository = repository;
	}

	public void executar(OperacoesDiretor operacao, Ator ator) {
		if (operacao == OperacoesDiretor.INSERIR) {
			atoresRepository.inserir(ator);
		}
		
	}

	public void executar(OperacoesDiretor operacao, int idAtor, Filme filme){
		if(operacao == OperacoesDiretor.ADICIONAR_FILME){
			atoresRepository.adicionarFilme(idAtor, filme);
		}
	}

	public void executar(OperacoesDiretor operacao, int idAtor, int idFilme){
		if(operacao == OperacoesDiretor.REMOVER_FILME){
			atoresRepository.removerFilme(idAtor, idFilme);
		}
	}

	public void executar(OperacoesDiretor operacao, int id, String nome) {
		if(operacao == OperacoesDiretor.RENOMEAR) {
			atoresRepository.renomear(id, nome);
		}
	}

	public void executar(OperacoesDiretor operacao, int id) {
		if(operacao == OperacoesDiretor.EXCLUIR) {
			try {
				atoresRepository.excluir(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void executar(OperacoesDiretor operacao) {
		if(operacao == OperacoesDiretor.LISTAR_TODOS) {
			atoresRepository.listarTodos().forEach((System.out::println));
		}
	}

	public void executar(OperacoesDiretor operacao, String nomeOuParteDoNome) {
		if(operacao == OperacoesDiretor.PESQUISAR_POR_NOME) {
			atoresRepository.pesquisarPorNome(nomeOuParteDoNome).forEach(System.out::println);
		}
	}

}
