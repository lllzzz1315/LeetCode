package com.lzk.easy;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/13 18:12
 * 面试题29. 顺时针打印矩阵
 */
public class Matrix {
//    public int[] spiralOrder(int[][] matrix) {
////        //获取行数
////        int lenY = matrix.length;
////        //获取列数
////        int lenX = matrix[0].length;
////        //如果只有1行，直接输出
////        if (lenY == 1) {
////            return matrix[0];
////        }
////        //如果多行情况，顺时针输出
////
////        for (int i = 0; i < lenY - 1; i++) {
////
////        }
////    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if (matrix[i][j]  == target) {
                    return true;
                }
                if (matrix[i][j]  > target) {
                    return false;
                }
            }
        }
        return false;
    }

    //有效字母异位词
    public boolean isAnagram(String s, String t) {
        char[] x1 = new char[256];
        char[] x2 = new char[256];
        for(int i = 0 ; i < s.length(); i++) {
            x1[s.charAt(i)]++;
            System.out.println(x1[s.charAt(i)]);
        }
        for(int i = 0 ; i < t.length(); i++) {
            x2[t.charAt(i)]++;
            System.out.println(x2[s.charAt(i)]);
        }
        return x1.equals(x2);
    }
}






