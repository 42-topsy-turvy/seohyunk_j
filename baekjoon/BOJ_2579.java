// BOJ 2579 계단 오르기
package baekjoon.java;

import java.io.*;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] point = new int[T+1];
        int[] dp = new int[T+1];
        point[0] = 0;
        dp[0] = 0;

        for(int i  = 1; i < T+1; i++){
            point[i] = Integer.parseInt(br.readLine());
            if(i == 1) dp[i] = point[i];
            else if(i==2) dp[i] = dp[1] + point[i];
            else dp[i] = Math.max((dp[i - 2] + point[i]), (dp[i-3] + point[i-1] + point[i]));
        }
        System.out.println(dp[T]);
    }
}
