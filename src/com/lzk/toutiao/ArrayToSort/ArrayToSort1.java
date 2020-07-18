package com.lzk.toutiao.ArrayToSort;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/18 21:34
 */
//岛屿最大面积
public class ArrayToSort1 {
    int[][] grid;
    boolean[][] marked;
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i =0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int a = dfs(grid, i ,j);
                    res = Math.max(res, a); }
            }
        }
        return res;
    }
    private static int dfs(int[][] grid, int i, int j) {
        if(!(0 <= i && i <grid.length && 0 <= j && j < grid[0].length)) return 0;
        if(grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        return 1 + dfs(grid, i, j + 1) + dfs(grid, i, j - 1)  + dfs(grid, i + 1, j) + dfs(grid, i - 1, j);
    }

}
