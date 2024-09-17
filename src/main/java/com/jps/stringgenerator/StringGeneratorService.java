package com.jps.stringgenerator;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class StringGeneratorService {

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
    private static final int DEFAULT_LENGTH = -1;

    /** 
     * Generates a random string with length of 50 to 100 characters.
     */
    public String generateRandomString() {
        return generateRandomString(DEFAULT_LENGTH);
    }

    /** 
     * Generates a random string of specified length.
     */  
    public String generateRandomString(int length) {
        Random ran = new Random();

        if (length < 0) {
            length = ran.nextInt(50, 100);
        }

        StringBuilder sb = new StringBuilder(length);

        for (int c = 0; c < length; c++) {
            sb.append(CHARS.charAt(ran.nextInt(CHARS.length())));
        }

        return sb.toString();
    }
}
