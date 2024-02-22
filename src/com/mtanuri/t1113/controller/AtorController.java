package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.repository.AtorRepository;
import com.mtanuri.t1113.operacao.OperacaoAtorDiretor;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;

public class AtorController {

	private AtorRepository atoresRepository;

	public AtorController(AtorRepository repository) {
		this.atoresRepository = repository;
	}

	public void executar(OperacaoAtorDiretor operacao, Ator ator) {
		if (operacao == OperacaoAtorDiretor.INSERIR) {
			atoresRepository.inserir(ator);
		}
		
	}

	public void executar(OperacaoAtorDiretor operacao, int idAtor, Filme filme){
		if(operacao == OperacaoAtorDiretor.ADICIONAR_FILME){
			atoresRepository.adicionarFilme(idAtor, filme);
		}
	}

	public void executar(OperacaoAtorDiretor operacao, int idAtor, int idFilme){
		if(operacao == OperacaoAtorDiretor.REMOVER_FILME){
			atoresRepository.removerFilme(idAtor, idFilme);
		}
	}

	public void executar(OperacaoAtorDiretor operacao, int id, String nome) {
		if(operacao == OperacaoAtorDiretor.RENOMEAR) {
			atoresRepository.renomear(id, nome);
		}
	}

	public void executar(OperacaoAtorDiretor operacao, int id) {
		if(operacao == OperacaoAtorDiretor.EXCLUIR) {
			try {
				atoresRepository.excluir(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void executar(OperacaoAtorDiretor operacao) {
		if(operacao == OperacaoAtorDiretor.LISTAR_TODOS) {
			atoresRepository.listarTodos().forEach((System.out::println));
		}
	}

	public void executar(OperacaoAtorDiretor operacao, String nomeOuParteDoNome) {
		if(operacao == OperacaoAtorDiretor.PESQUISAR_POR_NOME) {
			atoresRepository.pesquisarPorNome(nomeOuParteDoNome).forEach(System.out::println);
		}
	}

}
