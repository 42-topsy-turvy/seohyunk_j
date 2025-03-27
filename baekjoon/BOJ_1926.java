// BOJ 1926 그림
package baekjoon.java;

import java.io.*;
import java.util.*;

public class BOJ_1926 {
    static int n;
    static int m;
    static int[][] grid = new int[n][m];
    static boolean[][] visited = new int[n][m];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y){
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
