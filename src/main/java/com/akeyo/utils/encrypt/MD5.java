package com.akeyo.utils.encrypt;


import com.akeyo.utils.Base64;
import com.akeyo.utils.Hex;

/* *
 *Created by: Sorata 2017/10/26 0026 下午 7:18
 * md5 加密
 */
public class MD5 {

    public static String md5_hex(String text) throws Exception {
        return Hex.binary2hex(XFMessageDigest.toEncode(text.getBytes("UTF-8"), "MD5"));
    }

    public static String md5_base64(String text) throws Exception {
        return Base64.encode(XFMessageDigest.toEncode(text.getBytes("UTF-8"), "MD5"));
    }

}
