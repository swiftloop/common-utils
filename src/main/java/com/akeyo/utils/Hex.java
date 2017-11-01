package com.akeyo.utils;

/* *
 *Created by: Sorata 2017/10/26 0026 下午 7:01
 *  十六进制转化
 */
public class Hex {

    private static char[] chars = "0123456789abcdef".toCharArray();


    /*byte数组 转为十六进制字符串
     * @param bytes
     * @return
     */
    public static String binary2hex(byte[] bytes) {
        if (null == bytes) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder(bytes.length << 1);
            for (byte aByte : bytes) {
                sb.append(chars[(aByte & 240) >> 4]).append(chars[(aByte & 15)]);
            }
            return sb.toString();
        }
    }

    /**
     * 十六进制转 byte数组
     *
     * @param hex 十六进制的字符串
     * @return byte数组
     */
    public static byte[] hexString2Byte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static int toByte(char c) {
        return (byte) "0123456789abcdef".indexOf(c);
    }
}
