package com.mtanuri.ada.t1113.exception;

import java.util.Objects;

public class EntryNotFoundException extends RuntimeException{

    public EntryNotFoundException(Object entry){
        super("Dado não encontrado: " + entry);
    }
}
