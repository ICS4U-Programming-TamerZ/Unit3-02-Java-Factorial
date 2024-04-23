package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class reads integers from a file, calculates their factorials, and writes the results to an output file.
 *
 * @author Tamer Zreg
 * @version 1.0
 * @since 2024-04-23
 */
public class Factorial {
    public static void main(String[] args) {
        // File paths
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        try {
            // Read integers from file
            int[] numbers = readIntegersFromFile(inputFileName);
            // Calculate and write factorials to output file
            writeFactorialsToFile(outputFileName, numbers);
            System.out.println("Output written to " + outputFileName);
        } catch (IOException e) {
            // Handle file reading errors
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Function to read integers from a file.
     *
     * @param fileName The name of the file to read from.
     * @return An array of integers read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static int[] readIntegersFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read integers from file and store them in a dynamic list
            String line;
            java.util.List<Integer> numbersList = new java.util.ArrayList<>();
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    numbersList.add(number);
                } catch (NumberFormatException e) {
                    // Skip non-integer values
                    System.err.println("Skipping non-integer value: " + line);
                }
            }
            // Convert list to array
            int[] numbersArray = new int[numbersList.size()];
            for (int i = 0; i < numbersArray.length; i++) {
                numbersArray[i] = numbersList.get(i);
            }
            return numbersArray;
        }
    }

    /**
     * Function to write factorials to a file.
     *
     * @param fileName The name of the file to write to.
     * @param numbers  An array of integers whose factorials need to be calculated and written to the file.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void writeFactorialsToFile(String fileName, int[] numbers) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Calculate and write the factorial of each number
            for (int number : numbers) {
                long factorial = factorial(number);
                writer.write("Factorial of " + number + " is: " + factorial + "\n");
            }
        }
    }

    /**
     * Recursive function to calculate factorial.
     *
     * @param n The number whose factorial needs to be calculated.
     * @return The factorial of the given number.
     */
    public static long factorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: factorial of n is n multiplied by factorial of (n - 1)
        return n * factorial(n - 1);
    }
}
