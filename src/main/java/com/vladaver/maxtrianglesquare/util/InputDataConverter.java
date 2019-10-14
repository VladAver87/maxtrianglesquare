package com.vladaver.maxtrianglesquare.util;


public class InputDataConverter {

    public Double[] convert(String[] lineData) {
        Double[] points = new Double[lineData.length];
        for (int i = 0; i < lineData.length; i++) {
            try {
                points[i] = Double.valueOf(lineData[i]);
            }catch (NumberFormatException e){
                continue;
            }
        }
        return points;
    }
}
