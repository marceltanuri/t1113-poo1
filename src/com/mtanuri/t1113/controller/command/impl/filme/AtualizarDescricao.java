package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public class AtualizarDescricao extends FilmeCommand {
    public AtualizarDescricao(FilmeRepository repository) {
        super(repository);
    }

    @Override
    public void executar(Map<String, Object> params) {
        int idFilme = (int) params.get("idFilme");
        String descricao = (String) params.get("descricao");
        repository.atualizarDescricao(idFilme, descricao);

    }
}
