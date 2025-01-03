package com.labexam.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
  private static final int SALT_LENGTH = 16;

  public String hashPassword(String password) {
    try {
      byte[] salt = generateSalt();
      String saltString = Base64.getEncoder().encodeToString(salt);
      String saltedPassword = saltString + password;
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] encodedHash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
      return saltString + Base64.getEncoder().encodeToString(encodedHash);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Hashing algorithm not found", e);
    }
  }

  public boolean verifyPassword(String providedPassword, String hashedPassword) {
    if(hashedPassword == null)
      return false;
    try {
      String salt = hashedPassword.substring(0, 24);
        String saltedPassword = salt + providedPassword;
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
      String providedHash =  salt + Base64.getEncoder().encodeToString(encodedHash);
      return providedHash.equals(hashedPassword);
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("Hashing algorithm not found", e);
    }
  }

  private byte[] generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[SALT_LENGTH];
    random.nextBytes(salt);
    return salt;
  }
}