package com.mtanuri.ada.t1113.dto;

public interface CrudDTO<T> {

    public T to();

    public CrudDTO<T> from(T from);

}
