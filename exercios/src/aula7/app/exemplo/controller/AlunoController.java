package aula7.app.exemplo.controller;

import aula7.app.exemplo.dto.AlunoDTO;
import aula7.app.exemplo.model.Aluno;
import aula7.app.exemplo.repository.AlunoRepository;

public class AlunoController {

    private AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void executar(String command){
          if("listarTodos".equals(command)){
              alunoRepository.listarTodos().forEach(System.out::println);
        }
    }

    public void executar(String command, AlunoDTO dto){

        if("inserir".equals(command)){
            Aluno aluno = alunoRepository.inserir(dto.toAluno());
            System.out.println("Aluno inserido com sucesso: " + aluno);
        }

        if("alterar".equals(command)){
            // implementar depois
        }

        if("excluir".equals(command)){
            // implementar depois
        }

    }

}
