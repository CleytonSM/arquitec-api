package br.com.arquitec.services;

import br.com.arquitec.models.dtos.LoginRequestDTO;
import br.com.arquitec.securities.user.UserAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    public Authentication getAuthentication(LoginRequestDTO login) {
        return userAuthenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
    }
}
