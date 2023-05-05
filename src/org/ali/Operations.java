package org.ali;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Operations {
    public String operationStrings;
    public String inputType;

    public Operations(String operationStrings, String inputType) {
        this.operationStrings = operationStrings;
        this.inputType = inputType;
    }

    /**
     * Reverse an array of strings
     * @param listOfStr the given array of strings
     * @return the reversed of the given array of strings
     */
    public List<String> reverseString(List<String> listOfStr) {
        return listOfStr.stream().map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.toList());
    }

    /**
     * Removes zeros from the beginning of a decimal string of an integer
     * @param DecimalStrOfInteger the given decimal string of an integer
     * @return a string in which the zeros at the beginning are removed
     */
    public static String removeZerosFromBeginning(String DecimalStrOfInteger) {
        int i = 0;
        for(;i<DecimalStrOfInteger.length();i++)
            if(DecimalStrOfInteger.charAt(i) != '0') break;
        return DecimalStrOfInteger.substring(i);
    }

    /**
     * For a given list of decimal strings of some integers, the reverse of them are computed
     * @param listOfDcimalStrOfIntegers the given list of decimal strings of integers
     * @return a list of reversed decimal strings
     */
    public List<String> reverseDecimalStringOfNumber(List<String> listOfDcimalStrOfIntegers) {
        return reverseString(listOfDcimalStrOfIntegers).stream().map(Operations::removeZerosFromBeginning).toList();
    }

    public List<String> apply(List<String> listOfStr) {
        for(String op : operationStrings.split(",")) {
            if(op.toLowerCase().contains("rev")) {
                if(inputType.contains("str")) {
                    return listOfStr.stream().map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.toList());
                }
            }
        }
        return null;
    }
}
