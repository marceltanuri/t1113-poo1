package com.mtanuri.t1113.controller.command.factory;

import com.mtanuri.t1113.controller.command.Command;
import com.mtanuri.t1113.controller.command.impl.filme.*;
import com.mtanuri.t1113.controller.command.opcoes.OperacoesFilme;
import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Optional;

public class FilmesCommandFactory {

    private final FilmeRepository repository;

    private static FilmesCommandFactory instance;


    private FilmesCommandFactory(FilmeRepository repository) {
        this.repository = repository;
    }

    public static FilmesCommandFactory getInstance(FilmeRepository repository){
        if(instance==null){
            instance = new FilmesCommandFactory(repository);
        }
        return instance;
    }

    public Optional<Command> getCommand(OperacoesFilme operacoesFilme){

        Command command = null;

        switch (operacoesFilme){
            case INSERIR -> {
                command = new NovoFilme(repository);
            }
            case EXCLUIR -> {
                command = new ExcluirFilme(repository);
            }
            case RENOMEAR -> {
                command = new Renomear(repository);
            }
            case ATUALIZAR_DESCRICAO -> {
                command = new AtualizarDescricao(repository);
            }
            case LISTAR_TODOS -> {
                command = new ListarTodosFilmes(repository);
            }
            case PESQUISAR_POR_NOME -> {
                command = new PesquisarPorNome(repository);
            }
            case ADICIONAR_ATOR -> {
                command = new AdicionarAtor(repository);
            }
            case REMOVER_ATOR -> {
                command = new RemoveAtor(repository);
            }
            case ADICIONAR_DIRETOR -> {
                command = new AdicionaDiretor(repository);
            }
            case REMOVER_DIRETOR -> {
                command = new RemoveDiretor(repository);
            }
        }
       return Optional.ofNullable(command) ;
    }
}
