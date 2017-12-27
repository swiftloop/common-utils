package com.akeyo.utils;


import com.akeyo.utils.encrypt.*;

/* *
 *Created by: Sorata 2017/10/26 0026 下午 6:12
 *
 */
public class XFDigest {

    /**
     * 以base64加密的密钥 加密待加密文本 输出base64加密的密文
     *
     * @param text 待加密的文本
     * @param key  base64加密的密钥
     * @return 密文
     */
    public static String AesEncryptBase64(String text, String key) {
        byte[] key_byte = Base64.decode(key);
        try {
            return Base64.encode(AES.encrypt(text, key_byte));
        } catch (Exception e) {
            // 出现加密异常
        }
        return "";
    }

    /**
     * 以base64加密的密钥  解密base64输出加密的密文
     *
     * @param text base64的密文
     * @param key  密钥
     * @return 原文
     */
    public static String AesDecryptBase64(String text, String key) {
        byte[] key_byte = Base64.decode(key);
        try {
            return new String(AES.decrypt(Base64.decode(text), key_byte));
        } catch (Exception e) {
            //出现加密异常
        }
        return "";
    }

    /**
     * 以base64加密的密钥 加密待加密文本 输出Hex加密的密文
     *
     * @param text 待加密的文本
     * @param key  base64加密的密钥
     * @return 密文
     */
    public static String AesEncryptHex(String text, String key) {
        byte[] key_byte = Base64.decode(key);
        try {
            return Hex.binary2hex(AES.encrypt(text, key_byte));
        } catch (Exception e) {
            // 出现加密异常
        }
        return "";
    }

    /**
     * 以base64加密的密钥  解密Hex输出加密的密文
     *
     * @param text hex的密文
     * @param key  密钥
     * @return 原文
     */
    public static String AesDecryptHex(String text, String key) {
        byte[] key_byte = Base64.decode(key);
        try {
            return new String(AES.decrypt(Hex.hexString2Byte(text), key_byte));
        } catch (Exception e) {
            //出现加密异常
        }
        return "";
    }


    /**
     * hmac sha256 加密
     *
     * @param text 原文
     * @param key  密钥
     * @return 密文
     */
    public static String hmac_sha256(String text, String key) {
        try {
            return Hmac.sha256(text, key);
        } catch (Exception e) {
            //
        }
        return "";
    }

    /**
     * hmac sha1 加密
     *
     * @param text 原文
     * @param key  密钥
     * @return 密文
     */
    public static String hmac_sha1(String text, String key) {
        try {
            return Hmac.sha1(text, key);
        } catch (Exception e) {
            //
        }
        return "";
    }


    /**
     * hmac sha256  转十六进制
     *
     * @param text 加密文本
     * @param key  加密key
     * @return 密文
     */
    public static String hex_macSha256(String text, String key) {
        try {
            return Hmac.hex_sha256(text, key);
        } catch (Exception e) {
            //
        }
        return "";
    }

    /**
     * hmac sha1 转十六进制
     *
     * @param text 待加密文本
     * @param key  加密key
     * @return 密文
     */
    public static String hex_macSha1(String text, String key) {
        try {
            return Hmac.hex_sha1(text, key);
        } catch (Exception e) {
            //
        }
        return "";
    }


    /**
     * md5 加密
     *
     * @param text 原文
     * @return 密文
     */
    public static String md5(String text) {
        try {
            return MD5.md5_hex(text);
        } catch (Exception e) {
            //
        }
        return "";
    }


    /**
     * RSA  加密
     *
     * @param text 原文
     * @param key  公钥
     * @return 密文
     */
    public static String rsaEncryptBase64(String text, String key) {
        try {
            return Base64.encode(RSA.encrypt(text.getBytes("UTF-8"), Base64.decode(key)));
        } catch (Exception e) {
            //
        }
        return "";
    }


    /**
     * rsa 解密
     *
     * @param text 密文
     * @param key  私钥
     * @return 原文
     */
    public static String rsaDecryptBase64(String text, String key) {
        try {
            return new String(RSA.decrypt(Base64.decode(text), Base64.decode(key)));
        } catch (Exception e) {
            //
        }
        return "";
    }


    /**
     * sha1  加密
     *
     * @param text 原文
     * @return hex密文
     */
    public static String sha1(String text) {
        try {
            return SHA.sha1_hex(text);
        } catch (Exception e) {
            //
        }
        return "";
    }


    public static String sha256(String text) {
        try {
            return SHA.sha2_hex(text);
        } catch (Exception e) {
            //
        }
        return "";
    }


}
