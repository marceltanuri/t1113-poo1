package aula5.strategy.model;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.factory.ValidacaoDeSenhaFactory;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private static final int SENHAS_ALTERIORES_OBRIGATORIAS = 3;

    private String senhaAtual;

    private List<String> senhasAnteriores = new ArrayList<>();

    public Usuario (String senha) throws SenhaInvalidaException {
        validarSenha(senha);
        this.senhaAtual = senha;
    }



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
        ValidacaoDeSenhaFactory factory = ValidacaoDeSenhaFactory.getInstance("app.properties");
        List<ValidadorDeSenha> strategies = factory.getImplementations();

        for (ValidadorDeSenha strategy : strategies) {
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
