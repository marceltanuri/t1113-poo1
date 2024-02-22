package com.mtanuri.t1113.model.filme;

import java.time.LocalDate;
import java.util.List;

import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.diretor.Diretor;

public class FilmeBuilder {

	private Filme filme = new Filme();

	public FilmeBuilder comNome(String nome){
		filme.setNome(nome);
		return this;
	}

	public FilmeBuilder comDataLancamento(LocalDate dataLancamento){
		filme.setDataLancamento(dataLancamento);
		return this;
	}

	public FilmeBuilder comOrcamento(double orcamento){
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
		filme.setId();
		return filme;
	}

}
