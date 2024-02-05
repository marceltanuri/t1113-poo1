package aula3.singleton;

public class Main {

    public static void main(String[] args) {

        CatalogoDeFilmes catalogoDeFilmes = CatalogoDeFilmes.getInstance();
        catalogoDeFilmes.setNome("IMDB");

        System.out.println(catalogoDeFilmes.getNome());


        CatalogoDeFilmes catalogoDeFilmes2 = CatalogoDeFilmes.getInstance();
        System.out.println(catalogoDeFilmes2.getNome());

    }
}
