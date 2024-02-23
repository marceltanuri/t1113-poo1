package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.controller.command.Command;
import com.mtanuri.t1113.controller.command.factory.FilmesCommandFactory;
import com.mtanuri.t1113.repository.FilmeRepository;
import com.mtanuri.t1113.controller.command.opcoes.OperacoesFilme;

import java.util.Map;
import java.util.Optional;

public class FilmeController {

	private FilmeRepository filmesRepository;

	public FilmeController(FilmeRepository repository) {
		this.filmesRepository = repository;
	}

	public void executar(OperacoesFilme operacao) {
		this.executar(operacao, null);
	}
	public void executar(OperacoesFilme operacao, Map<String, Object> params) {
		Optional<Command> command = FilmesCommandFactory.getInstance(filmesRepository).getCommand(operacao);
		if(command.isPresent()){
			command.get().executar(params);
		}
		else{
			System.out.println("Comando não encontrado para a opção " + operacao);
		}

	}






}
