package com.mtanuri.t1113.dto;
import java.time.LocalDate;
import java.util.List;

import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.ator.AtorBuilder;
import com.mtanuri.t1113.model.filme.Filme;

@SuppressWarnings("preview")
public record AtorDTO(int id, String nome, LocalDate dataNascimento, List<Filme> filmes) {
	
	public Ator toAtor(){
		return new AtorBuilder().comNome(nome).comDataNascimento(dataNascimento).comFilmes(filmes).build();
		
		
}
}