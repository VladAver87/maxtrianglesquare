package com.vladaver.maxtrianglesquare.validator;

public class StringDataValidator implements Validator<String> {

    @Override
    public boolean isValid(String[] line) {
        if (line.length < 6) return false;
        return true;
    }

}
