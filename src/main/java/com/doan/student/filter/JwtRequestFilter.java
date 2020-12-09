package com.doan.student.filter;

import com.doan.student.service.JwtUserDetailsService;
import com.doan.student.untils.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        try{
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                jwtToken = requestTokenHeader.substring(7);

                try {
                    username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                } catch (IllegalArgumentException e) {
                    System.out.println("unable to get jwt token");
                }
//                catch (ExpiredJwtException e) {
//                    System.out.println("jwt token has expired");
//                }
                catch (ExpiredJwtException ex){
                    String isRefreshToken = httpServletRequest.getHeader("isRefreshToken");
                    String requestURL = httpServletRequest.getRequestURL().toString();
                    // allow for Refresh Token creation if following conditions are true.
                    if (isRefreshToken != null && isRefreshToken.equals("true") && requestURL.contains("refreshtoken")) {
                        allowForRefreshToken(ex, httpServletRequest);
                    } else
                        httpServletRequest.setAttribute("exception", ex);

                }
                catch (BadCredentialsException ex) {
                    httpServletRequest.setAttribute("exception", ex);
                }
            } else {
                logger.warn("jwt token does not begin with Bearer String");
            }
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                }
            }
        }catch (Exception e){
            logger.error("cannot set user authentication {}",e);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
    private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {

        // create a UsernamePasswordAuthenticationToken with null values.
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                null, null, null);
        // After setting the Authentication in the context, we specify
        // that the current user is authenticated. So it passes the
        // Spring Security Configurations successfully.
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        // Set the claims so that in controller we will be using it to create
        // new JWT
        request.setAttribute("claims", ex.getClaims());

    }
}
