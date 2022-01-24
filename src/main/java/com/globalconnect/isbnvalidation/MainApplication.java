package com.globalconnect.isbnvalidation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainApplication {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean running = true;
    private static final String REGEX_ISBN_10_AND_13 = "(?<isbn10>^(\\d[-]?){9}[\\d|Xx]$)|(?<isbn13>^(\\d[-]?){12}\\d$)";   // Regex pattern to match a valid 10 or 13 digits ISBN format, including hyphens.
    private static final String REGEX_Y_OR_N = "(^[Yy]$)|(^[Nn]$)"; // Regex pattern to match 'Y' or 'N (case insensitive).

    public static void main(String[] args) {
        System.out.println("Welcome to the ISBN validation application!");
        System.out.println("Enter a 10 or 13 digits ISBN format, or 'exit' at anytime to exit the program.");

        String userInput;
        while (running) {
            System.out.print("ISBN: ");
            userInput = exitProgramOrNot(scanner.nextLine().strip());
            if (validIsbnFormat(userInput)) {
                if (ISBNValidator.validISBN(userInput))
                    System.out.printf("Valid ISBN. (%s)\n", userInput);
                else
                    System.out.printf("Invalid ISBN. (%s)\n", userInput);
            } else
                System.out.printf("You entered an invalid ISBN format. (%s)\n", userInput);

            System.out.println("Do you want to validate another ISBN?");
            do {
                System.out.print("(Y/N): ");
                userInput = exitProgramOrNot(scanner.nextLine().strip());
                if (userInput.equalsIgnoreCase("Y"))
                    running = true;
                if (userInput.equalsIgnoreCase("N"))
                    running = false;
            } while (!validYorN(userInput));
        }
        System.out.println("Thank you for using the ISBN Validator application! Bye :)");
    }

    /*
    Regex pattern to match a valid 10 or 13 digits ISBN format, including hyphens.
    The regex matches an ISBN format with maximum of one hyphen between each and every digit. It can also not start or end with a hyphen.
    I designed it so because I'm not sure of what the real constraints are for a valid ISBN format. But it can easily be modified accordingly.
     */
    private static boolean validIsbnFormat(String isbn) {
        return Pattern.compile(REGEX_ISBN_10_AND_13).matcher(isbn).matches();
    }

    private static boolean validYorN(String input) {
        return Pattern.compile(REGEX_Y_OR_N).matcher(input).matches();
    }

    private static String exitProgramOrNot(String userInput) {
        if (userInput != null && userInput.equalsIgnoreCase("exit")) {
            System.out.println("Thank you for using the ISBN Validator application! Bye :)");
            System.exit(0);
        }
        return userInput;
    }

}
