package com.example.hakura_restaurant.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    @Value("${api.key}")
    private String apiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String requestApiKey = request.getHeader("X-API-Key");
        
        if (requestApiKey == null || !requestApiKey.equals(apiKey)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"code\":\"UNAUTHORIZED\",\"message\":\"Invalid or missing API key\"}");
            return;
        }
        
        filterChain.doFilter(request, response);
    }
    
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        String method = request.getMethod();
        
        // Không áp dụng authentication cho các endpoint GET
        if ("GET".equals(method)) {
            return true;
        }
        
        // Chỉ áp dụng authentication cho các endpoint cụ thể
        return !isProtectedEndpoint(path, method);
    }
    
    private boolean isProtectedEndpoint(String path, String method) {
        // Product endpoints: POST (create), PUT (update), DELETE
        if (path.startsWith("/products")) {
            return "POST".equals(method) || "PUT".equals(method) || "DELETE".equals(method);
        }
        
        // Reservation endpoints: PUT (update), DELETE
        if (path.startsWith("/reservations")) {
            return "PUT".equals(method) || "DELETE".equals(method);
        }
        
        return false;
    }
}
