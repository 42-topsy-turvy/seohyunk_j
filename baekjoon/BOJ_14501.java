// BOJ 14501 퇴사
package baekjoon.java;

import java.util.*;
import java.io.*;

public class BOJ_14501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N+1];
        int[] price = new int[N+1];
        int[] dp = new int[N+1];

        for(int i = 1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N+1; i++){
            if(i+time[i] <= N){
                dp[i+time[i]] = Math.max(dp[i + time[i]], dp[i] + price[i + time[i]]);
            }
            System.out.println(dp[i]);
        }
        System.out.println(Arrays.stream(dp).max().orElseThrow());
    }
}
