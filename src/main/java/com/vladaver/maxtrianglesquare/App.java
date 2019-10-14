package com.vladaver.maxtrianglesquare;

import com.vladaver.maxtrianglesquare.model.Point;
import com.vladaver.maxtrianglesquare.model.Triangle;
import com.vladaver.maxtrianglesquare.util.InputDataConverter;
import com.vladaver.maxtrianglesquare.validator.ArgsValidator;
import com.vladaver.maxtrianglesquare.validator.DoubleDataValidator;
import com.vladaver.maxtrianglesquare.validator.StringDataValidator;
import com.vladaver.maxtrianglesquare.validator.Validator;
import com.vladaver.maxtrianglesquare.writer.FileWriter;
import com.vladaver.maxtrianglesquare.writer.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Validator argsValidator = new ArgsValidator();
        Validator stringValidator = new StringDataValidator();
        Validator doubleValidator = new DoubleDataValidator();
        if (argsValidator.isValid(args)) {
            File input = new File(args[0]);
            File output = new File(args[1]);
            InputDataConverter converter = new InputDataConverter();
            int linesCounter = 0;
            int validLinesCounter = -1;
            int sameSquareCounter = 0;
            double maxSquare = -1;
            String resultLine = null;
            try {
                Scanner scanner = new Scanner(input);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (!line.isEmpty()) {
                        linesCounter++;
                        String[] lineData = line.split(" ");
                        if (stringValidator.isValid(lineData)) {
                            Double[] points = converter.convert(lineData);
                            if (doubleValidator.isValid(points)) {
                                validLinesCounter++;
                                Triangle triangle = new Triangle(new Point(points[0], points[1]), new Point(points[2], points[3]), new Point(points[4], points[5]));
                                if (triangle.isExist() && triangle.isIsosceles()) {
                                    double square = triangle.getSquare();
                                    if (square > maxSquare) {
                                        maxSquare = square;
                                        resultLine = line;
                                    } else if (square == maxSquare) {
                                        sameSquareCounter++;
                                    }
                                }else {
                                    System.out.println("Triangle does not exist or triangle is not isosceles in line: " + linesCounter);
                                }
                            } else {
                                System.out.println("Error parsing arguments in line: " + linesCounter);
                            }
                        } else {
                            System.out.println("Not enough  arguments in line: " + linesCounter);
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
        } else {
            System.out.println("Please, restart the application with 2 arguments");
        }
    }
}
