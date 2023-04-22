package edu.guilford;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String favColor;
    private String favAnimal;
    private String password;

    public User(String firstName, String lastName, String email, String favColor, String favAnimal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favColor = favColor;
        this.favAnimal = favAnimal;
        this.password = generatePassword();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFavColor() {
        return favColor;
    }

    public String getFavAnimal() {
        return favAnimal;
    }

    public String getPassword() {
        return password;
    }

    private String generatePassword() {
        String password = firstName.substring(0, 3) + favColor.substring(0, 3) + favAnimal.substring(0, 3) + lastName.substring(0, 3) + email.substring(0, 3);
        return password;
    }
}

