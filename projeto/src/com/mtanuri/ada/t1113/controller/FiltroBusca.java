package com.mtanuri.ada.t1113.controller;

public record FiltroBusca(TipoDePesquisa tipoDePesquisa, String campo, String valor) {

    public enum TipoDePesquisa {

        COMECANDO_COM, CONTENDO, TERMINANDO_COM

    }

}
