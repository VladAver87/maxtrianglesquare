package com.vladaver.maxtrianglesquare.validator;

public interface Validator<T> {
    boolean isValid(T[] data);
}
