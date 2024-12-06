package org.NBITPROJECT.bouncer;

import com.cthiebaud.passwordvalidator.PasswordValidator;
import com.cthiebaud.passwordvalidator.ValidationResult;

/**
 * This class implements the {@link PasswordValidator} interface and provides
 * functionality
 * to validate a password based on a set of defined conditions.
 * It also includes a method to return ASCII art for a specific output message.
 */
public class Bouncer implements PasswordValidator {

    /**
     * Generates ASCII art that is displayed when the password meets all conditions.
     * Unfortunately, the PasswordValidatorTester terminates the program before this
     * can be done. However the function would work, if changes to the
     * PasswordValidatorTester by cthiebaud were allowed.
     * 
     * @return A string representing the ASCII art to be printed when the password
     *         is correct.
     */
    // public String getYouAreInMThiebaudArt() {
    // String[] asciiArt = {
    // " Y Y OOO U U AAAAA RRRRR EEEEE O N NNN M M TTTTT H H III EEEEE BBBB AAAAA U
    // U DDDD !! ",
    // " Y Y O O U U A A R R E I N N MM MM T H H I E B B A A U U D D !! ",
    // " Y O O U U AAAAAAA RRRRR EEEE I N N M M M T HHHHH I EEEE BBBBB AAAAAAA U U D
    // D !! ",
    // " Y O O U U A A R R E I N N M M T H H I E B B A A U U D D ",
    // " Y OOO UUUUU A A R R EEEEE I N N M M o T H H III EEEEE BBBB A A UUUUU DDDD
    // !! "
    // };

    // // String aus dem ASCII-Art-Array machen ; making a string from the ASCII-Art
    // Array
    // StringBuilder artBuilder = new StringBuilder();
    // for (String line : asciiArt) {
    // artBuilder.append(line).append("\n");
    // }

    // return artBuilder.toString();
    // }

    /**
     * Validates a given password based on several predefined conditions.
     * 
     * The password must:
     * <ol>
     * <li>Be at least 8 characters long.</li>
     * <li>Be no longer than 12 characters.</li>
     * <li>Contain at least one digit.</li>
     * <li>Contain at least one uppercase letter.</li>
     * <li>Contain at least one special character (such as !, ?, #, etc.).</li>
     * <li>Not contain any spaces or tab characters.</li>
     * </ol>
     *
     * @param potentialPassword The password to be validated.
     * @return A {@link ValidationResult} indicating whether the password is valid
     *         or not, with a corresponding message.
     */
    @Override
    public ValidationResult validate(String potentialPassword) {
        try {
            // Überprüfen, ob das Passwort null ist
            // Check if the password is null
            if (potentialPassword == null) {
                throw new IllegalArgumentException(
                        "Das Passwort darf nicht null sein. / The password must not be null.");
            }

            // If the password is an empty string, treat it as null
            if (potentialPassword.trim().isEmpty()) {
                potentialPassword = null; // Treat empty input as null
                throw new IllegalArgumentException(
                        "Das Passwort darf nicht null sein. Bitte gebe etwas ein. / The password must not be null. Please enter something.");
            }

            // Bedingung 1: Passwortlänge (mindestens 8 Zeichen)
            // Condition 1: Password length (at least 8 characters)
            if (potentialPassword.length() < 8) {
                return new ValidationResult(false,
                        "Das Passwort ist zu kurz. Es muss mindestens 8 Zeichen enthalten. / The password is too short. It must contain at least 8 characters.");
            }

            // Bedingung 2: Passwortlänge (höchstens 12 Zeichen)
            // Condition 2: Password length (at most 12 characters)
            if (potentialPassword.length() > 12) {
                return new ValidationResult(false,
                        "Das Passwort ist zu lang. Es darf höchstens 12 Zeichen enthalten. / The password is too long. It must not exceed 12 characters.");
            }

            // Bedingung 3: Mindestens eine Zahl
            // Condition 3: At least one number
            if (!potentialPassword.matches(".*\\d.*")) {
                return new ValidationResult(false,
                        "Das Passwort muss mindestens eine Zahl enthalten. / The password must contain at least one number.");
            }

            // Bedingung 4: Mindestens ein Großbuchstabe
            // Condition 4: At least one uppercase letter
            if (!potentialPassword.matches(".*[A-Z].*")) {
                return new ValidationResult(false,
                        "Das Passwort muss mindestens einen Großbuchstaben enthalten. / The password must contain at least one uppercase letter.");
            }

            // Bedingung 5: Mindestens ein Sonderzeichen
            // Condition 5: At least one special symbol
            if (!potentialPassword.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                return new ValidationResult(false,
                        "Das Passwort muss mindestens ein Sonderzeichen wie z.B. ? oder ! enthalten. / The password must contain at least one special character such as ? or !");
            }

            // Bedingung 6: Keine Leerzeichen oder Tabulatoren
            // Condition 6: No spaces or tabs
            if (potentialPassword.contains(" ") || potentialPassword.contains("\t")) {
                return new ValidationResult(false,
                        "Das Passwort darf keine Leerzeichen oder Tabulatoren enthalten. / The password must not contain spaces or tabs.");
            }

            // Falls alle Bedingungen erfüllt sind
            // If all conditions are met
            return new ValidationResult(true,
                    "Das Passwort ist korrekt. / The password is correct.\n\n");
            // + getYouAreInMThiebaudArt() nach dem ValidationResult hinter \n\n einfügen
            // für ASCII Art

        } catch (IllegalArgumentException e) {
            // Handle the exception gracefully by returning it in a ValidationResult
            return new ValidationResult(false, e.getMessage());
        }
    }
}
