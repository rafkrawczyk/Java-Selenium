package oop;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {
    
    // LinkedHashSet is a subclass of HashSet that maintains insertion order
    private HashSet<String> studentsOrderAdded;
    // TreeSet automatically sorts elements in their natural (alphabetical) order
    private TreeSet<String> studentsAlphabetical;

    // Constructor to initialize the collections
    public Sets() {
        studentsOrderAdded = new LinkedHashSet<>();
        studentsAlphabetical = new TreeSet<>();
    }

    // Adds a student's name to both collections
    public void addStudent(String name) {
        studentsOrderAdded.add(name);
        studentsAlphabetical.add(name);
        System.out.println(name + " has been added.");
    }

    // Removes a student's name from both collections
    public void removeStudent(String name) {
        if (studentsOrderAdded.contains(name)) {
            studentsOrderAdded.remove(name);
            studentsAlphabetical.remove(name);
            System.out.println(name + " has been removed.");
        } else {
            System.out.println("Student " + name + " not found.");
        }
    }

    // Checks if a student's name is in the collections
    public boolean checkStudent(String name) {
        boolean exists = studentsOrderAdded.contains(name);
        if (exists) {
            System.out.println(name + " is in the collection.");
        } else {
            System.out.println(name + " is NOT in the collection.");
        }
        return exists;
    }

    // Displays all students' names in the order they were added
    public void displayStudentsOrderAdded() {
        System.out.println("\n--- Students (Order Added) ---");
        if (studentsOrderAdded.isEmpty()) {
            System.out.println("The collection is empty.");
        } else {
            for (String student : studentsOrderAdded) {
                System.out.println(student);
            }
        }
    }

    // Displays all students' names in alphabetical order
    public void displayStudentsAlphabetically() {
        System.out.println("\n--- Students (Alphabetical Order) ---");
        if (studentsAlphabetical.isEmpty()) {
            System.out.println("The collection is empty.");
        } else {
            for (String student : studentsAlphabetical) {
                System.out.println(student);
            }
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Sets manager = new Sets();

        // 1. Add names to the collection
        manager.addStudent("Zack");
        manager.addStudent("Alice");
        manager.addStudent("Charlie");
        manager.addStudent("Bob");
        
        // Attempting to add a duplicate (will be ignored because Sets only store unique items)
        manager.addStudent("Alice"); 

        // 2. Display names
        manager.displayStudentsOrderAdded();
        manager.displayStudentsAlphabetically();

        // 3. Check if a name is in the collection
        System.out.println("\n--- Checking Students ---");
        manager.checkStudent("Charlie");
        manager.checkStudent("David");

        // 4. Remove a name from the collection
        System.out.println("\n--- Removing Students ---");
        manager.removeStudent("Alice");

        // 5. Display names again to verify removal
        manager.displayStudentsOrderAdded();
        manager.displayStudentsAlphabetically();
    }
}