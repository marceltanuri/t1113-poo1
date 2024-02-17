package com.mtanuri.t1113.model;

import java.time.LocalDate;
import java.util.List;

public class Filme {

	private int id;
    private String nome;
    private LocalDate dataLancamento;
    private double orcamento;
    private String descricao;

    private List<Ator> atores;

    private List<Diretor> diretores;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	public List<Diretor> getDiretores() {
		return diretores;
	}

	public void setDiretores(List<Diretor> diretores) {
		this.diretores = diretores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
