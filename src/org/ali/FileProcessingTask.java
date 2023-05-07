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

    /**
     * inputFileName: the name of the input file
     * startLine: the line number to start processing
     * endLine: the line number to end processing
     * operations: the operations to be applied on the file
     * writer: the writer to write the output to
     */
    private final String inputFileName;
    private final long startLine;
    private final long endLine;
    private final Operations operations;
    private final BufferedWriter writer;

    /**
     * Constructor
     * @param inputFileName the name of the input file
     * @param startLine the line number to start processing
     * @param endLine the line number to end processing
     * @param operations the operations to be applied on the file
     * @param writer the writer to write the output to
     */
    public FileProcessingTask(String inputFileName, long startLine, long endLine, Operations operations,
                              BufferedWriter writer) {
        this.inputFileName = inputFileName;
        this.startLine = startLine;
        this.endLine = endLine;
        this.operations = operations;
        this.writer = writer;
    }

    /**
     * Run method
     * This method is called when the thread is started.
     * It reads the input file line by line and applies the operations on each line.
     * It writes the output to the writer.
     */
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
                        if(line.length() >= 1) {
                            Statistics.getInstance().updateStatisticsWithLine(line);
                            writer.write(line + "\n");
                        }
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


