package com.vladaver.maxtrianglesquare;


import com.vladaver.maxtrianglesquare.model.Point;
import com.vladaver.maxtrianglesquare.model.Triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

    public static void main( String[] args ) {
        File input = new File(args[0]);
        File output = new File(args[1]);
        double maxSquare = -1;
        String resultLine = null;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineData = line.split(" ");
                double[] points = getDoubleValues(lineData);
                Triangle triangle = new Triangle(new Point(points[0], points[1]), new Point(points[2], points[3]), new Point(points[4], points[5]));
                double tempSquare = triangle.square();
                if (tempSquare > maxSquare){
                    maxSquare = tempSquare;
                    resultLine = line;
                }
            }
            PrintWriter writer = new PrintWriter(output);
            writer.println(resultLine);
            writer.close();
        }catch (FileNotFoundException e){
            System.out.println("input/output data files not found");
        }
    }

    private static double[] getDoubleValues(String[] values){
        double [] result = new double[values.length];
        for (int i = 0; i < values.length; i++){
            result[i] = Double.valueOf(values[i]);
        }
        return result;
    }
}
