package com.lzk.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/14 20:28
 */
public class ex1 {
    public int minArray(int[] numbers) {
        if(numbers.length == 1) {
            return numbers[0];
        }
        for(int i = 0;i < numbers.length; i++) {
            if(numbers[i] >= numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
    return  0;
    }
}

//矩阵中寻找路径问题
class Solution {
    public boolean exist(char[][] board, String word) {

        char[][] zhanwei = new char[board[0].length][board.length];
        //先找到首字符位置
        for (int i= 0; i < board[0].length; i++) {
            for (int j= 0; j < board.length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    zhanwei[i][j] = '0';
                    //开始往下层搜索
                    return find(board, word, i, j, 0, zhanwei);
                }
            }
        }
        return false;
    }

    //匹配参数

    private boolean find(char[][] board, String word, int i, int j, int count, char[][] zhanwei) {

        //终止符
        if(count == word.toCharArray().length - 1) {
            return true;
        }

        if (i < 0 || j < 0 || zhanwei[i][j] == '0' || i >= board[0].length || j >=  board.length) {
            return false;
        }

        char tmp = board[i][j];
        zhanwei[i][j] = '0';//被访问过

        boolean flag = find(board, word, i -1, j, count + 1, zhanwei)
                || find(board, word, i  + 1, j, count + 1, zhanwei)
                || find(board, word, i, j + 1, count + 1, zhanwei)
                || find(board, word, i , j - 1, count + 1, zhanwei);

        return flag;
    }
}