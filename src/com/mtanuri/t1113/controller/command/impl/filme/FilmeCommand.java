package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.controller.command.Command;
import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

 abstract class FilmeCommand implements Command {

    protected FilmeRepository repository;

    protected FilmeCommand(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    public abstract void executar(Map<String, Object> params);
}
