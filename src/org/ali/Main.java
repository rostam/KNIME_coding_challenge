package org.ali;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * Main class.
 * 
 * @author KNIME GmbH
 */
public class Main {

	public static void main(String[] args) throws Exception {
		CommandLineParameters commandLineParameters = new CommandLineParameters(args);

		List<String> inputs = Files.readAllLines(Paths.get(commandLineParameters.inputFile));
		inputs.forEach(s -> Statistics.getInstance().updateStatisticsWithLine(s));
		if(commandLineParameters.outputFile != null) {
			Files.write(Paths.get(commandLineParameters.outputFile), commandLineParameters.operations.apply(inputs));
			Files.write(Paths.get(commandLineParameters.outputFile), Arrays.asList(String.format("Processed %d lines (%d of which were unique)", //
					Statistics.getInstance().getNoOfLinesRead(), //
					Statistics.getInstance().getNoOfUniqueLines())),  StandardOpenOption.APPEND);
		}
		else {
			commandLineParameters.operations.apply(inputs).forEach(System.out::println);
		}

		// DO NOT CHANGE THE FOLLOWING LINES OF CODE
		System.out.println(String.format("Processed %d lines (%d of which were unique)", //
				Statistics.getInstance().getNoOfLinesRead(), //
				Statistics.getInstance().getNoOfUniqueLines()));
	}

}
