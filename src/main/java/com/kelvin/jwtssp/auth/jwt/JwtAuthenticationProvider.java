package com.kelvin.jwtssp.auth.jwt;

import com.kelvin.jwtssp.auth.jwt.helper.TokenHelper;
import com.kelvin.jwtssp.vo.AccessJwtToken;
import com.kelvin.jwtssp.vo.JwtAuthenticationToken;
import com.kelvin.jwtssp.vo.UserContext;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private JwtSettings jwtSettings;

    @Autowired
    private TokenHelper tokenHelper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AccessJwtToken accessJwtToken = (AccessJwtToken) authentication.getCredentials();
        Claims claims = tokenHelper.parseClaims(jwtSettings.getTokenSigningKey(), accessJwtToken.getRawToken()).getBody();
        String username = claims.getSubject();
        List<String> scopes = claims.get("scopes", List.class);
        List<GrantedAuthority> authorities = scopes.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());

        return new JwtAuthenticationToken(new UserContext(username, authorities), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
