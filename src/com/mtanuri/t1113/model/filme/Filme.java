package com.mtanuri.t1113.model.filme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.diretor.Diretor;

public class Filme {

	private int id = 0;
    private String nome;
    private LocalDate dataLancamento;
    private double orcamento;
    private String descricao;

    private List<Ator> atores = new ArrayList<Ator>();

    private List<Diretor> diretores = new ArrayList<Diretor>();
    
    @Override
    public String toString() {
        return "Movie{" +
                "id: " + id + ";" +
        		"\n" + "title: " + nome + ";" +
                "\n" + "description: " + descricao + ";" +
        		"\n" + "starring: " + atoresToString() + ";" +
                "\n" + "directed by: " + diretoresToString() +
                "}\n";
    }

    public String atoresToString() {
    	StringJoiner atoresString = new StringJoiner(", ");
    	for (Ator ator : atores) {
    		atoresString.add(ator.getNome());
    	}
    	return atoresString.toString();
    }
    
    public String diretoresToString() {
    	StringJoiner diretoresString = new StringJoiner(", ");
    	for (Diretor diretor : diretores) {
    		diretoresString.add(diretor.getNome());
    	}
    	return diretoresString.toString();
    }
    
	public int getId() {
		return id;
	}

	protected void setId() {
		++id;
	}
    
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

}
