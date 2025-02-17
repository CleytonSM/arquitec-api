package br.com.arquitec.validators;

import br.com.arquitec.exceptions.InvalidEmailException;
import jakarta.persistence.EntityExistsException;

class EmailValidator {

    public static void emailValidation(String email) {
        int i = email.indexOf("@");
        String domain = email.substring(i);
        if(!domain.contains(".com")) {
            throw new InvalidEmailException("Email wrong format");
        }
    }

    public static void emailAlreadyInUseValidation(Boolean isInUse) {
        if(isInUse) {
            throw new EntityExistsException("Email already in use");
        }
    }
}
