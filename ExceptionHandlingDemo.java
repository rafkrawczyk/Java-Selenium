package oop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user for the first integer (numerator)
            System.out.print("Enter the first integer (numerator): ");
            int numerator = scanner.nextInt();

            // Prompt the user for the second integer (denominator)
            System.out.print("Enter the second integer (denominator): ");
            int denominator = scanner.nextInt();

            // Perform division (This will throw ArithmeticException if denominator is 0)
            int result = numerator / denominator;
            System.out.println("Result of division: " + result);

            // Simulate a NullPointerException
            System.out.println("\n--- Simulating NullPointerException ---");
            String nullString = null;
            // Trying to call a method on a null object triggers the exception
            int length = nullString.length(); 
            System.out.println("String length: " + length); // This line will never be reached

        } catch (ArithmeticException e) {
            // Handles division by zero
            System.out.println("\nError (ArithmeticException): Cannot divide a number by zero!");

        } catch (InputMismatchException e) {
            // Handles non-integer inputs (e.g., letters, symbols, or decimals)
            System.out.println("\nError (InputMismatchException): Invalid input. Please enter whole numbers only.");

        } catch (NullPointerException e) {
            // Handles the simulated null pointer access
            System.out.println("\nError (NullPointerException): Attempted to access a method or property on a null object!");

        } catch (Exception e) {
            // A fallback catch block for any other unforeseen exceptions
            System.out.println("\nAn unexpected error occurred: " + e.getMessage());

        } finally {
            // The finally block always executes, making it perfect for closing resources
            scanner.close();
            System.out.println("\nScanner closed. Program execution completed.");
        }
    }
}