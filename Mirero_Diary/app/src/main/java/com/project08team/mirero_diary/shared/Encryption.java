package com.project08team.mirero_diary.shared;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 */

public class Encryption {

    public static String Encrypt(String str, String encryptionMethod){
        String encoded;
        try{
            MessageDigest md = MessageDigest.getInstance(encryptionMethod);
            md.update(str.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte aByteData : byteData) {
                sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
            encoded = sb.toString();

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            encoded = null;
        }
        return encoded;
    }

    public static String MD5(String str) {
        return Encrypt(str, "MD5");
    }

    public static String SHA256(String str) {
        return Encrypt(str, "SHA-256");
    }
}
