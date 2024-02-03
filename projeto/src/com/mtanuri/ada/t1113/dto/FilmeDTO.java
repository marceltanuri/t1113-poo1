package com.mtanuri.ada.t1113.dto;

import com.mtanuri.ada.t1113.model.Filme;

public class FilmeDTO implements CrudDTO<Filme> {

    private Long id;

    private String titulo;

    @Override
    public Filme to() {
        Filme filme = new Filme();
        filme.setId(this.id);
        filme.setDescricao(this.titulo);
        return filme;
    }

    @Override
    public CrudDTO<Filme> from(Filme filme) {
        FilmeDTO dto = new FilmeDTO();
        dto.id = filme.getId();
        dto.titulo = filme.getDescricao();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "FilmeDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
