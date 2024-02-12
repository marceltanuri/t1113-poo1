package aula5.strategy.model.impl;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.Usuario;
import aula5.strategy.model.ValidadorDeSenha;

public class ComprimentoMinimoValidador implements ValidadorDeSenha {
    private static final int COMPRIMENTO_MINIMO = 8;

    @Override
    public void validar(Usuario u, String novaSenha) throws SenhaInvalidaException{
        if(novaSenha.length() < COMPRIMENTO_MINIMO){
            throw  new SenhaInvalidaException(String.format("Senha deve ser maior do que %s caracteres", COMPRIMENTO_MINIMO));
        }
    }
}

