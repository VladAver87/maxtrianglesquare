package com.vladaver.maxtrianglesquare;

import com.vladaver.maxtrianglesquare.exception.TriangleSquareException;
import com.vladaver.maxtrianglesquare.model.Point;
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
        int validLinesCounter = -1;
        int sameSquareCounter = 0;
        double maxSquare = -1;
        String resultLine = null;
        Double[] points;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    linesCounter++;
                    try {
                        points = converter.convert(line);
                        validLinesCounter++;
                        Triangle triangle = new Triangle(new Point(points[0], points[1]), new Point(points[2], points[3]), new Point(points[4], points[5]));
                        double square = triangle.getSquare();
                        if (square > maxSquare) {
                            maxSquare = square;
                            resultLine = line;
                        } else if (square == maxSquare) {
                            sameSquareCounter++;
                        }
                    } catch (TriangleSquareException e) {
                        System.out.println(e.getMessage() + linesCounter);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("input/output data files not found");
        }
        if (validLinesCounter == sameSquareCounter) {
            resultLine = "";
        }
        Writer writer = new FileWriter(output, resultLine);
        writer.write();
    }
}

