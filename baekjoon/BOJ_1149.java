// BOJ 1149 RGB 거리

import java.util.*;
import java.io.*;
public class BOJ_1149 {
    private static int N;
    private static int[][] dp;
    private static int[][] costs;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        costs = new int[N][3];

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

        }
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}
