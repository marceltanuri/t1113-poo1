package aula5.strategy.tests;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.user.Usuario;
import aula5.strategy.model.user.validador.exception.InvalidUserException;
import aula5.strategy.tests.core.TestClass;
import aula5.strategy.tests.core.exception.TestException;

public class UsuarioTest extends TestClass {

    public void novo_usuario_deve_exigir_senha_como_obrigatorio() throws TestException {
        try {
            Usuario.builder().build();
        } catch (InvalidUserException | SenhaInvalidaException e) {
            //success;
        }

    }

    public void novo_usuario_deve_exigir_senha_com_mais_do_que_oito_caracteres() throws TestException {
        try {
            Usuario.builder().comSenha("1234567").build();
        } catch (InvalidUserException | SenhaInvalidaException e) {
            // throw new TestException(e);
        }

    }

    public void novo_usuario_deve_exigir_senha_com_ao_menos_um_caracter_especial() throws TestException {
        try {
            String senha = "12345678";
            Usuario.builder().comSenha(senha).build();
            throw new TestException("esperado exceção de senha inválida para a senha " + senha);
        } catch (InvalidUserException | SenhaInvalidaException e) {
            // success;
        }

    }





}
