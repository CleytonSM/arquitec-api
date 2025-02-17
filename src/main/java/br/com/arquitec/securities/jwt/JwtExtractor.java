package br.com.arquitec.securities.jwt;

import br.com.arquitec.helpers.SecretKeyHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtExtractor {
    @Autowired
    private SecretKeyHelper secretKeyHelper;

    public String extractUserEmail(String token) {
        token = stripBearer(token);
        SecretKey secretKey = secretKeyHelper.secretKeyBuilder();

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
                .getPayload().get("email", String.class);
    }

    public String extractUserEmailFromExpiredToken(String token) {
        String response = "";
        try {
            SecretKey secretKey = secretKeyHelper.secretKeyBuilder();
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
                    .getPayload().get("email", String.class);
        } catch (ExpiredJwtException e) {
            response = e.getClaims().get("email", String.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return response;
    }

    protected String getRole(String token) {
        SecretKey secretKey = secretKeyHelper.secretKeyBuilder();

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
                .getPayload().get("authority", String.class);
    }

    public String extractUserId(String token) {
        token = stripBearer(token);

        SecretKey secretKey = secretKeyHelper.secretKeyBuilder();

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
                .getPayload().get("userId", String.class);
    }

    private String stripBearer(String token) {
        if(token.contains("Bearer ")) {
            return token.substring(7);
        }

        return token;
    }
}
