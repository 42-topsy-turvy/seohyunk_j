// BOJ 1149 RGB 거리
package baekjoon.java;

import java.util.*;
import java.io.*;
public class BOJ_1149 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        int[][] costs = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            if(i == 0){
                dp[i][0] = costs[i][0];
                dp[i][1] = costs[i][1];
                dp[i][2] = costs[i][2];
            }
            else if((i >= 1) || i < N){
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
            }
            // else if(i == N-1){

            // }
            // if(i > 0) System.out.println("i - 1: " + (i - 1) + " " + dp[i - 1][0] + " " + dp[i - 1][1] + " " + dp[i - 1][2]);
            // System.out.println("i: " + i + " " + dp[i][0] + " " + dp[i][1] + " " + dp[i][2]);
            // System.out.println();
        }
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}

// 26 40 83
// 49 60 57  89 75 75
// 13 89 99  88 88 88
