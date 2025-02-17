package br.com.arquitec.securities.user;

import br.com.arquitec.exceptions.AccountNotActivatedException;
import br.com.arquitec.exceptions.WrongCredentialsException;
import br.com.arquitec.helpers.UserOptionalHelper;
import br.com.arquitec.models.entities.Authority;
import br.com.arquitec.models.entities.User;
import br.com.arquitec.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthenticationProvider {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = UserOptionalHelper.getOptionalUser(userRepository.findByEmail(username));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new WrongCredentialsException("Wrong credentials");
        }
        if (user.getActive().equals(Boolean.FALSE)) {
            throw new AccountNotActivatedException("Your account has not been activated");
        }


        return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities(user.getAuthority()));
    }

    public List<GrantedAuthority> grantedAuthorities(Authority authority) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole().toString()));

        return grantedAuthorities;
    }
}