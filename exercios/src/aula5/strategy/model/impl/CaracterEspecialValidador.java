package aula5.strategy.model.impl;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.Usuario;
import aula5.strategy.model.ValidadorDeSenha;

public class CaracterEspecialValidador implements ValidadorDeSenha {
    private static final String CARACTERES_ESPECIAIS = "!@#$%^&*()-+";

    @Override
    public void validar(Usuario u, String novaSenha) throws SenhaInvalidaException {
        boolean contemCaractereEspecial = false;
        for (char c : novaSenha.toCharArray()) {
            if (CARACTERES_ESPECIAIS.contains(String.valueOf(c))) {
                contemCaractereEspecial = true;
                break;
            }
        }
        if (!contemCaractereEspecial) {
            throw new SenhaInvalidaException("A senha deve conter pelo menos um caractere especial.");
        }
    }
}
