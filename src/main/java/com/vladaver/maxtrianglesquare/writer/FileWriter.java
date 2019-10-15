package com.vladaver.maxtrianglesquare.writer;

import lombok.AllArgsConstructor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@AllArgsConstructor
public class FileWriter implements Writer {
    private final File file;
    private final String data;

    @Override
    public void write() {
        try (PrintWriter writer = new PrintWriter(file)){
            writer.println(data);
            System.out.println("Successfully written to file: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " +  e.getMessage());
        }
    }
}
