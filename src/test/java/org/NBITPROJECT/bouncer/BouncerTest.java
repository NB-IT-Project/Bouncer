package org.NBITPROJECT.bouncer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.NBITPROJECT.bouncer.Bouncer;

import com.cthiebaud.passwordvalidator.ValidationResult;

/**
 * Unit tests for the Bouncer class.
 * This class validates the functionality of password validation implemented in
 * Bouncer.
 */
public class BouncerTest {

    private final Bouncer bouncer = new Bouncer();

    /**
     * Tests a valid password that meets all the criteria.
     */
    @Test
    public void testValidPassword() {
        String password = "A1b@5678";
        ValidationResult result = bouncer.validate(password);
        assertTrue(result.isValid());
        assertTrue(result.message().contains("Das Passwort ist korrekt")); // Check for success message
    }

    /**
     * Tests a password that is too short (less than 8 characters).
     */
    @Test
    public void testTooShortPassword() {
        String password = "A1@b";
        ValidationResult result = bouncer.validate(password);
        assertFalse(result.isValid());
        assertTrue(result.message().contains("Das Passwort ist zu kurz"));
    }

    /**
     * Tests a password that is too long (greater than 12 characters).
     */
    @Test
    public void testTooLongPassword() {
        String password = "A1b@567890123";
        ValidationResult result = bouncer.validate(password);
        assertFalse(result.isValid());
        assertTrue(result.message().contains("Das Passwort ist zu lang"));
    }

    /**
     * Tests a password that does not contain a digit.
     */
    @Test
    public void testMissingDigit() {
        String password = "Abc@defg";
        ValidationResult result = bouncer.validate(password);
        assertFalse(result.isValid());
        assertTrue(result.message().contains("Das Passwort muss mindestens eine Zahl enthalten"));
    }

    /**
     * Tests a password that does not contain an uppercase letter.
     */
    @Test
    public void testMissingUppercase() {
        String password = "1a@b5678";
        ValidationResult result = bouncer.validate(password);
        assertFalse(result.isValid());
        assertTrue(result.message().contains("Das Passwort muss mindestens einen Großbuchstaben enthalten"));
    }

    /**
     * Tests a password that does not contain a special character.
     */
    @Test
    public void testMissingSpecialCharacter() {
        String password = "A1b56789";
        ValidationResult result = bouncer.validate(password);
        assertFalse(result.isValid());
        assertTrue(result.message()
                .contains("Das Passwort muss mindestens ein Sonderzeichen wie z.B. ? oder ! enthalten"));
    }

    /**
     * Tests a password that contains a space, which is not allowed.
     */
    @Test
    public void testContainsSpace() {
        String password = "A1b @5678";
        ValidationResult result = bouncer.validate(password);
        assertFalse(result.isValid());
        assertTrue(result.message().contains("Das Passwort darf keine Leerzeichen oder Tabulatoren enthalten"));
    }

    /**
     * Tests a password that contains a tab character, which is not allowed.
     */
    @Test
    public void testContainsTab() {
        String password = "A1b\\t5678?";
        ValidationResult result = bouncer.validate(password);
        assertFalse(result.isValid());
        assertTrue(result.message().contains("Das Passwort darf keine Leerzeichen oder Tabulatoren enthalten"));
    }

    /**
     * Tests a password with the minimum valid length (8 characters).
     */
    @Test
    public void testEdgeCaseMinLength() {
        String password = "A1b@5678";
        ValidationResult result = bouncer.validate(password);
        assertTrue(result.isValid());
    }

    /**
     * Tests a password with the maximum valid length (12 characters).
     */
    @Test
    public void testEdgeCaseMaxLength() {
        String password = "A1b@56789012";
        ValidationResult result = bouncer.validate(password);
        assertTrue(result.isValid());
    }
}