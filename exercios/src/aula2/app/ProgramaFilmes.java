package aula2.app;

import aula2.Filme;
import aula2.FilmeBuilder;

public class ProgramaFilmes {

    public static void main(String[] args) {


        Filme filme = new FilmeBuilder()
                .comTitulo("Azul")
                .comDuracao("1 minuto")
                .comId(1L)
                .build();


    }

}
