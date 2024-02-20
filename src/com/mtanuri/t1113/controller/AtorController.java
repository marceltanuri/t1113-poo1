package com.mtanuri.t1113.controller;

import java.util.List;

import com.mtanuri.t1113.repository.AtoresRepository;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.model.filme.Filme;

public class AtorController {
	
	private AtoresRepository atoresRepository;
	
	public AtorController(AtoresRepository repository) {
		this.atoresRepository = repository;
	}
	
    public void executar(String command, Ator ator){
        if("inserir".equals(command)){
            atoresRepository.inserir(ator);
      }
  }

	/*
	 * public void executar(String command, AlunoDTO dto){
	 * 
	 * if("inserir".equals(command)){ Aluno aluno =
	 * alunoRepository.inserir(dto.toAluno());
	 * System.out.println("Aluno inserido com sucesso: " + aluno); }
	 * 
	 * if("alterar".equals(command)){ // implementar depois }
	 * 
	 * if("excluir".equals(command)){ // implementar depois }
	 * 
	 * }
	 */
	
	public Ator inserir(Ator ator) {
		return atoresRepository.inserir(ator);
	}
	
	public Ator atualizar(int id, String nome, List<Filme> filmes) {
        return atoresRepository.atualizar(id, nome, filmes);
	}
	
	public boolean excluir(int id) {
		try {
			atoresRepository.excluir(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Ator> pesquisarPorNome(String nomeOuParteDoNome) {
		return atoresRepository.pesquisarPorNome(nomeOuParteDoNome);
	}

}
