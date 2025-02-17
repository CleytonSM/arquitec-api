package br.com.arquitec.securities.jwt;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public class JwtResolver {

    public static String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (Optional.ofNullable(bearerToken).isEmpty() || !bearerToken.startsWith("Bearer ")) {
            return null;
        }

        return bearerToken.substring(7);
    }
}
