package com.vladaver.maxtrianglesquare.util;

import com.vladaver.maxtrianglesquare.exception.TriangleSquareException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputDataConverter {

    public Double[] convert(String line) throws TriangleSquareException {
        String[] lineSplit = line.split(" ");
        if (lineSplit.length < 6) throw new TriangleSquareException("Not enough arguments in line: ");
        Double[] points = new Double[lineSplit.length];
        for (int i = 0; i < lineSplit.length; i++) {
            try {
                points[i] = Double.valueOf(lineSplit[i]);
            }catch (NumberFormatException e){
                log.error(e.getMessage());
            }
        }
        for (Double p : points) {
            if (p == null) throw new TriangleSquareException("Error parsing arguments in line: ");
        }
        return points;
    }
}
