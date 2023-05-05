package org.ali;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Main class.
 * 
 * @author KNIME GmbH
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// add your code here
		for(String a : args) {
			System.out.println(a);
		}

		List<String> inputs = Files.readAllLines(Paths.get(args[1]));
		String operations = args[5];
		for(String op : operations.split(",")) {
			if(op.toLowerCase().contains("rev")) {
				Files.write(Paths.get(args[9]),inputs.stream().map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.toList()));
			}
		}
		
		// DO NOT CHANGE THE FOLLOWING LINES OF CODE
		System.out.println(String.format("Processed %d lines (%d of which were unique)", //
				Statistics.getInstance().getNoOfLinesRead(), //
				Statistics.getInstance().getNoOfUniqueLines()));
	}

}
