package com.mtanuri.t1113.dto;

public interface CrudDTO<T> {

    public T to();

    public CrudDTO<T> from(T from);

}
