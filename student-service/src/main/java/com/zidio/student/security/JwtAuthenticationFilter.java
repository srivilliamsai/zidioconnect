package com.zidio.student.security;

import javax.servlet.*;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // stub for future JWT handling
        chain.doFilter(request, response);
    }
}