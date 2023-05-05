package org.ali;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

/**
 * File Processing Task
 *  This class is used to process a file in a thread
 *  It is used in the MultiThreading class
 *  @author Ali
 *  @version 1.0
 */
public class FileProcessingTask implements Runnable {

    private final String inputFileName;
    private final long startLine;
    private final long endLine;

    private final Operations operations;

    private final BufferedWriter writer;

    public FileProcessingTask(String inputFileName, long startLine, long endLine, Operations operations,
                              BufferedWriter writer) {
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


