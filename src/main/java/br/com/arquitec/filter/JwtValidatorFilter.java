package br.com.arquitec.filter;

import br.com.arquitec.securities.jwt.JwtAuthenticationProvider;
import br.com.arquitec.securities.jwt.JwtResolver;
import br.com.arquitec.securities.jwt.JwtValidator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtValidatorFilter extends OncePerRequestFilter {
    @Autowired
    private JwtValidator jwtValidator;
    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = JwtResolver.resolveToken(request);

            if (Optional.ofNullable(token).isEmpty()) {
                token = request.getParameter("token");
            }

            if (jwtValidator.validateToken(token)) {
                Authentication authentication = jwtAuthenticationProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            response.sendError(401);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().equals("/api/arquinina/register") ||
                request.getRequestURI().equals("/api/arquinina/login");
    }
}