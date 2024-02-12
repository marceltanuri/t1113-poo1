package aula5.composite;

public class Main {

    public static void main(String[] args) {

        Funcionario f1 = new Lider("Moises");

        Funcionario f2 = new Lider("Marcel");
        f1.adicionarLiderado(f2);

        Funcionario f4 = new NaoLider("Gemini");
        f1.adicionarLiderado(f4);

        Funcionario f3 = new NaoLider("ChatGPT");

        f2.adicionarLiderado(f3);

        f1.imprimirOrganograma();

    }
}
