package aula4;

import java.util.ArrayList;
import java.util.List;

public class FilmesRepository {

    private static List<Filme> filmes = new ArrayList<>();

    private FilmesRepository(){

    }

    public static Filme insere(Filme filme){
        return null;
    }


    public static Filme alteraNome(int id, String nome){
        Filme filme = filmes.stream().filter(f -> f.id == id).findFirst().get();
        filme.nome=nome;
        return filme;
    }

    public static void deleta(Filme filme){

    }

    public static List<Filme> obterTodos(){
        return null;
    }

    public static List<Filme> pesquisarPorNome(String nome){
        return null;
    }

}
