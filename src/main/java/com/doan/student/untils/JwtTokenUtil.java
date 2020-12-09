package com.doan.student.untils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626006488L;
    private int jwtTokenExpiration;
    private String secret;
    private int refreshExpirationDateInMs;

    @Value("${jwt.token.refreshExpirationDateInMs}")
    public void setRefreshExpirationDateInMs(int refreshExpirationDateInMs) {
        this.refreshExpirationDateInMs = refreshExpirationDateInMs;
    }

    @Value("${jwt.token.expiration}")
    public void setJwtTokenExpiration(int jwtTokenExpiration) {
        this.jwtTokenExpiration = jwtTokenExpiration;
    }
    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
        if(roles.contains( new SimpleGrantedAuthority("ROLE_ADMIN"))){
            claims.put("isAdmin", true);
        }
        if(roles.contains( new SimpleGrantedAuthority("ROLE_USER"))){
            claims.put("isUser", true);

        }
        if(roles.contains(new SimpleGrantedAuthority("ROLE_CLIENT"))){
            claims.put("isClient", true);
        }
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtTokenExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpirationDateInMs))
                .signWith(SignatureAlgorithm.HS512, secret).compact();

    }
    public List<String> getRolesFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        List<String> roles = new ArrayList<>();

        Boolean isAdmin = claims.get("isAdmin", Boolean.class);
        Boolean isUser = claims.get("isUser", Boolean.class);
        Boolean isClient = claims.get("isClient", Boolean.class);

        if (isAdmin != null && isAdmin) {
            roles.add("ROLE_ADMIN");
        }

        if (isUser != null && isAdmin) {
            roles.add("ROLE_USER");
        }
        if (isClient != null && isClient) {
            roles.add("ROLE_CLIENT");
        }
        return roles;

    }
}
