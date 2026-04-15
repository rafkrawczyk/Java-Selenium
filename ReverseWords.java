package oop;

public class ReverseWords {
   
    public String reverseWords(String input) {
        // Handle null or empty strings
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Fix 1: Declare the type
        String[] temp = input.split(" ");
        
        // Fix 2: Initialize the array with a specific size
        String[] outputArray = new String[temp.length];
        
        // Fix 3: Declare 'int i' and fix the OutOfBounds logic
        for (int i = 0; i < temp.length; i++) {
            outputArray[i] = temp[temp.length - 1 - i];
        }
        
        // Fix 4 & 5: Join the array back into a string and return it
        return String.join(" ", outputArray);
    }
}