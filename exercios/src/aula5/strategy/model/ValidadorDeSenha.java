package aula5.strategy.model;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.Usuario;

public interface ValidadorDeSenha {

    public void validar(Usuario u, String novaSenha) throws SenhaInvalidaException;
}
