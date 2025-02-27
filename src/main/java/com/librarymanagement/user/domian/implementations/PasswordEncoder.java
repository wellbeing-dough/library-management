package com.librarymanagement.user.domian.implementations;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Component
public class PasswordEncoder {

    public String encode(String email, String password) {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), getSalt(email), 85319, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean matches(String password, String decodedPassword) {
        return password.equals(decodedPassword);
    }

    private byte[] getSalt(String email) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] keyBytes = email.getBytes(StandardCharsets.UTF_8);
        return digest.digest(keyBytes);
    }
}