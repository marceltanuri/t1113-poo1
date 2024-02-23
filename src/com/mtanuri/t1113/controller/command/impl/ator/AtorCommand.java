package com.mtanuri.t1113.controller.command.impl.ator;

import com.mtanuri.t1113.controller.command.Command;
import com.mtanuri.t1113.repository.AtorRepository;
import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public abstract class AtorCommand implements Command {

    protected AtorRepository repository;

    protected AtorCommand(AtorRepository repository) {
        this.repository = repository;
    }

    @Override
    public abstract void executar(Map<String, Object> params);
}
