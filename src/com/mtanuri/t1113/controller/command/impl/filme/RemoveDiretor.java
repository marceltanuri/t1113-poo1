package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public class RemoveDiretor extends FilmeCommand {
    public RemoveDiretor(FilmeRepository repository) {
        super(repository);
    }

    @Override
    public void executar(Map<String, Object> params) {
        int idDiretor = (int) params.get("idDiretor");
        int idFilme = (int) params.get("idFilme");
        repository.removerDiretor(idFilme, idDiretor);
    }
}
