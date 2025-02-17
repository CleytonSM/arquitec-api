package br.com.arquitec.services;

import br.com.arquitec.models.dtos.RegisterDTO;
import br.com.arquitec.models.entities.User;
import br.com.arquitec.validators.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    public void register(RegisterDTO register) {
        RegisterValidator.validateFields(register);

        emailService.sendEmailOfNewCustomer(createUser(register));
    }

    private User createUser(RegisterDTO register) {
        return userService.create(register);
    }
}
