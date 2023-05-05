package org.ali;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Main class for multithreading.
 *
 * @author Ali
 * @version 1.0
 */
public class MultithreadingMain {

    public static void main(String[] args) throws IOException {

        CommandLineParameters commandLineParameters = new CommandLineParameters(args);

        int numThreads = commandLineParameters.numberOfThreads;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(commandLineParameters.inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(commandLineParameters.outputFile));
            long fileSize = reader.lines().count();

            long chunkSize = fileSize / numThreads;
            long remainingSize = fileSize % numThreads;

            Thread[] threads = new Thread[numThreads];

            for (int i = 0; i < numThreads; i++) {
                long startLine = i * chunkSize; // starting line for this thread
                long endLine = startLine + chunkSize - 1; // ending line for this thread

                if (i == numThreads - 1) {
                    endLine += remainingSize; // add the remaining lines to the last thread
                }

                Runnable threadTask = new FileProcessingTask(commandLineParameters.inputFile, startLine, endLine,
                        commandLineParameters.operations, commandLineParameters.outputFile, writer);
                threads[i] = new Thread(threadTask);
                threads[i].start(); // start the thread
            }

            for (Thread thread : threads) {
                thread.join(); // wait for all threads to finish
            }

            writer.flush();
            writer.close();
            Files.write(Paths.get(commandLineParameters.outputFile), Arrays.asList(String.format("Processed %d lines (%d of which were unique)", //
                    Statistics.getInstance().getNoOfLinesRead(), //
                    Statistics.getInstance().getNoOfUniqueLines())),  StandardOpenOption.APPEND);

            System.out.println("All threads finished processing the file.");

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }
}

