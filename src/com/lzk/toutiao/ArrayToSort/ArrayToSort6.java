package com.lzk.toutiao.ArrayToSort;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/18 22:53
 * 朋友圈（图搜索DFS）
 */
public class ArrayToSort6 {
    public int findCircleNum(int[][] M) {
        int res = 0;
        int len = M.length;
        boolean[] visited = new boolean[len];

        for(int i =0 ;i < len; i++) {
            if(!visited[i]) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        if(visited[i]) return;
        visited[i] = true;
        for(int j = 0; j < M.length; j++) {
            if(M[i][j] == 1) dfs(M, visited, j);
        }
    }
}
