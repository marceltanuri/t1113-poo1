package aula2;

public class Filme {


    protected Filme(){

    }

    private Long id;
    private String titulo;
    private String duracao;

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }


    public String getDuracao(){
        return duracao;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    protected void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    protected void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
