package br.com.arquitec.securities.jwt;

import br.com.arquitec.exceptions.InvalidJwtTokenException;
import br.com.arquitec.helpers.SecretKeyHelper;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtValidator {
    @Autowired
    private SecretKeyHelper secretKeyHelper;

    public boolean validateToken(String token) {
        SecretKey secretKey = secretKeyHelper.secretKeyBuilder();

        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException | NullPointerException e) {
            throw new InvalidJwtTokenException(e.getMessage());
        }
    }
}
