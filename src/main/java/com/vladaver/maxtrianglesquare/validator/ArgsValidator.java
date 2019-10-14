package com.vladaver.maxtrianglesquare.validator;

public class ArgsValidator implements Validator<String> {

    @Override
    public boolean isValid(String[] data) {
        if(data.length < 2) return false;
        return true;
    }
}
