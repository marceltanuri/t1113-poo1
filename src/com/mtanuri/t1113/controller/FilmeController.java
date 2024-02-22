package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.repository.FilmeRepository;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.operacao.OperacaoFilme;

public class FilmeController {

	private FilmeRepository filmesRepository;

	public FilmeController(FilmeRepository repository) {
		this.filmesRepository = repository;
	}

	public void executar(OperacaoFilme operacao, Filme filme) {
		if (operacao == OperacaoFilme.INSERIR) {
			filmesRepository.inserir(filme);
		}
	}

	public void executar(OperacaoFilme operacao, int idFilme, Ator ator) {
		if(operacao == OperacaoFilme.ADICIONAR_ATOR){
			filmesRepository.adicionarAtor(idFilme, ator);
			return;
		}
	}

	public void executar(OperacaoFilme operacao, int idFilme, Diretor diretor) {
		if(operacao == OperacaoFilme.ADICIONAR_DIRETOR){
			filmesRepository.adicionarDiretor(idFilme, diretor);
			return;
		}
	}

	public void executar(OperacaoFilme operacao, int idFilme, int idAtorOuDiretor){
		if(operacao == OperacaoFilme.REMOVER_ATOR){
			filmesRepository.removerAtor(idFilme, idAtorOuDiretor);
			return;
		}

		if(operacao == OperacaoFilme.REMOVER_DIRETOR){
			filmesRepository.removerDiretor(idFilme, idAtorOuDiretor);
		}

	}

	public void executar(OperacaoFilme operacao, int id, String nomeOuDescricao) {
		if(operacao == OperacaoFilme.RENOMEAR) {
			filmesRepository.renomear(id, nomeOuDescricao);
			return;
		}

		if(operacao == OperacaoFilme.ATUALIZAR_DESCRICAO) {
			filmesRepository.atualizarDescricao(id, nomeOuDescricao);
		}
	}

	public void executar(OperacaoFilme operacao, int id) {
		if(operacao == OperacaoFilme.EXCLUIR) {
			try {
				filmesRepository.excluir(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void executar(OperacaoFilme operacao) {
		if(operacao == OperacaoFilme.LISTAR_TODOS) {
			filmesRepository.listarTodos().forEach((System.out::println));
		}
	}

	public void executar(OperacaoFilme operacao, String nomeOuParteDoNome) {
		if(operacao == OperacaoFilme.PESQUISAR_POR_NOME) {
			filmesRepository.pesquisarPorNome(nomeOuParteDoNome).forEach(System.out::println);
		}
	}

}
