package com.vladaver.maxtrianglesquare.validator;

public class DoubleDataValidator implements Validator<Double> {

    @Override
    public boolean isValid(Double[] data) {
        for (int i = 0; i < data.length; i++){
            if(!(data[i] instanceof Double)) return false;
        }
        return true;
    }
}
