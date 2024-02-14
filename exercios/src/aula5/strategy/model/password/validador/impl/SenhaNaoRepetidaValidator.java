package aula5.strategy.model.password.validador.impl;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.user.Usuario;
import aula5.strategy.model.password.validador.SenhaValidator;

import java.util.List;

public class SenhaNaoRepetidaValidator implements SenhaValidator {

    private static final int TOTAL_DE_SENHAS_ALTERIORES_PARA_VALIDAR = 3;

    @Override
    public void validar(Usuario u, String novaSenha) throws SenhaInvalidaException {
        List<String> senhasAnteriores = u.getSenhasAnteriores();
        for(int i = senhasAnteriores.size()-1, j = 0; i >= 0 ; i--,j++){
                if(j== TOTAL_DE_SENHAS_ALTERIORES_PARA_VALIDAR){
                    break;
                }
                if(senhasAnteriores.get(i).equals(novaSenha)){
                    throw new SenhaInvalidaException(String.format("Senha já utilizada. A senha não pode ser igual a nenhuma das %s senhas anteriores", TOTAL_DE_SENHAS_ALTERIORES_PARA_VALIDAR));
                }
            }




    }
}
