package com.example.assignment.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class DummyAuthFilter extends OncePerRequestFilter {

    private static final String AUTH_HEADER = "X-AUTH-TOKEN";
    private static final String VALID_TOKEN = "my-secret-token";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        if (path.contains("swagger")
                || path.contains("api-docs")
                || path.startsWith("/images")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader(AUTH_HEADER);

        if (token == null || !token.equals(VALID_TOKEN)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized: Invalid or missing token");
            return;
        }

        filterChain.doFilter(request, response);
    }
}