package com.vladaver.maxtrianglesquare;

import com.vladaver.maxtrianglesquare.exception.TriangleSquareException;
import com.vladaver.maxtrianglesquare.model.Triangle;
import com.vladaver.maxtrianglesquare.util.InputDataConverter;
import com.vladaver.maxtrianglesquare.writer.FileWriter;
import com.vladaver.maxtrianglesquare.writer.Writer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws TriangleSquareException {
        if (args.length < 2) throw new TriangleSquareException("Please, restart the application with 2 arguments");
        File input = new File(args[0]);
        File output = new File(args[1]);
        InputDataConverter converter = new InputDataConverter();
        int linesCounter = 0;
        double maxSquare = -1;
        double square = -1;
        String resultLine = "";
        Double[] points;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    linesCounter++;
                    try {
                        points = converter.convert(line);
                        Triangle triangle = new Triangle(points);
                        if (triangle.isIsosceles()) {
                            square = triangle.getSquare();
                        } else {
                            System.out.println("Triangle is not isosceles in line " + linesCounter);
                        }
                        if (square > maxSquare) {
                            maxSquare = square;
                            resultLine = line;
                        }
                    } catch (TriangleSquareException e) {
                        System.out.println(e.getMessage() + linesCounter);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("input/output data files not found");
        }
        Writer writer = new FileWriter(output, resultLine);
        writer.write();
    }
}

