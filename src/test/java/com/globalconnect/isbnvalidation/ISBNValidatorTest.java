package com.globalconnect.isbnvalidation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ISBNValidatorTest {


    @Test
    public void testValidDynamicISBNAndExpectValidOutput1() {
        boolean actual = ISBNValidator.validISBN("9185057819");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidDynamicISBNAndExpectValidOutput2() {
        boolean actual = ISBNValidator.validISBN("723199265x");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidDynamicISBNAndExpectValidOutput3() {
        boolean actual = ISBNValidator.validISBN("7-2319-9265-x");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidDynamicISBNAndExpectValidOutput4() {
        boolean actual = ISBNValidator.validISBN("9789180062695");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidDynamicISBNAndExpectValidOutput5() {
        boolean actual = ISBNValidator.validISBN("9-789-1893-0620-2");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testInvalidDynamicISBNAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN("9185057818");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidDynamicISBNWithTooFewDigitsAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN("91850578");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidDynamicISBNWithTooManyDigitsAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN("918505781812345678");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidDynamicISBNWithIllegalCharactersAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN("9185a57x18");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidDynamicISBNEndsWithAHyphenAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN("9185057819-");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testValidISBN10AndExpectValidOutput1() {
        boolean actual = ISBNValidator.validISBN10("9185057819");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidISBN10AndExpectValidOutput2() {
        boolean actual = ISBNValidator.validISBN10("9-1851-6781-9");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidISBN10AndExpectValidOutput3() {
        boolean actual = ISBNValidator.validISBN10("723199265x");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidISBN10AndExpectValidOutput4() {
        boolean actual = ISBNValidator.validISBN10("4-7128-9136-x");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testInvalidISBN10AndExpectInvalidOutput1() {
        boolean actual = ISBNValidator.validISBN10("1234567890");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN10AndExpectInvalidOutput2() {
        boolean actual = ISBNValidator.validISBN10("571289136x");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN10WithDoubleHyphenAndExpectInvalidOutput1() {
        boolean actual = ISBNValidator.validISBN10("91850--57818");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN10WithDoubleHyphenAndExpectInvalidOutput2() {
        boolean actual = ISBNValidator.validISBN10("987--654321x");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN10MissingOneDigitAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN10("918505781");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN10OneIllegalCharacterAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN10("723199265y");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN10IllegalCharactersAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN10("abcdefghij");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testValidISBN13AndExpectValidOutput1() {
        boolean actual = ISBNValidator.validISBN13("9781492072508");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidISBN13AndExpectValidOutput2() {
        boolean actual = ISBNValidator.validISBN13("9789164207746");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidISBN13AndExpectValidOutput3() {
        boolean actual = ISBNValidator.validISBN13("9-789127-175549");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testValidISBN13AndExpectValidOutput4() {
        boolean actual = ISBNValidator.validISBN13("9-7-8-9-1-3-2-2-1-4-8-8-2");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testInvalidISBN13AndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN13("9781492072507");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN13WithDoubleHyphenAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN13("1234567890--123");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN13WithIllegalCharacterExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN13("518497314821x");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN13ExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN13("1122392887938");
        Assertions.assertFalse(actual);
    }


    @Test
    public void testInvalidISBN13WithTooFewDigitsAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN13("9185057819");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN13WithISBN10FormatAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN13("723199265x");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testInvalidISBN13WithTooManyDigitsAndExpectInvalidOutput() {
        boolean actual = ISBNValidator.validISBN13("12345678901234");
        Assertions.assertFalse(actual);
    }


}
