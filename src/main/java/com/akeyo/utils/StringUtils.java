package com.akeyo.utils;

/**
 *Created by: Sorata 2017/10/26 0026 下午 5:42
 *
 */
public class StringUtils {

    /**
     * 是否为数字
     *
     * @param num 字符串
     * @return bool
     */
    public static boolean isNumber(String num) {
        if (!hasText(num)) return false;
        for (int i = 0; i < num.length(); ++i) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否为空
     *
     * @param str 字符串
     * @return bool
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }


    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 是否有长度
     *
     * @param str 字符串
     * @return bool
     */
    public static boolean hasLength(String str) {
        return null != str && str.length() > 0;
    }

    /**
     * 是否有内容
     *
     * @param str 需判断的字符串
     * @return bool
     */
    public static boolean hasText(String str) {
        if (!hasLength(str)) return false;
        for (int i = 0; i < str.length(); ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
