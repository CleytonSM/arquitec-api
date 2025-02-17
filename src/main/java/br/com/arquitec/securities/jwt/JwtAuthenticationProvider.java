package br.com.arquitec.securities.jwt;

import br.com.arquitec.exceptions.AccountNotActivatedException;
import br.com.arquitec.models.entities.User;
import br.com.arquitec.securities.user.UserAuthenticationProvider;
import br.com.arquitec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider {
    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;
    @Autowired
    private JwtExtractor jwtExtractor;

    public Authentication getAuthentication(String token) {
        User user = userService.getByEmail(jwtExtractor.extractUserEmail(token));

        if (user.getActive().equals(Boolean.FALSE)) {
            throw new AccountNotActivatedException("Your account has not been activated");
        }

        return new UsernamePasswordAuthenticationToken(user, "", userAuthenticationProvider
                .grantedAuthorities(user.getAuthority()));
    }
}
