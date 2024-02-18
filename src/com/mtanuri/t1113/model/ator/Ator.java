package com.mtanuri.t1113.model.ator;

import java.time.LocalDate;
import java.util.List;

import com.mtanuri.t1113.model.filme.Filme;

public class Ator {
	
	private int id;
	private String nome;
	private LocalDate dataNascimento;

	private List<Filme> filmes;
	
    @Override
    public String toString() {
        return "Ator{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

}
