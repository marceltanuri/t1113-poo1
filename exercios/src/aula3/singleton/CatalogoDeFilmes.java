package aula3.singleton;

import java.util.ArrayList;
import java.util.List;

public class CatalogoDeFilmes {

    private String nome;
    private List<Filme> filmes = new ArrayList<>(10);

    private static CatalogoDeFilmes instancia;

    private CatalogoDeFilmes(){

    }

    public static CatalogoDeFilmes getInstance() {
        if (instancia == null) {
            instancia = new CatalogoDeFilmes();
        }
        return instancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
