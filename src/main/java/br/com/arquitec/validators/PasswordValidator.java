package br.com.arquitec.validators;

import br.com.arquitec.exceptions.WeakPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordValidator {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static void passwordValidation(String password) throws WeakPasswordException {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            throw new WeakPasswordException(
                    "Password must have at least 1 number, 1 special character, 1 uppercase letter, " +
                            "1 lowercase letter, and be at least 8 characters long."
            );
        }
    }
}
