package com.globalconnect.isbnvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBNValidator {

    private static char[] chars;
    private static final String REGEX_ISBN_10_AND_13 = "(?<isbn10>^(\\d[-]?){9}[\\d|Xx]$)|(?<isbn13>^(\\d[-]?){12}\\d$)";   // Regex pattern to match a valid 10 or 13 digits ISBN format, including hyphens.
    private static final String REGEX_ISBN_10 = "(^(\\d[-]?){9}[\\d|Xx]$)"; // Regex pattern to match a valid 10 digits ISBN format, including hyphens.
    private static final String REGEX_ISBN_13 = "(^(\\d[-]?){12}\\d$)"; // Regex pattern to match a valid 13 digits ISBN format, including hyphens.

    /**
     * A method to determine if a 10 or 13 digits ISBN is valid or not.
     *
     * @param isbn is the value to be validated.
     * @return true if the value is valid, else false.
     */
    public static boolean validISBN(String isbn) {
        if (isbn == null)
            return false;
        Matcher matcher = Pattern.compile(REGEX_ISBN_10_AND_13).matcher(isbn);
        if (matcher.matches()) {

            String isbn10 = matcher.group("isbn10");
            if (isbn10 != null) {
                matcher = Pattern.compile(REGEX_ISBN_10).matcher(isbn10);
                if (matcher.matches())
                    return validISBN10(isbn10);
            }

            String isbn13 = matcher.group("isbn13");
            if (isbn13 != null) {
                matcher = Pattern.compile(REGEX_ISBN_13).matcher(isbn13);
                if (matcher.matches())
                    return validISBN13(isbn13);
            }

        }
        return false;
    }

    /**
     * A method to determine if a 10 digits ISBN is valid or not.
     *
     * @param isbn is the value to be validated.
     * @return true if the value is valid, else false.
     */
    public static boolean validISBN10(String isbn) {
        if (isbn == null || !validISBN10Format(isbn))
            return false;
        chars = cleanISBN(isbn).toCharArray();
        int sum = 0;
        int lastIndex = chars.length - 1;
        for (int i = 0, factor = 10; i < lastIndex; i++, factor--) {
            sum += Character.getNumericValue(chars[i]) * factor;
        }
        if (Character.isDigit(chars[lastIndex]))
            sum += Character.getNumericValue(chars[lastIndex]);
        if (Character.isLetter(chars[lastIndex]) && (chars[lastIndex] == 'X' || chars[lastIndex] == 'x'))
            sum += 10;
        return sum % 11 == 0;
    }

    /**
     * A method to determine if a 13 digits ISBN is valid or not.
     *
     * @param isbn is the value to be validated.
     * @return true if the value is valid, else false.
     */
    public static boolean validISBN13(String isbn) {
        if (isbn == null || !validISBN13Format(isbn))
            return false;
        chars = cleanISBN(isbn).toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                sum += Character.getNumericValue(chars[i]);
            } else {
                sum += Character.getNumericValue(chars[i]) * 3;
            }
        }
        return sum % 10 == 0;
    }

    private static String cleanISBN(String isbn) {
        StringBuilder stringBuilder = new StringBuilder();
        isbn.chars().mapToObj(c -> (char) c).toList().stream().filter(c -> c != '-').toList().forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private static boolean validISBN10Format(String isbn) {
        return Pattern.compile(REGEX_ISBN_10).matcher(isbn).matches();
    }

    private static boolean validISBN13Format(String isbn) {
        return Pattern.compile(REGEX_ISBN_13).matcher(isbn).matches();
    }

}
