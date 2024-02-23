package com.mtanuri.t1113.app;


import com.mtanuri.t1113.controller.AtorController;
import com.mtanuri.t1113.controller.DiretorController;
import com.mtanuri.t1113.controller.FilmeController;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.ator.AtorBuilder;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.diretor.DiretorBuilder;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.model.filme.FilmeBuilder;
import com.mtanuri.t1113.controller.command.opcoes.OperacoesDiretor;
import com.mtanuri.t1113.controller.command.opcoes.OperacoesFilme;
import com.mtanuri.t1113.repository.impl.AtorRepositoryInMemoryImpl;
import com.mtanuri.t1113.repository.impl.DiretorRepositoryInMemoryImpl;
import com.mtanuri.t1113.repository.impl.FilmeRepositoryInMemoryImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		/*
		 * Scanner sc = new Scanner (System.in) ; System.out.
		 * println("Insira nome e descri��o do filme, separados por v�rgula: "); var
		 * nameAndDescription = sc.nextLine (); String[] split =
		 * nameAndDescription.split(","); var nome = split[0]; var descricao = split[1];
		 */

		//Builders
		Filme filme = new FilmeBuilder().comNome("Batman").comDescricao("Descricao").build();
		Ator ator = new AtorBuilder().comNome("Joao").build();
		Diretor diretor = new DiretorBuilder().comNome("Maria").build();

		//FilmeController
		FilmeController filmeController = new FilmeController(new FilmeRepositoryInMemoryImpl());
		Map<String, Object> params = new HashMap<>();
		params.put("filme", filme);
		filmeController.executar(OperacoesFilme.INSERIR, params);

		params.put("idFilme", filme.getId());
		params.put("ator", ator);
		filmeController.executar(OperacoesFilme.ADICIONAR_ATOR, params);

		params.put("idFilme", filme.getId());
		params.put("diretor", diretor);
		filmeController.executar(OperacoesFilme.ADICIONAR_DIRETOR, params);

		//AtorController
		AtorController atorController = new AtorController(AtorRepositoryInMemoryImpl.getInstance());
		atorController.executar(OperacoesDiretor.INSERIR, ator);
		
		//DiretorController
		DiretorController diretorController = new DiretorController(new DiretorRepositoryInMemoryImpl());
		diretorController.executar(OperacoesDiretor.INSERIR, diretor);
		
		//Print
		atorController.executar(OperacoesDiretor.LISTAR_TODOS);

		filmeController.executar(OperacoesFilme.LISTAR_TODOS);

		diretorController.executar(OperacoesDiretor.LISTAR_TODOS);
		
		//sc.close();

	}

}
