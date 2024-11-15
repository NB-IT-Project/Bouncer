package org.NBITPROJECT.bouncer;

import com.cthiebaud.passwordvalidator.*;

public class Bouncer implements PasswordValidator {
    @Override
    public ValidationResult validate(String potentialPassword) {
        if (potentialPassword.length() < 8) {
            return new ValidationResult(false, "Das Passwort hat nicht die korrekte Länge");
        } /*
           * else if(HIER NEUE BEDINGUNG) {
           * 
           * }
           */ else {
            return new ValidationResult(true, "Das Passwort ist korrekt");
        }
    }
}
