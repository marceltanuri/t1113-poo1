package aula5;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private static final int SENHAS_ALTERIORES_OBRIGATORIAS = 3;

    private String senhaAtual;

    private List<String> senhasAnteriores = new ArrayList<>();

    public Usuario (String senha){
        this.senhaAtual = senha;
    }



    public void alteraSenha(String senhaAtual, String novaSenha){

        if(!confereSenha(senhaAtual)){
            System.out.println("Confirmação inválida");
            return;
        }

        if(senhaJaUtilizadaEmSenhasAnteriores(novaSenha)){
            System.out.println("Senha não pode ter sido ultizada nas últimas " + SENHAS_ALTERIORES_OBRIGATORIAS + " senhas anteriores");
            return;
        }

        this.senhaAtual = novaSenha;
        this.senhasAnteriores.add(novaSenha);
        System.out.println("Senha alterada com sucesso!");

    }

    private boolean senhaJaUtilizadaEmSenhasAnteriores(String novaSenha){

        for(int i = senhasAnteriores.size()-1, j=0; i >= 0 ; i--,j++){
            if(j==SENHAS_ALTERIORES_OBRIGATORIAS){
                break;
            }
            if(senhasAnteriores.get(i).equals(novaSenha)){
                return true;
            }
        }

        return false;
    }



    private boolean confereSenha(String senhaAtual) {
        boolean senhaConfere = this.senhaAtual.equals(senhaAtual);
        return senhaConfere;

    }

}
