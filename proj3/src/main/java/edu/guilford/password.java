package edu.guilford;

import java.util.Scanner;

public class password {
    public static void main(String[] args) {
        // create a Scanner object for input
        Scanner scanner = new Scanner(System.in);
        
        // prompt the user for information about the first user and create a User object
        System.out.println("Enter information for first user:");
        User user1 = promptNewUser(scanner);
        
        // generate a password for the first user and encrypt it
        String password1 = generatePassword(user1);
        String encryptedPassword1 = AES.encrypt(password1, "mySecretKey");
        
        // prompt the user for information about the second user and create a User object
        System.out.println("Enter information for second user:");
        User user2 = promptNewUser(scanner);
        
        // generate a password for the second user and encrypt it
        String password2 = generatePassword(user2);
        String encryptedPassword2 = AES.encrypt(password2, "mySecretKey");
        
        // print the passwords and encrypted passwords for both users
        System.out.println("\nPasswords:");
        System.out.println("User 1: " + password1);
        System.out.println("User 2: " + password2);
        System.out.println("\nEncrypted passwords (with secret key 'mySecretKey'):");
        System.out.println("User 1: " + encryptedPassword1);
        System.out.println("User 2: " + encryptedPassword2);
        
        // decrypt the encrypted passwords and print the decrypted passwords
        System.out.println("\nDecrypted passwords (with secret key 'mySecretKey'):");
        String decryptedPassword1 = AES.decrypt(encryptedPassword1, "mySecretKey");
        String decryptedPassword2 = AES.decrypt(encryptedPassword2, "mySecretKey");
        System.out.println("User 1: " + decryptedPassword1);
        System.out.println("User 2: " + decryptedPassword2);
        
        // close the Scanner object
        scanner.close();
    }
    
    // method to prompt the user for information about a new user and create a User object
    public static User promptNewUser(Scanner scanner) {
        String firstName = promptForInput(scanner, "Enter your first name:");
        String lastName = promptForInput(scanner, "Enter your last name:");
        String email = promptForInput(scanner, "Enter your email address:");
        String favColor = promptForInput(scanner, "Enter your favorite color:");
        String favAnimal = promptForInput(scanner, "Enter your favorite animal:");
        return new User(firstName, lastName, email, favColor, favAnimal);
    }
    
    // method to prompt the user for input and handle empty input
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
    
    // method to generate a password for a User object
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











