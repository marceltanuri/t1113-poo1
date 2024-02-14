package aula5.strategy.model.password.validador.impl;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.user.Usuario;
import aula5.strategy.model.password.validador.SenhaValidator;

import java.util.Objects;

public class ComprimentoMinimoValidator implements SenhaValidator {
    private static final int COMPRIMENTO_MINIMO = 8;

    @Override
    public void validar(Usuario u, String novaSenha) throws SenhaInvalidaException{
        if(Objects.isNull(novaSenha) || novaSenha.length() < COMPRIMENTO_MINIMO){
            throw  new SenhaInvalidaException(String.format("Senha deve ser maior do que %s caracteres", COMPRIMENTO_MINIMO));
        }
    }
}

