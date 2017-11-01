package com.akeyo.utils.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* *
 *Created by: Sorata 2017/10/26 0026 下午 5:19
 *  提供 AES 加密
 */
public class AES {

    private static final String AES_MODEL = "AES";

    private static final String AES_PADDING = "AES/ECB/PKCS5Padding";

    private static final String CHARSET = "UTF-8";


    /**
     * AES 加密
     *
     * @param text 待加密文本
     * @param key  加密密钥
     * @return byte[]  密文
     */
    public static byte[] encrypt(String text, byte[] key) throws Exception {
        if (null == key || key.length == 0) throw new Exception("密钥不能为空");
        SecretKeySpec aesKey = new SecretKeySpec(key, AES_MODEL);//得到密钥
        Cipher cipher = Cipher.getInstance(AES_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return cipher.doFinal(text.getBytes(CHARSET));
    }


    /**
     * AES 解密
     *
     * @param text 已加密文本
     * @param key  解密密钥
     * @return 解密 byte[]
     * @throws Exception 加密异常
     */
    public static byte[] decrypt(byte[] text, byte[] key) throws Exception {
        if (null == key || key.length == 0) throw new Exception("密钥不能为空");
        SecretKeySpec aesKey = new SecretKeySpec(key, AES_MODEL);//得到密钥
        Cipher cipher = Cipher.getInstance(AES_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return cipher.doFinal(text);
    }


}
