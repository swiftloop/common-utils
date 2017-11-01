package com.akeyo.utils.encrypt;


import com.akeyo.utils.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* *
 *Created by: Sorata 2017/10/26 0026 下午 7:25
 * RSA 加密
 */
public class RSA {
    private static final String sign_type = "SHA1WithRSA"; //此处为了和支付宝签名方法一致


    /**
     * rsa 加密
     *
     * @param text 原文
     * @param key  公钥
     * @return byte[]
     */
    public static byte[] encrypt(byte[] text, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory kfactory = KeyFactory.getInstance("RSA");
        PublicKey pkey = kfactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher1 = Cipher.getInstance("RSA");
        cipher1.init(Cipher.ENCRYPT_MODE, pkey);
        return cipher1.doFinal(text);
    }

    /**
     * rsa加密    私钥解密
     *
     * @param text 密文
     * @param key  私钥
     * @return byte[]
     */
    public static byte[] decrypt(byte[] text, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey k8private = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, k8private);
        return cipher.doFinal(text);
    }


    /**
     * 数字签名
     *
     * @param content    待签名的字符串
     * @param privateKey 参与签名的私钥
     * @return 得到签名的字符串
     */
    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance(sign_type);
            signature.initSign(priKey);
            signature.update(content.getBytes("utf-8"));
            return Base64.encode(signature.sign());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 签名验证
     *
     * @param content   参与签名的参数
     * @param sign      已经签名好的参数
     * @param publicKey 公钥
     * @return bool
     */
    public static boolean verify(String content, String sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey1 = keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decode(publicKey)));
            Signature signature = Signature.getInstance(sign_type);
            signature.initVerify(publicKey1);
            signature.update(content.getBytes("utf-8"));
            return signature.verify(Base64.decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
