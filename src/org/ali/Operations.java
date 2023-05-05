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
     * Reverse a decimal string of an integer
     * @param decimalStrOfInteger the given decimal string of an integer
     * @return a reversed decimal string of the integer
     */
    public static String reverseDecimalStrOfInteger(String decimalStrOfInteger) {
        boolean isNegated = false;
        if(decimalStrOfInteger.charAt(0) == '-') {
            decimalStrOfInteger = decimalStrOfInteger.substring(1);
            isNegated = true;
        }

        decimalStrOfInteger =  new StringBuilder(decimalStrOfInteger).reverse().toString();

        int i = 0;
        for(;i<decimalStrOfInteger.length();i++)
            if(decimalStrOfInteger.charAt(i) != '0') break;

        decimalStrOfInteger = decimalStrOfInteger.substring(i);

        if(isNegated) decimalStrOfInteger = "-" + decimalStrOfInteger;

        return decimalStrOfInteger;
    }

    /**
     * For a given list of decimal strings of some integers, the reverse of them are computed
     * @param listOfDcimalStrOfIntegers the given list of decimal strings of integers
     * @return a list of reversed decimal strings
     */
    public List<String> reverseArrayOfDecimalStringOfNumber(List<String> listOfDcimalStrOfIntegers) {
        return reverseString(listOfDcimalStrOfIntegers).stream().map(Operations::reverseDecimalStrOfInteger).toList();
    }

    /**
     *  Capitalize a list of strings
     * @param s the given list of strings
     * @return the capitalized list of strings
     */
    public static List<String> Capitalize(List<String> s) {
        return s.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public List<String> apply(List<String> listOfStr) throws Exception {
        for(String op : operationStrings.split(",")) {
            if (op.toLowerCase().contains("rev")) {
                if(inputType.contains("str")) {
                    return reverseString(listOfStr);
                } else {
                    return reverseArrayOfDecimalStringOfNumber(listOfStr);
                }
            }

            if(op.toLowerCase().contains("cap")) {
                if(inputType.contains("str")) {
                    return Capitalize(listOfStr);
                } else {
                    throw new Exception("Cannot capitalize a list of numbers");
                }
            }
        }
        return null;
    }
}
