package edu.guilford;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;
    
    // method to set the secret key used for encryption and decryption
    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            // get the bytes of the key
            key = myKey.getBytes("UTF-8");
            // hash the key using the SHA-1 algorithm
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            // take the first 16 bytes of the hash
            key = Arrays.copyOf(key, 16);
            // create a secret key using the AES algorithm and the 16-byte key
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // method to encrypt a string using a secret key
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            // set the secret key
            setKey(secret);
            // create a Cipher object with the AES algorithm and ECB mode
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // initialize the Cipher object in encryption mode with the secret key
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // encrypt the input string and encode it in Base64 format
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    // method to decrypt a string using a secret key
    public static String decrypt(String strToDecrypt, String secret) {
        try {
            // set the secret key
            setKey(secret);
            // create a Cipher object with the AES algorithm and ECB mode
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            // initialize the Cipher object in decryption mode with the secret key
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // decode the input string from Base64 format and decrypt it
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    
    
    }
    

