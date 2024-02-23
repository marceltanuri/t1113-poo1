package com.mtanuri.t1113.controller.command;

import java.util.Map;

public interface Command {

    public void executar(Map<String, Object> params);

}
