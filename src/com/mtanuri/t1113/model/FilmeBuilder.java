package com.mtanuri.t1113.model;

import java.time.LocalDate;
import java.util.List;

public class FilmeBuilder {

	private Filme filme = new Filme();

	public FilmeBuilder comNome(String nome){
		filme.setNome(nome);
		return this;
	}

	public FilmeBuilder comId(LocalDate dataLancamento){
		filme.setDataLancamento(dataLancamento);
		return this;
	}

	public FilmeBuilder comDuracao(double orcamento){
		filme.setOrcamento(orcamento);
		return this;
	}

	public FilmeBuilder comDescricao(String descricao){
		filme.setDescricao(descricao);
		return this;
	}

	public FilmeBuilder comAtores(List<Ator> atores){
		filme.setAtores(atores);
		return this;
	}

	public FilmeBuilder comDiretores(List<Diretor> diretores){
		filme.setDiretores(diretores);
		return this;
	}

	public Filme build(){
		return filme;
	}

}
