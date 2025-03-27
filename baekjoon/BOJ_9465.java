// BOJ 9465 스티커
package baekjoon.java;

import java.io.*;
import java.util.*;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){ // 테스트 개수
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            /*
             * 테스트 입력 시작
             */
            for(int j = 0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            /*
             * 테스트 입력 끝
             */
            
            int[][] dp = new int[2][n];
            for(int j = 0; j < n; j++){
                if(j == 0){
                    dp[0][0] = arr[0][0];
                    dp[1][0] = arr[1][0];
                }
                else if(j == 1){
                    dp[0][1] = dp[1][0] + arr[0][1];
                    dp[1][1] = dp[0][0] + arr[1][1];
                }
                else{
                    dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                    dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
                }
                // System.out.println("dp[0]["+j+"]: " + dp[0][j] + "  " + "dp[1]["+j+"]: " + dp[1][j]);
            }
            int max_score = Arrays.stream(dp)
                            .flatMapToInt(Arrays::stream)
                            .max().orElseThrow();
            System.out.println(max_score);
        }
    }
}
