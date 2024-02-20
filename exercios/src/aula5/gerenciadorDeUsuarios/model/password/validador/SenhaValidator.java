package aula5.strategy.model.password.validador;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.user.Usuario;

public interface SenhaValidator {

    public void validar(Usuario u, String novaSenha) throws SenhaInvalidaException;
}
