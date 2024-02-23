package com.mtanuri.t1113.controller.command;

import com.mtanuri.t1113.controller.command.Command;
import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public abstract class FilmeCommand implements Command {

    protected FilmeRepository repository;

    public FilmeCommand(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    public abstract void executar(Map<String, Object> params);
}
