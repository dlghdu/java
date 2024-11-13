package org.example.tobi.springbootsecurityhooyung.config.fillter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tobi.springbootsecurityhooyung.config.jwt.TokenProvider;
import org.example.tobi.springbootsecurityhooyung.model.Member;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenAuthenticationFillter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        log.info("requestURI: {}", requestURI);

        String token = resolveToken(request);

        int validateToken = tokenProvider.validateToken(token);
        log.info("validateToken: {}", validateToken);
        if (validateToken == 1) {
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            Member member = tokenProvider.getTokenDetails(token);
            request.setAttribute("member", member);
        } else if (validateToken == 2) {
            System.out.println(requestURI + " : " + validateToken);
            log.info(requestURI + " : " + validateToken);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else if (validateToken == 3) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

        chain.doFilter(request, response);

    }

    private String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;

    }

}
