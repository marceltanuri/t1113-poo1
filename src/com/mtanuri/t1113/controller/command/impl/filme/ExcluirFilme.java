package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public class ExcluirFilme extends FilmeCommand {
    public ExcluirFilme(FilmeRepository repository) {
        super(repository);
    }

    @Override
    public void executar(Map<String, Object> params) {
        int idFilme = (int) params.get("idFilme");
        repository.excluir(idFilme);
    }
}
