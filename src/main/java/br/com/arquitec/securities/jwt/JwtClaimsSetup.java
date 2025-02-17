package br.com.arquitec.securities.jwt;

import br.com.arquitec.models.entities.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtClaimsSetup {


    public Map<String, String> claimsSetup(User user) {
        return buildClaims(user);
    }

    public Map<String, String> claimsSetup(String email) {
        return buildClaims(email);
    }


    private Map<String, String> buildClaims(User user) {
        Map<String, String> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("userId", user.getId().toString());

        return claims;
    }

    private Map<String, String> buildClaims(String email) {
        Map<String, String> claims = new HashMap<>();
        claims.put("email", email);

        return claims;
    }
}
