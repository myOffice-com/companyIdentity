package com.myoffice.companyidentity.util;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class IdGenerator {

    private static final String PATTERN_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private final char[] patternChars = PATTERN_STRING.toCharArray();

    SecureRandom random = new SecureRandom();


    public String generateId(int length){
        return NanoIdUtils.randomNanoId(random, patternChars, length);
    }

}

