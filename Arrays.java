package oop;

public class Arrays {

    public static void main(String[] args) {

        // Original Array
        int arrayOne[] = {36, 187, 512, 4, 18, 3012, 712, 55, 0, 1000};

        // Print original array
        System.out.print("Original Array: ");
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print(arrayOne[i] + " ");
        }
        System.out.println();

        // Reverse the array
        int arrayReverse[] = new int[10];
        for (int i = 0; i < arrayOne.length; i++) {
            arrayReverse[9 - i] = arrayOne[i];
        }
        System.out.print("Reversed Array: ");
        for (int i = 0; i < arrayReverse.length; i++) {
            System.out.print(arrayReverse[i] + " ");
        }
        System.out.println();

        // Find minimum
        int min = arrayOne[0];
        for (int j = 0; j < arrayOne.length; j++) {
            if (min >= arrayOne[j]) {
                min = arrayOne[j];
            }
        }
        System.out.println("Min: " + min);

        // Find maximum
        int max = arrayOne[0];
        for (int j = 0; j < arrayOne.length; j++) {
            if (max <= arrayOne[j]) {
                max = arrayOne[j];
            }
        }
        System.out.println("Max: " + max);

        // Calculate sum
        int sumArray = 0;
        for (int j = 0; j < arrayOne.length; j++) {
            sumArray = sumArray + arrayOne[j];
        }
        System.out.println("Sum: " + sumArray);

        // Calculate average
        int average = sumArray / arrayOne.length;
        System.out.println("Average: " + average);

        // Search for target
        int target = 123;
        boolean found = false;
        for (int i = 0; i < arrayOne.length; i++) {
            if (target == arrayOne[i]) {
                System.out.println("Element " + target + " found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element " + target + " is not found in the array.");
        }

        // Bubble Sort
        int n = arrayOne.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayOne[j] > arrayOne[j + 1]) {
                    int temp = arrayOne[j];
                    arrayOne[j] = arrayOne[j + 1];
                    arrayOne[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print(arrayOne[i] + " ");
        }
        System.out.println();
    }
}