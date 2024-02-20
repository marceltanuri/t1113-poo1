package aula5.strategy.model.user.validador;

import aula5.strategy.model.user.Usuario;
import aula5.strategy.model.user.validador.exception.InvalidUserException;

public interface UserValidator {

public void validar(Usuario u) throws InvalidUserException;

}
