package org.ali;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main class.
 * 
 * @author KNIME GmbH
 */
public class Main {

	public static void main(String[] args) throws IOException {
		CommandLineParameters commandLineParameters = new CommandLineParameters(args);

		List<String> inputs = Files.readAllLines(Paths.get(commandLineParameters.inputFile));
		inputs.forEach(s -> Statistics.getInstance().updateStatisticsWithLine(s));
		Files.write(Paths.get(commandLineParameters.outputFile),commandLineParameters.operations.apply(inputs));

		// DO NOT CHANGE THE FOLLOWING LINES OF CODE
		System.out.println(String.format("Processed %d lines (%d of which were unique)", //
				Statistics.getInstance().getNoOfLinesRead(), //
				Statistics.getInstance().getNoOfUniqueLines()));
	}

}
