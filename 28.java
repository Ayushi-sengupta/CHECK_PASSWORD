/*
(Check password) Some websites impose certain rules for passwords. Write a
method that checks whether a string is a valid password. Suppose the password
rules are as follows:
■ A password must have at least eight characters.
■ A password consists of only letters and digits.
■ A password must contain at least two digits.
Write a program that prompts the user to enter a password and displays Valid
Password if the rules are followed or Invalid Password otherwise.
*/
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            // Prompt the user to enter a password
            System.out.print("Enter a password (at least 8 characters, 2 digits, and 1 special character): ");
            String password = input.nextLine();

            String validationMessage = isValidPassword(password);

            if (validationMessage.equals("Valid")) {
                System.out.println("Valid Password. Exiting program.");
                break;
            } else {
                attempts++;
                System.out.println("Attempt " + attempts + ": " + validationMessage);

                if (attempts < maxAttempts) {
                    System.out.println("Please try again.");
                } else {
                    System.out.println("Maximum attempts reached. Exiting program.");
                }
            }
        }

        input.close(); // Close the scanner to prevent resource leak
    }

    /** Method isValidPassword tests whether a string is a valid password */
    public static String isValidPassword(String password) {
        final int LENGTH_OF_VALID_PASSWORD = 8;    // Valid length of password
        final int MINIMUM_NUMBER_OF_DIGITS = 2;    // Minimum digits it must contain

        StringBuilder message = new StringBuilder("Reasons:");

        if (password.length() < LENGTH_OF_VALID_PASSWORD) {
            message.append("\n- Password must be at least 8 characters long.");
        }

        if (!password.matches(".*\\d.*\\d.*")) {
            message.append("\n- Password must contain at least two digits.");
        }

        if (!password.matches(".*[!@#$%^&*()_+]+.*")) {
            message.append("\n- Password must contain at least one special character.");
        }

        return message.toString().equals("Reasons:") ? "Valid" : message.toString();
    }
}
