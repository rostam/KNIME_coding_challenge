package org.ali;

/**
 * Commandline Parameters Handler
 */
public class CommandLineParameters {
    String inputFile;
    String inputType;
    Operations operations;
    int numberOfThreads;
    String outputFile;

    /**
     * Commandline Parameters
     * @param args the input commandline parameters
     */
    public CommandLineParameters(String[] args) {
        inputFile = args[1];
        inputType = args[3];
        numberOfThreads = Integer.parseInt(args[7]);
        outputFile = args[9];
        operations = new Operations(args[5],inputType);
    }
}
