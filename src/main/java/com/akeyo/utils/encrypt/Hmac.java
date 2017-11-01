package com.akeyo.utils.encrypt;


import com.akeyo.utils.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/* *
 *Created by: Sorata 2017/10/26 0026 下午 7:08
 *
 */
public class Hmac {

    private static byte[] mac(String str, String key, HmacType type) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Mac mac = Mac.getInstance(type.toString());
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), mac.getAlgorithm());
        mac.init(keySpec);
        return mac.doFinal(str.getBytes("UTF-8"));
    }

    public static String sha256(String str, String key) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        return Base64.encode(mac(str, key, HmacType.HmacSHA256));
    }

    public static String sha1(String str, String key) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        return Base64.encode(mac(str, key, HmacType.HmacSHA1));
    }

    enum HmacType {
        HmacSHA256, HmacSHA1
    }
}
