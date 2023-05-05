package org.ali;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // --input example1_strings.txt --inputtype string --operations rev --threads 4 --output output.txt
        CommandLineParameters testingInputTypeString =
                new CommandLineParameters(new String[]{"-i", "string", "-o", "string"});
    }

    @org.junit.jupiter.api.Test
    void reverseStrings() {
    }

    @org.junit.jupiter.api.Test
    void reverseDecimalStrOfInteger() {
    }

    @org.junit.jupiter.api.Test
    void reverseArrayOfDecimalStringOfNumber() {
    }

    @org.junit.jupiter.api.Test
    void apply() {
    }
}