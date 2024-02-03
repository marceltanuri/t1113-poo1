package aula2;

public class FilmeBuilder {

    private Filme filme = new Filme();

    public FilmeBuilder comTitulo(String titulo){
        filme.setTitulo(titulo);
        return this;
    }

    public FilmeBuilder comId(Long id){
        filme.setId(id);
        return this;
    }

    public FilmeBuilder comDuracao(String duracao){
        filme.setDuracao(duracao);
        return this;
    }

    public Filme build(){
        return filme;
    }

}
