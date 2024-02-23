package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.controller.command.FilmeCommand;
import com.mtanuri.t1113.model.diretor.Diretor;
import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public class AdicionaDiretor extends FilmeCommand {
    public AdicionaDiretor(FilmeRepository repository) {
        super(repository);
    }

    @Override
    public void executar(Map<String, Object> params) {

        int idFilme = (int) params.get("idFilme");
        Diretor diretor = (Diretor) params.get("diretor");
        repository.adicionarDiretor(idFilme, diretor);

    }
}
