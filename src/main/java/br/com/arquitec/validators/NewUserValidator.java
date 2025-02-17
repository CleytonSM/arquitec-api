package br.com.arquitec.validators;

public class NewUserValidator {
    public static void validateIfAlreadyExists(Boolean alreadyExists) {
        EmailValidator.emailAlreadyInUseValidation(alreadyExists);
    }
}
