package br.com.arquitec.validators;

import br.com.arquitec.models.dtos.RegisterDTO;

public class RegisterValidator {
    public static void validateFields(RegisterDTO register) {
        EmailValidator.emailValidation(register.getEmail());
        PasswordValidator.passwordValidation(register.getPassword());
    }
}
