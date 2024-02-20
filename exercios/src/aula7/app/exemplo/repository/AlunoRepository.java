package aula7.app.exemplo.repository;

import aula7.app.exemplo.model.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository {

    public Aluno inserir(Aluno a);

    public Aluno altera(Aluno a);

    public Aluno exclui(Aluno a);

    public List<Aluno> pesquisaPorNome(String a);

    public Optional<Aluno> pesquisaPorEmail(String a);

    public List<Aluno> listarTodos();

}
