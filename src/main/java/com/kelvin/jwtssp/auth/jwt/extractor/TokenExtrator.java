package com.kelvin.jwtssp.auth.jwt.extractor;

public interface TokenExtrator {
    String extract(String header);
}
