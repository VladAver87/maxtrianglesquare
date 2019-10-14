package com.vladaver.maxtrianglesquare.writer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Slf4j
@AllArgsConstructor
public class FileWriter implements Writer {
    private final File file;
    private final String data;

    @Override
    public void write() {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(data);
            writer.close();
            log.debug("Successfully written to file {}", file.getName());
        } catch (FileNotFoundException e) {
            log.debug("Error writing to file", e.getMessage());
        }
    }
}
