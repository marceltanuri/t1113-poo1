package com.mtanuri.t1113.app;


import java.util.Scanner;
import com.mtanuri.t1113.controller.AtorController;
import com.mtanuri.t1113.controller.DiretorController;
import com.mtanuri.t1113.controller.FilmeController;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.ator.AtorBuilder;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.diretor.DiretorBuilder;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.model.filme.FilmeBuilder;
import com.mtanuri.t1113.repository.impl.AtorRepositoryInMemoryImpl;
import com.mtanuri.t1113.repository.impl.DiretorRepositoryInMemoryImpl;
import com.mtanuri.t1113.repository.impl.FilmeRepositoryInMemoryImpl;

public class Main {

	public static void main(String[] args) {

		/*
		 * Scanner sc = new Scanner (System.in) ; System.out.
		 * println("Insira nome e descrição do filme, separados por vírgula: "); var
		 * nameAndDescription = sc.nextLine (); String[] split =
		 * nameAndDescription.split(","); var nome = split[0]; var descricao = split[1];
		 */

		//Builders
		Filme filme = new FilmeBuilder().comNome("Batman").comDescricao("Descricao").build();
		Filme filme2 = new FilmeBuilder().comNome("Spiderman").comDescricao("Descricao").build();
		Ator ator = new AtorBuilder().comNome("Joao").build();
		Diretor diretor = new DiretorBuilder().comNome("Maria").build();

		//FilmeController
		FilmeController filmeController = new FilmeController(new FilmeRepositoryInMemoryImpl());
		filmeController.executar("inserir", filme);
		filmeController.executar("inserir", filme2);

		filmeController.executar("adicionarAtor", filme.getId(), ator);
		filmeController.executar("adicionarDiretor", filme.getId(), diretor);
		
		filmeController.executar("adicionarAtor", filme2.getId(), ator);
		filmeController.executar("adicionarDiretor", filme2.getId(), diretor);
		
		//AtorController
		AtorController atorController = new AtorController(new AtorRepositoryInMemoryImpl());
		atorController.executar("inserir", ator);
		
		//DiretorController
		DiretorController diretorController = new DiretorController(new DiretorRepositoryInMemoryImpl());
		diretorController.executar("inserir", diretor);
		
		//Se um ator for excluído não dá mais erro, só não aparece mais o nome dele
		//atorController.executar("excluir", 1);
		//Print
		atorController.executar("listarTodos");
		filmeController.executar("listarTodos");
		diretorController.executar("listarTodos");
		
		//sc.close();

	}

}
