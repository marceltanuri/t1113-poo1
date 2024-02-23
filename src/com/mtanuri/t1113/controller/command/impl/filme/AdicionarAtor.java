package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.controller.command.FilmeCommand;
import com.mtanuri.t1113.model.ator.Ator;
import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public class AdicionarAtor extends FilmeCommand {
    public AdicionarAtor(FilmeRepository repository) {
        super(repository);
    }

    @Override
    public void executar(Map<String, Object> params) {
        Integer idFilme = (Integer) params.get("idFilme");
        Ator ator = (Ator) params.get("ator");
        repository.adicionarAtor(idFilme, ator);
    }
}
