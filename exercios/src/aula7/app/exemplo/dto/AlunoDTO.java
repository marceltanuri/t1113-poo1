package aula7.app.exemplo.dto;

import aula7.app.exemplo.model.Aluno;

public record AlunoDTO(Long id, String nome, String email) {

    public AlunoDTO(String nome, String email) {
        this(null, nome, email);
    }

    public Aluno toAluno() {
        return new Aluno(id, nome, email);
    }
}
