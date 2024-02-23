package com.mtanuri.t1113.controller.command;

import com.mtanuri.t1113.repository.AtorRepository;
import com.mtanuri.t1113.repository.DiretorRepository;

import java.util.Map;

public abstract class DiretorCommand implements Command {

    protected DiretorRepository repository;

    public DiretorCommand(DiretorRepository repository) {
        this.repository = repository;
    }

    @Override
    public abstract void executar(Map<String, Object> params);
}
