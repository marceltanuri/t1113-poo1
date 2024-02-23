package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.controller.command.Command;
import com.mtanuri.t1113.controller.command.FilmesCommandFactory;
import com.mtanuri.t1113.repository.FilmeRepository;
import com.mtanuri.t1113.controller.command.opcoes.OperacoesFilme;

import java.util.Map;

public class FilmeController {

	private FilmeRepository filmesRepository;

	public FilmeController(FilmeRepository repository) {
		this.filmesRepository = repository;
	}

	public void executar(OperacoesFilme operacao) {
		Command command = FilmesCommandFactory.getInstance(filmesRepository).getCommand(operacao);
		command.executar(null);
	}
	public void executar(OperacoesFilme operacao, Map<String, Object> params) {
		Command command = FilmesCommandFactory.getInstance(filmesRepository).getCommand(operacao);
		command.executar(params);
	}






}
