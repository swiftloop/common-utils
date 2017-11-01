package com.akeyo.utils.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* *
 *Created by: Sorata 2017/10/26 0026 下午 7:17
 *
 */
public class XFMessageDigest {

    public static byte[] toEncode(byte[] bytes, String type) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(type);
        messageDigest.update(bytes);
        return messageDigest.digest();
    }
}
