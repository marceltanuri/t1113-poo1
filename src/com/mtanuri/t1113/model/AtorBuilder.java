package com.mtanuri.t1113.model;

import java.time.LocalDate;
import java.util.List;

public class AtorBuilder {

	private Ator ator = new Ator();

	public AtorBuilder comNome(String nome){
		ator.setNome(nome);
		return this;
	}

	public AtorBuilder comDataNascimento(LocalDate dataNascimento){
		ator.setDataNascimento(dataNascimento);
		return this;
	}

	public AtorBuilder comFilmes(List<Filme> filmes){
		ator.setFilmes(filmes);
		return this;
	}

	public Ator build(){
		return ator;
	}

}
