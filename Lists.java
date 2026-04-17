package oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        
        // 1. Create a list of integers
        List<Integer> numbers = new ArrayList<>();

        // 2. Add the specified integers to the list
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // 3. Print the list
        System.out.println("Initial list: " + numbers);

        // 4. Remove the integer at index 2 (This removes '30')
        // Note: remove(int index) removes by position.
        numbers.remove(2);

        // 5. Print the list again
        System.out.println("List after removing element at index 2: " + numbers);

        // 6. Add the integer 25 at index 2
        numbers.add(2, 25);

        // 7. Print the list
        System.out.println("List after adding 25 at index 2: " + numbers);

        // 8. Find and print the maximum value in the list
        // Using Collections.max() is the most efficient and readable approach
        int maxValue = Collections.max(numbers);
        System.out.println("Maximum value: " + maxValue);

        // 9. Find and print the sum of all values in the list
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of all values: " + sum);
    }
}