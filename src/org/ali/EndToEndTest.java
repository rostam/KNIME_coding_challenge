package org.ali;

import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * End to End Test class.
 *
 * @author Ali
 * @version 1.0
 */
class EndToEndTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // --input example1_strings.txt --inputtype string --operations rev --threads 4 --output output.txt
    }

    @org.junit.jupiter.api.Test
    void capitalizeStrings() {
        CommandLineParameters testingInputTypeString =
                new CommandLineParameters(
                        new String[]{"--input", "example1_strings.txt",
                                "--inputtype", "string", "--operations", "cap",
                                "--threads", "1", "--output", "output.txt"});

        List<String> inputs = Arrays.asList("hello", "world");
        List<String> expected = Arrays.asList("HELLO", "WORLD");
        assertEquals(expected, Operations.capitalize(inputs));
    }


    @org.junit.jupiter.api.Test
    void reverseStrings() {
        CommandLineParameters testingInputTypeString =
                new CommandLineParameters(
                        new String[]{"--input", "example1_strings.txt",
                                "--inputtype", "string", "--operations", "rev",
                                "--threads", "1", "--output", "output.txt"});

        List<String> inputs = Arrays.asList("hello", "world");
        List<String> expected = Arrays.asList("olleh", "dlrow");
        assertEquals(expected, testingInputTypeString.operations.reverseString(inputs));
    }

    @org.junit.jupiter.api.Test
    void reverseDecimalStrOfInteger() {
        CommandLineParameters testingInputTypeInteger =
                new CommandLineParameters(
                        new String[]{"--input", "example1_strings.txt",
                                "--inputtype", "int", "--operations", "rev",
                                "--threads", "1", "--output", "output.txt"});

        List<String> inputs = Arrays.asList("120", "10", "5");
        List<String> expected = Arrays.asList("21", "1", "5");
        assertEquals(expected, testingInputTypeInteger.operations.reverseArrayOfDecimalStringOfNumber(inputs));
    }
}