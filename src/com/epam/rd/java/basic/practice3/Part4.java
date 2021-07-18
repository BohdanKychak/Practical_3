package com.epam.rd.java.basic.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static void main(String[] args) {

        System.out.println(hash("asdf", "MD5"));

        System.out.println(hash("asdf", "SHA-256"));

    }

    public static String hash(String input, String algorithm) {
        byte[] hash;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(input.getBytes());
            hash = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (byte character : hash) {
            builder.append(getHexadecimal(character));
        }

        return builder.toString();
    }

    private static String getHexadecimal(byte character) {
        String binary = Integer.toBinaryString(character);
        if (binary.length() > 8) {
            binary = binary.substring(binary.length() - 8);
        }
        int intValue = Integer.parseInt(binary, 2);
        String answer = Integer.toHexString(intValue).toUpperCase();
        if (answer.length() == 1) {
            answer = "0" + answer;
        }
        return answer;
    }

}
