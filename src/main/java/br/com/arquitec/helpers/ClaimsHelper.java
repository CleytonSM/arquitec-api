package br.com.arquitec.helpers;

import br.com.arquitec.models.entities.User;

public class ClaimsHelper {
    public static String collectEmail(User user) {
        return user.getEmail();
    }
}
