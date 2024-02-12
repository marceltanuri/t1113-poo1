package aula5.composite;

import java.util.ArrayList;
import java.util.List;

public class Lider implements Funcionario{

    private final String nome;
    private final List<Funcionario> liderados = new ArrayList<>(10);

    public Lider(String nome) {
        this.nome = nome;
    }

    @Override
    public void adicionarLiderado(Funcionario funcionario) {
        this.liderados.add(funcionario);
    }

    @Override
    public void imprimirOrganograma() {
        System.out.println("Lider " + this.nome);
        this.liderados.forEach(Funcionario::imprimirOrganograma);
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean temLiderados() {
        return true;
    }
}
