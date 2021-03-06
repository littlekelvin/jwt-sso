package com.kelvin.jwtssp.auth.jwt.helper;

import com.kelvin.jwtssp.vo.JwtToken;
import com.kelvin.jwtssp.vo.UserContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface TokenHelper {
    JwtToken createAccessToken(UserContext userContext);

    Jws<Claims> parseClaims(String signingKey, String accessToken);
}
