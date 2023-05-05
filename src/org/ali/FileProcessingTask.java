package org.ali;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class FileProcessingTask implements Runnable {

    private final String inputFileName;
    private final long startLine;
    private final long endLine;

    private final Operations operations;

    private final BufferedWriter writer;

    public FileProcessingTask(String inputFileName, long startLine, long endLine, Operations operations,
                              String outputFileName, BufferedWriter writer) {
        this.inputFileName = inputFileName;
        this.startLine = startLine;
        this.endLine = endLine;
        this.operations = operations;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));

            String line;
            long lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                if (lineNumber >= startLine && lineNumber <= endLine) {
                    System.out.println(Thread.currentThread().getName() + ": " + line);
                    line = operations.applyForMultiThreading(line);
                    synchronized(writer) {
                        if(line.length() >= 1)
                            writer.write(line+"\n");
                    }
                } else if (lineNumber > endLine) {
                    break;
                }
                lineNumber++;
            }

            reader.close();
        } catch (Exception e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }
}


