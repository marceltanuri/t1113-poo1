package com.mtanuri.t1113.app;

import java.time.LocalDate;

import com.mtanuri.t1113.controller.AtorController;
import com.mtanuri.t1113.controller.DiretorController;
import com.mtanuri.t1113.controller.FilmeController;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.ator.AtorBuilder;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.model.diretor.DiretorBuilder;
import com.mtanuri.t1113.model.filme.Filme;
import com.mtanuri.t1113.model.filme.FilmeBuilder;

public class Main {

	public static void main(String[] args) {
		
		//Builders
		Filme filme = new FilmeBuilder().comNome("Batman").comDataLancamento(LocalDate.of(2009, 12, 18)).comOrcamento(20000000.0).
				comDescricao("Descricao").build();
		Ator ator = new AtorBuilder().comNome("Joao").comDataNascimento(LocalDate.of(2000, 5, 30)).build();
		Diretor diretor = new DiretorBuilder().comNome("Maria").comDataNascimento(LocalDate.of(1995, 2, 20)).build();
		
		//FilmeController teste
		FilmeController filmeController = new FilmeController();
		filmeController.inserir(filme);
		filmeController.pesquisarPorNome("Bat").forEach(System.out::println);
		
		//AtorController teste
		AtorController atorController = new AtorController();
		atorController.inserir(ator);
		atorController.pesquisarPorNome("Joao").forEach(System.out::println);
		
		//DiretorController teste
		DiretorController diretorController = new DiretorController();
		diretorController.inserir(diretor);
		diretorController.pesquisarPorNome("Maria").forEach(System.out::println);

	}

}
