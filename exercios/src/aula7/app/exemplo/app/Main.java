package aula7.app.exemplo.app;

import aula7.app.exemplo.controller.AlunoController;
import aula7.app.exemplo.dto.AlunoDTO;
import aula7.app.exemplo.repository.impl.AlunoRespositoryInMemoryImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AlunoController controller = new AlunoController(new AlunoRespositoryInMemoryImpl());

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira nome e email separado por virgula");
        var stringAndEmail = sc.nextLine();
        String[] split = stringAndEmail.split(",");
        var nome = split[0];
        var email = split[1];

        controller.executar("inserir", new AlunoDTO(nome, email));

        controller.executar("listarTodos");





    }

}
