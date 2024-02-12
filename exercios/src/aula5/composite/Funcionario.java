package aula5.composite;

public interface Funcionario
{

    public void adicionarLiderado(Funcionario f);

    public void imprimirOrganograma();

    public String getNome();

    public boolean temLiderados();

}
