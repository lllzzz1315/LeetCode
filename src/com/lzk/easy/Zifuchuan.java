package com.lzk.easy;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/2 20:58
 */
public class Zifuchuan {
    // 字符串压缩
    public String compressString(String S) {
        StringBuilder  buffer = new StringBuilder();
        char[] x = S.toCharArray();
        for (int i = 0 ; i < S.length(); i++) {
            int index = 1;
            while (x[i] == x[i + 1] && i < S.length()) {
                index++;
                i++;
            }
            buffer.append(x[i]);
            buffer.append(index);
        }
        return buffer.toString().length() > S.length() ? S : buffer.toString();
    }
}
