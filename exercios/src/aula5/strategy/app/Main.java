package aula5.strategy.app;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.user.Usuario;
import aula5.strategy.model.user.validador.exception.InvalidUserException;

public class Main {

    public static void main(String[] args) throws SenhaInvalidaException, InvalidUserException {

        Usuario u = Usuario.builder().comDataNascimento("01/01/1984").comSenha("teste123").build();
        u.alteraSenha("teste123", "teste1234");
        u.alteraSenha("teste1234", "teste12345");
        u.alteraSenha("teste12345", "teste123456");
        u.alteraSenha("teste123456", "teste123");

    }


}
