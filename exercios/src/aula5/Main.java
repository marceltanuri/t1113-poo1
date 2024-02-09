package aula5;

public class Main {

    public static void main(String[] args) {

        Usuario u = new Usuario("teste123");
        u.alteraSenha("teste123", "teste1234");
        u.alteraSenha("teste1234", "teste12345");
        u.alteraSenha("teste12345", "teste123456");
        u.alteraSenha("teste123456", "teste123");

    }

}
