package br.com.arquitec.securities.jwt;

import br.com.arquitec.helpers.SecretKeyHelper;
import br.com.arquitec.models.entities.User;
import br.com.arquitec.models.enums.TokenType;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;

@Component
@Eager
public class JwtProvider {
    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds;

    @Autowired
    private SecretKeyHelper secretKeyHelper;
    @Autowired
    private JwtClaimsSetup jwtClaimsSetup;

    public String createToken(User user, TokenType tokenType) {
        Date date = new Date();
        SecretKey key = secretKeyHelper.secretKeyBuilder();
        configureTokenValidity(tokenType);

        return Jwts.builder()
                .issuer("X8 Tecnologia")
                .claims(jwtClaimsSetup.claimsSetup(user))
                .subject("JWT Token")
                .issuedAt(date)
                .expiration(setTokenExpiration())
                .signWith(key)
                .compact();
    }

    public String createToken(String email, TokenType tokenType) {
        Date date = new Date();
        SecretKey key = secretKeyHelper.secretKeyBuilder();
        configureTokenValidity(tokenType);

        return Jwts.builder()
                .issuer("X8 Tecnologia")
                .claims(jwtClaimsSetup.claimsSetup(email))
                .subject("Account activation")
                .issuedAt(date)
                .expiration(setTokenExpiration())
                .signWith(key)
                .compact();
    }

    private void configureTokenValidity(TokenType tokenType) {
        if (Optional.ofNullable(tokenType).isPresent() && tokenType == TokenType.FORGOT_PASSWORD) {
            validityInMilliseconds = 3600000;
        }
    }

    private Date setTokenExpiration() {
        Date date = new Date();

        return new Date(date.getTime() + validityInMilliseconds);
    }
}
