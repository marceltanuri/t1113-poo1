package com.mtanuri.t1113.model.diretor;

import java.time.LocalDate;
import java.util.List;

import com.mtanuri.t1113.model.filme.Filme;

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
		diretor.setId();
		return diretor;
	}

}
