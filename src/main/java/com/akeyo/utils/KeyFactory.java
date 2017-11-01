package com.akeyo.utils;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

/* *
 *Created by: Sorata 2017/10/26 0026 下午 7:48
 *
 */
public class KeyFactory {

    public static char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '@', '#', '%'};


    public static String createRandomKey(int size) {


        char[] arr = new char[size];

        for (int i = 0; i < size; i++) {
            arr[i] = chars[(int) (Math.random() * chars.length)];
        }
        return new String(arr);
    }


    /**
     * rsa密钥生成  密钥位数 512 1024 2048
     *
     * @param keySize
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static List<byte[]> createRSAKey(int keySize) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        System.out.println(Base64.encode(publicKey.getEncoded()));
        System.out.println(Base64.encode(privateKey.getEncoded()));

        List<byte[]> list = new ArrayList<byte[]>();
        list.add(publicKey.getEncoded());
        list.add(privateKey.getEncoded());
        return list;
    }


    /**
     * aes密钥生成  密钥长度128 192 256(jdk实现需要无政策限制文件)
     *
     * @param Keysize
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String createAESKey(int Keysize) throws NoSuchAlgorithmException {
        //生成key
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(Keysize);
        SecretKey key = generator.generateKey();
        byte[] bytes = key.getEncoded();
        return Base64.encode(bytes);
    }


}
