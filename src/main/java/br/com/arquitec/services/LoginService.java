package br.com.arquitec.services;

import br.com.arquitec.models.dtos.LoginRequestDTO;
import br.com.arquitec.models.dtos.LoginResponseDTO;
import br.com.arquitec.models.entities.User;
import br.com.arquitec.models.enums.TokenType;
import br.com.arquitec.securities.jwt.JwtProvider;
import br.com.arquitec.securities.user.UserAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtProvider jwtProvider;

    public LoginResponseDTO login(LoginRequestDTO login) {
        Authentication authentication = authenticationService.getAuthentication(login);

        User user = (User) authentication.getPrincipal();

        return LoginResponseDTO.builder()
                .userId(user.getId())
                .token(jwtProvider.createToken(user, TokenType.LOGIN))
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }
}
