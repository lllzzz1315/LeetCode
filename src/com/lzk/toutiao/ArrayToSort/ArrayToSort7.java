package com.lzk.toutiao.ArrayToSort;

import java.util.*;
/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/18 23:14
 */
public class ArrayToSort7 {

    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        String line = sa.nextLine();
        String[] str = line.split(" ");
        Interval[] ins = new Interval[str.length];
        for(int i =0; i < str.length; i++) {
            String[] tmp = str[i].split(",");
            ins[i] = new Interval(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }
        Arrays.sort(ins, Comparator.comparing(o -> o.lower));
        int cur = 0;
        for(int i = 1; i < ins.length; i++) {
            if(ins[i].lower <= ins[cur].upper) {
                ins[cur].upper = Math.max(ins[cur].upper, ins[i].upper);
            } else {
                System.out.print(ins[cur].lower + "," + ins[cur].upper + " ");
                cur = i;
            }
        }
        System.out.print(ins[cur].lower + "," + ins[cur].upper);
    }
}
class Interval {
    int lower;
    int upper;
    Interval(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
}
