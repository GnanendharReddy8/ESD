package com.example.ERP.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {

    // Create a single instance of BCryptPasswordEncoder
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Encrypt the plain password using BCrypt.
     *
     * @param password The plain text password.
     * @return The encrypted password.
     */
    public static String encryptPassword(String password) {
        return encoder.encode(password);
    }

    /**
     * Check if the raw password matches the encrypted password.
     *
     * @param rawPassword      The plain text password provided by the user.
     * @param encryptedPassword The stored encrypted password.
     * @return True if the passwords match, false otherwise.
     */
    public static boolean matchPassword(String rawPassword, String encryptedPassword) {
        return encoder.matches(rawPassword, encryptedPassword);
    }
}
