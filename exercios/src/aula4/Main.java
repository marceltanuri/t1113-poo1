package aula4;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String nomeDoFilme = "Rambo 2";

        Filme filme = new Filme();
        filme.nome = nomeDoFilme;
        FilmesRepository.insere(filme);


        nomeDoFilme = "Mulher Maravilha 1984";

        Filme filme2 = new Filme();
        filme2.nome = nomeDoFilme;
        FilmesRepository.insere(filme2);

        nomeDoFilme = "Batman returns";

        Filme filme3 = new Filme();
        filme3.nome = nomeDoFilme;
        FilmesRepository.insere(filme3);

        nomeDoFilme = "Incredible Spiderman";

        Filme filme4 = new Filme();
        filme4.nome = nomeDoFilme;
        FilmesRepository.insere(filme4);

        List<Filme> filmes = FilmesRepository.pesquisarPorNome("man");

        filmes.forEach(System.out::println);




    }

}
