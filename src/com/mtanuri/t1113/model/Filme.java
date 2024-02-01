package com.mtanuri.t1113.model;

import java.time.LocalDate;
import java.util.List;

public class Filme {

    private String nome;
    private LocalDate dataLancamento;
    private double orcamento;
    private String descricao;

    private List<Ator> atores;

    private List<Diretor> diretores;

}
