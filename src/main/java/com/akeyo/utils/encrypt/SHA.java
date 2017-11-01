package com.akeyo.utils.encrypt;

import com.akeyo.utils.Base64;
import com.akeyo.utils.Hex;

/* *
 *Created by: Sorata 2017/10/27 0027 上午 9:37
 *
 */
public class SHA {

    public static String sha1_hex(String text) throws Exception {
        return Hex.binary2hex(XFMessageDigest.toEncode(text.getBytes("UTF-8"), "sha-1"));
    }

    public static String sha1_base64(String text) throws Exception {
        return Base64.encode(XFMessageDigest.toEncode(text.getBytes("UTF-8"), "sha-1"));
    }

    public static String sha2_hex(String text) throws Exception {
        return Hex.binary2hex(XFMessageDigest.toEncode(text.getBytes("UTF-8"), "sha-256"));
    }

    public static String sha2_base64(String text) throws Exception {
        return Base64.encode(XFMessageDigest.toEncode(text.getBytes("UTF-8"), "sha-256"));
    }


}
