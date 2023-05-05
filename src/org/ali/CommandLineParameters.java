package org.ali;

/**
 * Commandline Parameters Handler
 */
public class CommandLineParameters {
    String inputFile;
    String inputType;
    Operations operations;
    int numberOfThreads;
    String outputFile = null;

    /**
     * Commandline Parameters
     * @param args the input commandline parameters
     */
    public CommandLineParameters(String[] args) {
        inputFile = args[1];
        inputType = args[3];
        numberOfThreads = Integer.parseInt(args[7]);
        if(numberOfThreads < 1) throw new IllegalArgumentException("Number of threads must be at least 1");
        if(args.length > 9)
            outputFile = args[9];
        operations = new Operations(args[5],inputType);
    }
}
