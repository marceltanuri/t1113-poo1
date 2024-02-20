package aula5.strategy.model.user;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.password.validador.factory.SenhaValidatorFactory;
import aula5.strategy.model.password.validador.SenhaValidator;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private static final int SENHAS_ALTERIORES_OBRIGATORIAS = 3;

    protected Usuario() {
    }

    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }

    protected String senhaAtual;

    protected String nome;

    protected String dataNascimento;

    private List<String> senhasAnteriores = new ArrayList<>();

    public void alteraSenha(String senhaAtual, String novaSenha) throws SenhaInvalidaException {

        if(!confereSenha(senhaAtual)){
            System.out.println("Confirmação inválida");
            return;
        }

        validarSenha(novaSenha);

        this.senhaAtual = novaSenha;
        this.senhasAnteriores.add(novaSenha);
        System.out.println("Senha alterada com sucesso!");

    }

    private void validarSenha(String novaSenha) throws SenhaInvalidaException {
        SenhaValidatorFactory factory = SenhaValidatorFactory.getInstance();
        List<SenhaValidator> strategies = factory.getImplementations();

        for (SenhaValidator strategy : strategies) {
            strategy.validar(this, novaSenha);
        }
    }


    private boolean confereSenha(String senhaAtual) {
        boolean senhaConfere = this.senhaAtual.equals(senhaAtual);
        return senhaConfere;

    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public List<String> getSenhasAnteriores() {
        return senhasAnteriores;
    }
}
