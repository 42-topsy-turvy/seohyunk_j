// BOJ 1, 2, 3 더하기
package baekjoon.java;

import java.io.*;

public class BOJ_9095 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];

            for(int j = 1; j < n + 1; j++){
                if(j==1) dp[j] = 1;
                else if(j==2) dp[j] = 2;
                else if(j==3) dp[j] = 4;
                else dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[n]);
        }

    }
}
