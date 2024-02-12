package aula5.composite;

public class NaoLider implements Funcionario{

    private final String nome;

    public NaoLider(String nome) {
        this.nome = nome;
    }

    @Override
    public void adicionarLiderado(Funcionario f) {

    }

    @Override
    public void imprimirOrganograma() {
        System.out.println("Funcionário: " + this.nome);
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean temLiderados() {
        return false;
    }
}
