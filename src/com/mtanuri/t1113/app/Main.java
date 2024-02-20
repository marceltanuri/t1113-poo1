package com.mtanuri.t1113.app;

import java.time.LocalDate;
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
import com.mtanuri.t1113.repository.impl.AtoresRepositoryInMemoryImpl;
import com.mtanuri.t1113.repository.impl.DiretoresRepositoryInMemoryImpl;
import com.mtanuri.t1113.repository.impl.FilmesRepositoryInMemoryImpl;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in) ;
		System.out.println("Insira nome e email separado por virgula");
		var stringAndEmail = sc.nextLine ();
		String[] split = stringAndEmail.split("");
		var nome = split[0];
		var email = split[1];
		
		//Builders
		Filme filme = new FilmeBuilder().comNome("Batman").comDataLancamento(LocalDate.of(2009, 12, 18)).comOrcamento(20000000.0).
				comDescricao("Descricao").build();
		Ator ator = new AtorBuilder().comNome("Joao").comDataNascimento(LocalDate.of(2000, 5, 30)).build();
		Diretor diretor = new DiretorBuilder().comNome("Maria").comDataNascimento(LocalDate.of(1995, 2, 20)).build();
		
		//FilmeController teste
		FilmeController filmeController = new FilmeController(new FilmesRepositoryInMemoryImpl());
		filmeController.inserir(filme);
		filmeController.pesquisarPorNome("Bat").forEach(System.out::println);
		
		//AtorController teste
		AtorController atorController = new AtorController(new AtoresRepositoryInMemoryImpl());
		atorController.inserir(ator);
		atorController.pesquisarPorNome("Joao").forEach(System.out::println);
		
		//DiretorController teste
		DiretorController diretorController = new DiretorController(new DiretoresRepositoryInMemoryImpl());
		diretorController.inserir(diretor);
		diretorController.pesquisarPorNome("Maria").forEach(System.out::println);

	}

}
