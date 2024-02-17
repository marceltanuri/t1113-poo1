package com.mtanuri.t1113.model;

import java.time.LocalDate;
import java.util.List;

public class DiretorBuilder {

	private Diretor diretor = new Diretor();

	public DiretorBuilder comNome(String nome){
		diretor.setNome(nome);
		return this;
	}

	public DiretorBuilder comDataNascimento(LocalDate dataNascimento){
		diretor.setDataNascimento(dataNascimento);
		return this;
	}

	public DiretorBuilder comFilmes(List<Filme> filmes){
		diretor.setFilmes(filmes);
		return this;
	}

	public Diretor build(){
		return diretor;
	}

}
