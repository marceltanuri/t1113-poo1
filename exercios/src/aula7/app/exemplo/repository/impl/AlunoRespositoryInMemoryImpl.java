package aula7.app.exemplo.repository.impl;

import aula7.app.exemplo.model.Aluno;
import aula7.app.exemplo.repository.AlunoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlunoRespositoryInMemoryImpl implements AlunoRepository {

    private List<Aluno> alunos = new ArrayList<>();

    @Override
    public Aluno inserir(Aluno a) {
        alunos.add(a);
        a.setId(Long.valueOf(alunos.size())); // IDs não são setados dessa forma
        return a;
    }

    @Override
    public Aluno altera(Aluno a) {
        return null;
    }

    @Override
    public Aluno exclui(Aluno a) {
        return null;
    }

    @Override
    public List<Aluno> pesquisaPorNome(String nome) {
        return alunos.stream().filter(a->a.getNome().equals(nome)).collect(Collectors.toList());
    }

    @Override
    public Optional<Aluno> pesquisaPorEmail(String email) {
        return alunos.stream().filter(a->a.getEmail().equals(email)).findFirst();    }

    @Override
    public List<Aluno> listarTodos() {
        return alunos;
    }
}
