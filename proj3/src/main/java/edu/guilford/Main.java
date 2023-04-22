package edu.guilford;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for information to create first user
        System.out.println("Creating user 1...");
        User user1 = promptNewUser(scanner);
        
        // Generate password for user 1 and encrypt it
        String password1 = generatePassword(user1);
        String encryptedPassword1 = AES.encrypt(password1, "mySecretKey");
        
        
        
        // Print out user information, generated passwords, and encrypted passwords
        System.out.println("User 1:");
        System.out.println(user1.toString());
        System.out.println("Generated password: " + password1);
        System.out.println("Encrypted password: " + encryptedPassword1);
        String decryptedPassword1 = AES.decrypt(encryptedPassword1, "mySecretKey");
        System.out.println("Decrypted password: " + decryptedPassword1);
        System.out.println();
        
        
        
    }
    
    // Method to prompt user for information to create a new User object
    public static User promptNewUser(Scanner scanner) {
        String firstName = promptForInput(scanner, "Enter your first name:");
        String lastName = promptForInput(scanner, "Enter your last name:");
        String email = promptForInput(scanner, "Enter your email address:");
        String favColor = promptForInput(scanner, "Enter your favorite color:");
        String favAnimal = promptForInput(scanner, "Enter your favorite animal:");
        return new User(firstName, lastName, email, favColor, favAnimal);
    }
    
    // Method to prompt user for input with a given prompt, and ensure the input is not empty
    public static String promptForInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            } else {
                return input;
            }
        }
    }
    
    // Method to generate a password for a User object based on its attributes
    public static String generatePassword(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String favColor = user.getFavColor();
        String favAnimal = user.getFavAnimal();
        String password = firstName.substring(0, 3) + favColor.substring(0, 3) + favAnimal.substring(0, 3) + lastName.substring(0, 3) + email.substring(0, 3);
        return password;
    }

}
