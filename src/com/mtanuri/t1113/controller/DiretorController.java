package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.repository.DiretorRepository;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.controller.command.opcoes.OperacoesDiretor;

public class DiretorController {

	private DiretorRepository diretoresRepository;

	public DiretorController(DiretorRepository repository) {
		this.diretoresRepository = repository;
	}

	public void executar(OperacoesDiretor operacao, Diretor diretor) {
		if (operacao == OperacoesDiretor.INSERIR) {
			diretoresRepository.inserir(diretor);
		}
	}

	public void executar(OperacoesDiretor operacao, int idDiretor, Filme filme){
		if(operacao == OperacoesDiretor.ADICIONAR_FILME){
			diretoresRepository.adicionarFilme(idDiretor, filme);
		}
	}

	public void executar(OperacoesDiretor operacao, int idDiretor, int idFilme){
		if(operacao == OperacoesDiretor.REMOVER_FILME){
			diretoresRepository.removerFilme(idDiretor, idFilme);
		}

	}

	public void executar(OperacoesDiretor operacao, int id, String nome) {
		if(operacao == OperacoesDiretor.RENOMEAR) {
			diretoresRepository.renomear(id, nome);
		}
	}

	public void executar(OperacoesDiretor operacao, int id) {
		if(operacao == OperacoesDiretor.EXCLUIR) {
			try {
				diretoresRepository.excluir(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void executar(OperacoesDiretor operacao) {
		if(operacao == OperacoesDiretor.LISTAR_TODOS) {
			diretoresRepository.listarTodos().forEach((System.out::println));
		}
	}

	public void executar(OperacoesDiretor operacao, String nomeOuParteDoNome) {
		if(operacao == OperacoesDiretor.LISTAR_TODOS) {
			diretoresRepository.pesquisarPorNome(nomeOuParteDoNome).forEach(System.out::println);
		}
	}

}
