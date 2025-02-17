package br.com.arquitec.helpers;

import br.com.arquitec.models.entities.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class UserOptionalHelper {

    public static User getOptionalUser(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }

        return userOptional.get();
    }
}
